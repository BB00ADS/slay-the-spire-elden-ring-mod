package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.actions.MimicTearAction;

public class Card083 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card083");

    public Card083() {
        super(ID, 0, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        this.magicNumber = this.baseMagicNumber = 3;
        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new LoseHPAction(player, player, magicNumber));
        addToBot(new MimicTearAction(player, upgraded));
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
        return new Card083();
    }
}
