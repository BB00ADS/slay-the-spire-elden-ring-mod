package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.powers.BloodflameBladePower;

public class Card063 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card063");

    public Card063() {
        super(ID, 0, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        this.magicNumber = this.baseMagicNumber = 4;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new LoseHPAction(player, player, 2));
        addToBot(new ApplyPowerAction(player, player, new BloodflameBladePower(player, magicNumber), magicNumber));
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeMagicNumber(2);
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card063();
    }
}
