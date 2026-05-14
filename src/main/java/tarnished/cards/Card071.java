package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.powers.FamilyWraithPower;

public class Card071 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card071");

    public Card071() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        this.cardsToPreview = new Card041();
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new ApplyPowerAction(player, player, new FamilyWraithPower(player, upgraded), 1));
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            this.cardsToPreview.upgrade();
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card071();
    }
}
