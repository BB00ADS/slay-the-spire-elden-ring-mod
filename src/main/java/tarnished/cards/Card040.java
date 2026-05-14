package tarnished.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.powers.DragonmanPower;

public class Card040 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card040");

    public Card040() {
        super(ID, 5, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        this.baseDamage = 0;
    }

    @Override
    public boolean canUse(AbstractPlayer player, AbstractMonster monster) {
        if (!super.canUse(player, monster)) {
            return false;
        }
        if (!player.hasPower(DragonmanPower.POWER_ID)) {
            cantUseMessage = "只有龙人能打出此牌。";
            return false;
        }
        return true;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        // TODO(待确认问题): “50%最大生命值”当前按目标敌人的最大生命值计算。
        int amount = Math.max(1, monster.maxHealth / 2);
        addToBot(new DamageAction(monster, new DamageInfo(player, amount, damageTypeForTurn), AttackEffect.SLASH_HEAVY));
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeBaseCost(4);
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card040();
    }
}
