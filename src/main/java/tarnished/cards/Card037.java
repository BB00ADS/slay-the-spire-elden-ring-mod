package tarnished.cards;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.actions.DamageAllAndBleedIfUnblockedAction;

public class Card037 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card037");

    public Card037() {
        super(ID, 3, CardType.ATTACK, CardRarity.RARE, CardTarget.ALL_ENEMY);
        this.baseDamage = 4;
        this.magicNumber = this.baseMagicNumber = 3;
        this.isMultiDamage = true;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        int hits = upgraded ? 8 : 6;
        for (int i = 0; i < hits; i++) {
            addToBot(new DamageAllAndBleedIfUnblockedAction(multiDamage, damageTypeForTurn, magicNumber));
        }
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
        return new Card037();
    }
}
