package tarnished.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.util.ArrayList;

public class ClearDebuffsAction extends AbstractGameAction {
    public ClearDebuffsAction(AbstractCreature target) {
        this.target = target;
    }

    @Override
    public void update() {
        ArrayList<AbstractPower> debuffs = new ArrayList<>();
        for (AbstractPower power : target.powers) {
            if (power.type == AbstractPower.PowerType.DEBUFF) {
                debuffs.add(power);
            }
        }
        for (AbstractPower power : debuffs) {
            addToTop(new RemoveSpecificPowerAction(target, target, power));
        }
        isDone = true;
    }
}
