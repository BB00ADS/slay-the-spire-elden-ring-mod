package tarnished.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import tarnished.TarnishedMod;

public class LordOfFrenziedFlamePower extends AbstractPower {
    public static final String POWER_ID = TarnishedMod.makeID("LordOfFrenziedFlame");
    private static final PowerStrings STRINGS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    private final int frenzyPerTurn;

    public LordOfFrenziedFlamePower(AbstractCreature owner, int frenzyPerTurn) {
        this.name = STRINGS.NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = 1;
        this.frenzyPerTurn = frenzyPerTurn;
        this.type = PowerType.BUFF;
        loadRegion("doubleDamage");
        updateDescription();
    }

    @Override
    public float atDamageFinalGive(float damage, DamageInfo.DamageType type) {
        return type == DamageInfo.DamageType.NORMAL ? damage * (float) Math.pow(2.0, amount) : damage;
    }

    @Override
    public void atStartOfTurn() {
        addToBot(new ApplyPowerAction(owner, owner, new FrenzyFlamePower(owner, frenzyPerTurn), frenzyPerTurn));
    }

    public void onFrenzyTriggered() {
        amount++;
        updateDescription();
    }

    @Override
    public void updateDescription() {
        this.description = STRINGS.DESCRIPTIONS[0] + frenzyPerTurn + STRINGS.DESCRIPTIONS[1] + amount + STRINGS.DESCRIPTIONS[2];
    }
}
