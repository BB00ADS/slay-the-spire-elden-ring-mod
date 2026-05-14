package tarnished.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;

public class Card034 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card034");

    public Card034() {
        super(ID, -1, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        this.baseDamage = 5;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        int energy = energyOnUse;
        if (energy < 0) {
            energy = player.energy.energy;
        }
        if (freeToPlayOnce) {
            energy = 0;
        }
        for (int i = 0; i < energy * 2; i++) {
            addToBot(new DamageAction(monster, new DamageInfo(player, damage, damageTypeForTurn), AttackEffect.SLASH_HORIZONTAL));
        }
        if (!freeToPlayOnce) {
            player.energy.use(energy);
        }
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
        return new Card034();
    }
}
