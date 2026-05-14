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
import tarnished.relics.ShabririWoeRelic;

public class FrenzyFlamePower extends AbstractPower {
    public static final String POWER_ID = TarnishedMod.makeID("FrenzyFlame");
    private static final PowerStrings STRINGS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    private static final int TRIGGER_THRESHOLD = 100;

    public FrenzyFlamePower(AbstractCreature owner, int amount) {
        this.name = STRINGS.NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amount;
        this.type = PowerType.DEBUFF;
        Texture texture84 = ImageMaster.loadImage(TarnishedMod.resourcePath("images/powers/frenzy_flame_power_84.png"));
        Texture texture32 = ImageMaster.loadImage(TarnishedMod.resourcePath("images/powers/frenzy_flame_power_32.png"));
        this.region128 = new TextureAtlas.AtlasRegion(texture84, 0, 0, texture84.getWidth(), texture84.getHeight());
        this.region48 = new TextureAtlas.AtlasRegion(texture32, 0, 0, texture32.getWidth(), texture32.getHeight());
        updateDescription();
    }

    @Override
    public void stackPower(int stackAmount) {
        this.amount += stackAmount;
        if (this.amount >= TRIGGER_THRESHOLD) {
            flash();
            this.amount = 0;
            addToBot(new LoseHPAction(owner, owner, Math.max(1, owner.maxHealth / 3)));
            if (owner.hasPower(LordOfFrenziedFlamePower.POWER_ID)) {
                ((LordOfFrenziedFlamePower) owner.getPower(LordOfFrenziedFlamePower.POWER_ID)).onFrenzyTriggered();
            }
            if (owner.isPlayer) {
                ShabririWoeRelic.onFrenzyTriggered((com.megacrit.cardcrawl.characters.AbstractPlayer) owner);
            }
        }
        updateDescription();
    }

    @Override
    public void onInitialApplication() {
        if (amount >= TRIGGER_THRESHOLD) {
            stackPower(0);
        }
    }

    @Override
    public void updateDescription() {
        this.description = STRINGS.DESCRIPTIONS[0] + amount + STRINGS.DESCRIPTIONS[1];
    }
}
