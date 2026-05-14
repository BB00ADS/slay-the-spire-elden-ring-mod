package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.powers.DarkMoonOathPower;

public class Card079 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card079");

    public Card079() {
        super(ID, 2, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        this.magicNumber = this.baseMagicNumber = 10;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new ApplyPowerAction(player, player, new DarkMoonOathPower(player, magicNumber), magicNumber));
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeMagicNumber(5);
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card079();
    }
}
