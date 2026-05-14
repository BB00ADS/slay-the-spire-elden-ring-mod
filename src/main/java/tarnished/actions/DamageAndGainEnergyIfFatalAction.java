package tarnished.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class DamageAndGainEnergyIfFatalAction extends AbstractGameAction {
    private final DamageInfo info;
    private final int energyGain;

    public DamageAndGainEnergyIfFatalAction(AbstractCreature target, DamageInfo info, int energyGain) {
        this.target = target;
        this.info = info;
        this.energyGain = energyGain;
        this.actionType = ActionType.DAMAGE;
        this.attackEffect = AttackEffect.SLASH_HORIZONTAL;
    }

    @Override
    public void update() {
        if (target != null && !target.isDeadOrEscaped()) {
            target.damage(info);
            if ((target.isDying || target.currentHealth <= 0) && !target.halfDead) {
                addToTop(new GainEnergyAction(energyGain));
            }
        }
        isDone = true;
    }
}
