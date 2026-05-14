package tarnished.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.actions.ExhaustSwordAndGrowAction;

public class Card036 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card036");

    public Card036() {
        super(ID, 1, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        this.baseDamage = 10;
        markSwordAttack();
    }

    @Override
    public void applyPowers() {
        if (baseDamage < 10 + misc) {
            baseDamage = 10 + misc;
        }
        super.applyPowers();
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new ExhaustSwordAndGrowAction(this, upgraded ? 3 : 2));
        addToBot(new DamageAction(monster, new DamageInfo(player, damage, damageTypeForTurn), AttackEffect.SLASH_HEAVY));
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
        return new Card036();
    }
}
