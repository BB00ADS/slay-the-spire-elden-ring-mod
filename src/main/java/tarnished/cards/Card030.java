package tarnished.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.powers.FrenzyFlamePower;

public class Card030 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card030");

    public Card030() {
        super(ID, 2, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ALL_ENEMY);
        this.baseDamage = 26;
        this.magicNumber = this.baseMagicNumber = 30;
        this.isMultiDamage = true;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new DamageAllEnemiesAction(player, multiDamage, damageTypeForTurn, AttackEffect.FIRE));
        addToBot(new ApplyPowerAction(player, player, new FrenzyFlamePower(player, magicNumber), magicNumber));
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeMagicNumber(-5);
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card030();
    }
}
