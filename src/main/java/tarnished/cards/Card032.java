package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.util.CardTransformUtil;

public class Card032 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card032");

    public Card032() {
        super(ID, 1, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        this.baseBlock = 10;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new GainBlockAction(player, player, block));
        // TODO: 原效果为“下一张攻击牌耗能为0”；当前将手牌中攻击牌本回合费用降为0。
        for (AbstractCard card : player.hand.group) {
            if (card.type == CardType.ATTACK && card.costForTurn > 0) {
                card.setCostForTurn(0);
            }
        }
        CardTransformUtil.transform(this, new Card033());
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card032();
    }
}
