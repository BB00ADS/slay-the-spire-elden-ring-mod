package tarnished.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import tarnished.powers.BleedPower;
import tarnished.relics.BloodLordExultationRelic;

public class ApplyBleedAction extends AbstractGameAction {
    private final AbstractCreature source;

    public ApplyBleedAction(AbstractCreature target, AbstractCreature source, int amount) {
        this.target = target;
        this.source = source;
        this.amount = amount;
    }

    @Override
    public void update() {
        if (target != null && !target.isDeadOrEscaped()) {
            int finalAmount = amount;
            if (source instanceof AbstractPlayer && source == AbstractDungeon.player && AbstractDungeon.player.hasRelic(BloodLordExultationRelic.ID)) {
                AbstractDungeon.player.getRelic(BloodLordExultationRelic.ID).flash();
                finalAmount *= 2;
            }
            addToTop(new ApplyPowerAction(target, source, new BleedPower(target, finalAmount), finalAmount));
        }
        isDone = true;
    }
}
