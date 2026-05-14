package tarnished.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import tarnished.TarnishedMod;

public class GreatGoatPower extends AbstractPower {
    public static final String POWER_ID = TarnishedMod.makeID("GreatGoat");
    private static final PowerStrings STRINGS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    private boolean usedThisTurn = false;

    public GreatGoatPower(AbstractCreature owner) {
        this.name = STRINGS.NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = -1;
        this.type = PowerType.BUFF;
        loadRegion("barricade");
        updateDescription();
    }

    @Override
    public void atStartOfTurn() {
        usedThisTurn = false;
    }

    @Override
    public float modifyBlock(float blockAmount) {
        if (!usedThisTurn && blockAmount > 0) {
            usedThisTurn = true;
            return blockAmount * 2.0f;
        }
        return blockAmount;
    }

    @Override
    public void updateDescription() {
        this.description = STRINGS.DESCRIPTIONS[0];
    }
}
