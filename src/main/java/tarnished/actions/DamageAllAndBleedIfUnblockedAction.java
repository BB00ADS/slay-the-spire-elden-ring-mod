package tarnished.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class DamageAllAndBleedIfUnblockedAction extends AbstractGameAction {
    private final int[] multiDamage;
    private final DamageInfo.DamageType damageType;
    private final int bleedAmount;

    public DamageAllAndBleedIfUnblockedAction(int[] multiDamage, DamageInfo.DamageType damageType, int bleedAmount) {
        this.multiDamage = multiDamage;
        this.damageType = damageType;
        this.bleedAmount = bleedAmount;
        this.actionType = ActionType.DAMAGE;
        this.attackEffect = AttackEffect.SLASH_HEAVY;
    }

    @Override
    public void update() {
        for (int i = 0; i < AbstractDungeon.getMonsters().monsters.size(); i++) {
            AbstractMonster monster = AbstractDungeon.getMonsters().monsters.get(i);
            if (!monster.isDeadOrEscaped()) {
                monster.damage(new DamageInfo(AbstractDungeon.player, multiDamage[i], damageType));
                if (monster.lastDamageTaken > 0) {
                    addToTop(new ApplyBleedAction(monster, AbstractDungeon.player, bleedAmount));
                }
            }
        }
        isDone = true;
    }
}
