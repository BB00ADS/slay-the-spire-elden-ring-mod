package tarnished.powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import tarnished.TarnishedMod;

public class BleedPower extends AbstractPower {
    public static final String POWER_ID = TarnishedMod.makeID("Bleed");
    private static final PowerStrings STRINGS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    private static final int TRIGGER_THRESHOLD = 100;
    private static final float MAX_HP_DAMAGE_RATIO = 0.15f;

    public BleedPower(AbstractCreature owner, int amount) {
        this.name = STRINGS.NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amount;
        this.type = PowerType.DEBUFF;
        this.isTurnBased = false;
        Texture texture84 = ImageMaster.loadImage(TarnishedMod.resourcePath("images/powers/bleed_power_84.png"));
        Texture texture32 = ImageMaster.loadImage(TarnishedMod.resourcePath("images/powers/bleed_power_32.png"));
        this.region128 = new com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion(texture84, 0, 0, texture84.getWidth(), texture84.getHeight());
        this.region48 = new com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion(texture32, 0, 0, texture32.getWidth(), texture32.getHeight());
        updateDescription();
    }

    @Override
    public void stackPower(int stackAmount) {
        this.amount += stackAmount;
        while (this.amount >= TRIGGER_THRESHOLD) {
            flash();
            this.amount -= TRIGGER_THRESHOLD;
            int hpLoss = Math.max(1, Math.round(owner.maxHealth * MAX_HP_DAMAGE_RATIO));
            addToBot(new LoseHPAction(owner, owner, hpLoss));
        }
        updateDescription();
    }

    @Override
    public void onInitialApplication() {
        if (this.amount >= TRIGGER_THRESHOLD) {
            stackPower(0);
        }
    }

    @Override
    public void updateDescription() {
        this.description = STRINGS.DESCRIPTIONS[0] + amount + STRINGS.DESCRIPTIONS[1];
    }
}
