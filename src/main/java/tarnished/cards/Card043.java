package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.util.CardTransformUtil;

public class Card043 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card043");

    public Card043() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        this.baseBlock = 6;
        this.cardsToPreview = new Card055();
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new GainBlockAction(player, player, block));
        CardTransformUtil.transform(this, new Card055());
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeBlock(3);
            this.cardsToPreview.upgrade();
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card043();
    }
}
