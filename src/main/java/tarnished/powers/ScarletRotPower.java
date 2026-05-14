package tarnished.powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import tarnished.TarnishedMod;

public class ScarletRotPower extends AbstractPower {
    public static final String POWER_ID = TarnishedMod.makeID("ScarletRot");
    private static final PowerStrings STRINGS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);

    public ScarletRotPower(AbstractCreature owner, int amount) {
        this.name = STRINGS.NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amount;
        this.type = PowerType.DEBUFF;
        this.isTurnBased = true;
        Texture texture84 = ImageMaster.loadImage(TarnishedMod.resourcePath("images/powers/scarlet_rot_power_84.png"));
        Texture texture32 = ImageMaster.loadImage(TarnishedMod.resourcePath("images/powers/scarlet_rot_power_32.png"));
        this.region128 = new TextureAtlas.AtlasRegion(texture84, 0, 0, texture84.getWidth(), texture84.getHeight());
        this.region48 = new TextureAtlas.AtlasRegion(texture32, 0, 0, texture32.getWidth(), texture32.getHeight());
        updateDescription();
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        if (!isPlayer) {
            addToBot(new LoseHPAction(owner, owner, Math.max(1, Math.round(owner.maxHealth * 0.05f))));
            amount--;
            if (amount <= 0) {
                addToBot(new com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction(owner, owner, this));
            }
            updateDescription();
        }
    }

    @Override
    public void updateDescription() {
        this.description = STRINGS.DESCRIPTIONS[0] + amount + STRINGS.DESCRIPTIONS[1];
    }
}
