package tarnished.powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import tarnished.TarnishedMod;
import tarnished.actions.ApplyBleedAction;

public class BloodDynastyPower extends AbstractPower {
    public static final String POWER_ID = TarnishedMod.makeID("BloodDynasty");
    private static final PowerStrings STRINGS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);

    public BloodDynastyPower(AbstractCreature owner, int amount) {
        this.name = STRINGS.NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amount;
        this.type = PowerType.BUFF;
        Texture texture84 = ImageMaster.loadImage(TarnishedMod.resourcePath("images/powers/bleed_power_84.png"));
        Texture texture32 = ImageMaster.loadImage(TarnishedMod.resourcePath("images/powers/bleed_power_32.png"));
        this.region128 = new com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion(texture84, 0, 0, texture84.getWidth(), texture84.getHeight());
        this.region48 = new com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion(texture32, 0, 0, texture32.getWidth(), texture32.getHeight());
        updateDescription();
    }

    @Override
    public void onAttack(DamageInfo info, int damageAmount, AbstractCreature target) {
        if (target != owner && damageAmount > 0 && info.type == DamageInfo.DamageType.NORMAL) {
            addToBot(new ApplyBleedAction(target, owner, amount));
            addToBot(new HealAction(owner, owner, 1));
        }
    }

    @Override
    public void updateDescription() {
        this.description = STRINGS.DESCRIPTIONS[0] + amount + STRINGS.DESCRIPTIONS[1];
    }
}
