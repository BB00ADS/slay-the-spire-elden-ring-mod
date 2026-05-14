package tarnished.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class DamageAndBleedIfUnblockedAction extends AbstractGameAction {
    private final DamageInfo info;
    private final int bleedAmount;

    public DamageAndBleedIfUnblockedAction(AbstractCreature target, DamageInfo info, int bleedAmount) {
        this.target = target;
        this.source = info.owner;
        this.info = info;
        this.bleedAmount = bleedAmount;
        this.actionType = ActionType.DAMAGE;
        this.attackEffect = AttackEffect.SLASH_HORIZONTAL;
    }

    @Override
    public void update() {
        if (target != null && !target.isDeadOrEscaped()) {
            target.damage(info);
            if (target.lastDamageTaken > 0) {
                addToTop(new ApplyBleedAction(target, source, bleedAmount));
            }
        }
        isDone = true;
    }
}
