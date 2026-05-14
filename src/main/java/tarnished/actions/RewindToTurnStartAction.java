package tarnished.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import tarnished.TarnishedMod;

import java.util.Iterator;
import java.util.Map;

public class RewindToTurnStartAction extends AbstractGameAction {
    @Override
    public void update() {
        if (AbstractDungeon.player != null && TarnishedMod.hasTurnStartSnapshot()) {
            AbstractPlayer player = AbstractDungeon.player;
            player.currentHealth = Math.max(0, Math.min(TarnishedMod.turnStartHp, player.maxHealth));
            player.healthBarUpdatedEvent();
            player.currentBlock = 0;
            if (TarnishedMod.turnStartBlock > 0) {
                player.addBlock(TarnishedMod.turnStartBlock);
            }
            player.energy.energy = TarnishedMod.turnStartEnergy;
            EnergyPanel.setEnergy(TarnishedMod.turnStartEnergy);
            restoreStrengthAndDexterity(player);
            restoreDebuffs(player);
        }
        isDone = true;
    }

    private static void restoreStrengthAndDexterity(AbstractPlayer player) {
        restorePower(player, "Strength", TarnishedMod.turnStartHadStrength, TarnishedMod.turnStartStrength);
        restorePower(player, "Dexterity", TarnishedMod.turnStartHadDexterity, TarnishedMod.turnStartDexterity);
    }

    private static void restorePower(AbstractPlayer player, String id, boolean existedAtTurnStart, int amount) {
        AbstractPower current = player.getPower(id);
        if (!existedAtTurnStart) {
            if (current != null) {
                player.powers.remove(current);
            }
            return;
        }

        if (current == null) {
            current = "Strength".equals(id) ? new StrengthPower(player, amount) : new DexterityPower(player, amount);
            player.powers.add(current);
        } else {
            current.amount = amount;
        }
        current.updateDescription();
    }

    private static void restoreDebuffs(AbstractPlayer player) {
        Iterator<AbstractPower> iterator = player.powers.iterator();
        while (iterator.hasNext()) {
            AbstractPower power = iterator.next();
            if (power.type == AbstractPower.PowerType.DEBUFF && !TarnishedMod.turnStartDebuffs.containsKey(power.ID)) {
                iterator.remove();
            }
        }

        for (Map.Entry<String, TarnishedMod.PowerSnapshot> entry : TarnishedMod.turnStartDebuffs.entrySet()) {
            AbstractPower current = player.getPower(entry.getKey());
            TarnishedMod.PowerSnapshot snapshot = entry.getValue();
            if (current == null) {
                current = snapshot.power;
                current.owner = player;
                player.powers.add(current);
            }
            current.amount = snapshot.amount;
            current.updateDescription();
        }
    }
}
