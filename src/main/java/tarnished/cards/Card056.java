package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;

public class Card056 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card056");

    public Card056() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        this.magicNumber = this.baseMagicNumber = 3;
        this.cardsToPreview = new Card041();
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new ExhaustAction(player, player, 1, false, false));
        addToBot(new MakeTempCardInHandAction(new Card041(), magicNumber));
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
        return new Card056();
    }
}
