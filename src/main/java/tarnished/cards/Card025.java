package tarnished.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;

public class Card025 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card025");

    public Card025() {
        super(ID, -1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        this.baseDamage = 10;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        int energy = energyOnUse < 0 ? player.energy.energy : energyOnUse;
        int hits = energy + (upgraded ? 1 : 0);
        for (int i = 0; i < hits; i++) {
            addToBot(new DamageAction(monster, new DamageInfo(player, damage, damageTypeForTurn), AttackEffect.SLASH_HEAVY));
        }
        if (!freeToPlayOnce) {
            player.energy.use(energy);
        }
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
        return new Card025();
    }
}
