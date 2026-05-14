package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.powers.FrenzyFlamePower;

public class Card064 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card064");

    public Card064() {
        super(ID, 0, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        this.magicNumber = this.baseMagicNumber = 2;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new GainEnergyAction(magicNumber));
        addToBot(new ApplyPowerAction(player, player, new FrenzyFlamePower(player, 15), 15));
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeMagicNumber(1);
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card064();
    }
}
