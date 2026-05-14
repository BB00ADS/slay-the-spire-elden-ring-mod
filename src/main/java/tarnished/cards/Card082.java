package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.powers.FriendOfDragonsPower;

public class Card082 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card082");

    public Card082() {
        super(ID, 1, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new ApplyPowerAction(player, player, new FriendOfDragonsPower(player), 1));
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
        return new Card082();
    }
}
