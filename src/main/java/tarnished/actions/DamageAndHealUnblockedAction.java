package tarnished.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class DamageAndHealUnblockedAction extends AbstractGameAction {
    private final DamageInfo info;

    public DamageAndHealUnblockedAction(AbstractCreature target, DamageInfo info) {
        this.target = target;
        this.source = info.owner;
        this.info = info;
        this.actionType = ActionType.DAMAGE;
        this.attackEffect = AttackEffect.FIRE;
    }

    @Override
    public void update() {
        if (target != null && !target.isDeadOrEscaped()) {
            target.damage(info);
            if (target.lastDamageTaken > 0) {
                addToTop(new HealAction(source, source, target.lastDamageTaken));
            }
        }
        isDone = true;
    }
}
