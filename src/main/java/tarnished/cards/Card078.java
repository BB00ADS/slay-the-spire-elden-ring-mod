package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.powers.GreatJarArsenalPower;

public class Card078 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card078");

    public Card078() {
        super(ID, 1, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        this.magicNumber = this.baseMagicNumber = 9;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new ApplyPowerAction(player, player, new GreatJarArsenalPower(player, magicNumber), magicNumber));
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeMagicNumber(3);
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card078();
    }
}
