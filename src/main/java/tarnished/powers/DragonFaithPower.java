package tarnished.powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import tarnished.TarnishedMod;
import tarnished.relics.DragonHeartRelic;

public class DragonFaithPower extends AbstractPower {
    public static final String POWER_ID = TarnishedMod.makeID("DragonFaith");
    private static final PowerStrings STRINGS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    private static final int BASE_THRESHOLD = 10;

    public DragonFaithPower(AbstractCreature owner, int amount) {
        this.name = STRINGS.NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amount;
        this.type = PowerType.BUFF;
        Texture texture84 = ImageMaster.loadImage(TarnishedMod.resourcePath("images/powers/dragon_faith_power_84.png"));
        Texture texture32 = ImageMaster.loadImage(TarnishedMod.resourcePath("images/powers/dragon_faith_power_32.png"));
        this.region128 = new com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion(texture84, 0, 0, texture84.getWidth(), texture84.getHeight());
        this.region48 = new com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion(texture32, 0, 0, texture32.getWidth(), texture32.getHeight());
        updateDescription();
    }

    @Override
    public void stackPower(int stackAmount) {
        if (owner.hasPower(DragonmanPower.POWER_ID)) {
            addToTop(new GainEnergyAction(stackAmount));
            return;
        }
        amount += stackAmount;
        if (amount >= getThreshold()) {
            flash();
            addToTop(new ApplyPowerAction(owner, owner, new DragonmanPower(owner), 1));
            addToTop(new RemoveSpecificPowerAction(owner, owner, this));
        }
        updateDescription();
    }

    @Override
    public void onInitialApplication() {
        if (amount >= getThreshold()) {
            stackPower(0);
        }
    }

    @Override
    public void updateDescription() {
        this.description = STRINGS.DESCRIPTIONS[0] + amount + STRINGS.DESCRIPTIONS[1];
    }

    private int getThreshold() {
        return owner != null && owner.hasPower(DragonmanPower.POWER_ID) ? BASE_THRESHOLD
                : owner != null && owner.isPlayer && com.megacrit.cardcrawl.dungeons.AbstractDungeon.player != null
                && com.megacrit.cardcrawl.dungeons.AbstractDungeon.player.hasRelic(DragonHeartRelic.ID) ? 9 : BASE_THRESHOLD;
    }
}
