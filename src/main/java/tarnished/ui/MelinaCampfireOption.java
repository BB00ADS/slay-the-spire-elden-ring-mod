package tarnished.ui;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.helpers.input.InputHelper;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.ui.campfire.AbstractCampfireOption;
import tarnished.TarnishedMod;
import tarnished.relics.MelinaRelic;

public class MelinaCampfireOption extends AbstractCampfireOption {
    private static final RelicStrings STRINGS = CardCrawlGame.languagePack.getRelicStrings(MelinaRelic.ID);
    private static final Texture ICON = ImageMaster.loadImage(TarnishedMod.resourcePath("images/ui/melina_campfire.png"));

    public MelinaCampfireOption() {
        label = STRINGS.DESCRIPTIONS[1];
        img = ICON;
        refreshState();
    }

    @Override
    public void update() {
        hb.update();
        if (hb.hovered && InputHelper.justClickedLeft) {
            hb.clickStarted = true;
        }
        if (hb.clicked) {
            hb.clicked = false;
            useOption();
        }
    }

    @Override
    public void useOption() {
        if (!usable) {
            return;
        }
        MelinaRelic.commune();
        refreshState();
    }

    private void refreshState() {
        usable = MelinaRelic.canCommune();
        description = usable ? STRINGS.DESCRIPTIONS[2] : STRINGS.DESCRIPTIONS[3];
    }
}
