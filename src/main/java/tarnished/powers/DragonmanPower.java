package tarnished.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import tarnished.TarnishedMod;

public class DragonmanPower extends AbstractPower {
    public static final String POWER_ID = TarnishedMod.makeID("Dragonman");
    private static final PowerStrings STRINGS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);

    public DragonmanPower(AbstractCreature owner) {
        this.name = STRINGS.NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = -1;
        this.type = PowerType.BUFF;
        loadRegion("modeShift");
        updateDescription();
    }

    @Override
    public void updateDescription() {
        this.description = STRINGS.DESCRIPTIONS[0];
    }

    @Override
    public float atDamageFinalGive(float damage, DamageInfo.DamageType type) {
        return type == DamageInfo.DamageType.NORMAL ? damage * 2.0f : damage;
    }
}
