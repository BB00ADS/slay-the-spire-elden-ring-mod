package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.powers.GreatGoatPower;

public class Card076 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card076");

    public Card076() {
        super(ID, 2, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new ApplyPowerAction(player, player, new GreatGoatPower(player), 1));
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeBaseCost(1);
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card076();
    }
}
