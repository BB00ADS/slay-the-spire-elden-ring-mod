package tarnished.powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import tarnished.TarnishedMod;

public class GreatJarArsenalPower extends AbstractPower {
    public static final String POWER_ID = TarnishedMod.makeID("GreatJarArsenal");
    private static final PowerStrings STRINGS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);

    public GreatJarArsenalPower(AbstractCreature owner, int amount) {
        this.name = STRINGS.NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amount;
        this.type = PowerType.BUFF;
        Texture texture84 = ImageMaster.loadImage(TarnishedMod.resourcePath("images/powers/great_jar_arsenal_power_84.png"));
        Texture texture32 = ImageMaster.loadImage(TarnishedMod.resourcePath("images/powers/great_jar_arsenal_power_32.png"));
        this.region128 = new com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion(texture84, 0, 0, texture84.getWidth(), texture84.getHeight());
        this.region48 = new com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion(texture32, 0, 0, texture32.getWidth(), texture32.getHeight());
        updateDescription();
    }

    @Override
    public void atStartOfTurn() {
        addToBot(new GainBlockAction(owner, owner, amount));
    }

    @Override
    public void updateDescription() {
        this.description = STRINGS.DESCRIPTIONS[0] + amount + STRINGS.DESCRIPTIONS[1];
    }
}
