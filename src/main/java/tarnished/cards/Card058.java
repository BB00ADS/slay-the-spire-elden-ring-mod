package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.powers.DragonFaithPower;

public class Card058 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card058");

    public Card058() {
        // TODO(待确认问题): 规格表缺少龙爪盾耗能；暂按 1 费实现。
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseBlock = 9;
        this.magicNumber = this.baseMagicNumber = 1;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new GainBlockAction(player, player, block));
        addToBot(new ApplyPowerAction(player, player, new DragonFaithPower(player, magicNumber), magicNumber));
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeBlock(3);
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card058();
    }
}
