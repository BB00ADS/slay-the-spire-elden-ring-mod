package tarnished.cards;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.actions.DamageAndGainEnergyIfFatalAction;

public class Card006 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card006");

    public Card006() {
        super(ID, 0, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        this.baseDamage = 3;
        this.magicNumber = this.baseMagicNumber = 1;
        markSwordAttack();
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new DamageAndGainEnergyIfFatalAction(
                monster,
                new DamageInfo(player, damage, damageTypeForTurn),
                magicNumber
        ));
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
        return new Card006();
    }
}
