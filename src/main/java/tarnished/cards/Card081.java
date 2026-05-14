package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.powers.LordOfFrenziedFlamePower;

public class Card081 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card081");

    public Card081() {
        super(ID, 0, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        this.magicNumber = this.baseMagicNumber = 40;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new ApplyPowerAction(player, player, new LordOfFrenziedFlamePower(player, magicNumber), 1));
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
        return new Card081();
    }
}
