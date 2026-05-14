package tarnished.cards;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.actions.ExhaustAnyHandCardsDealDamageAction;

public class Card066 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card066");

    public Card066() {
        super(ID, 2, CardType.SKILL, CardRarity.RARE, CardTarget.ALL_ENEMY);
        this.baseDamage = 7;
        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new ExhaustAnyHandCardsDealDamageAction(player, damage, damageTypeForTurn));
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeDamage(2);
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card066();
    }
}
