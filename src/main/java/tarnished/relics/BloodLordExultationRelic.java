package tarnished.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.RelicStrings;
import tarnished.TarnishedMod;

public class BloodLordExultationRelic extends CustomRelic {
    public static final String ID = TarnishedMod.makeID("BloodLordExultation");
    private static final RelicStrings STRINGS = CardCrawlGame.languagePack.getRelicStrings(ID);

    public BloodLordExultationRelic() {
        super(ID, image("images/relics/blood_lord_exultation.png"), image("images/relics/blood_lord_exultation_outline.png"), RelicTier.RARE, LandingSound.MAGICAL);
    }

    @Override
    public String getUpdatedDescription() {
        return STRINGS.DESCRIPTIONS[0];
    }

    private static Texture image(String path) {
        return ImageMaster.loadImage(TarnishedMod.resourcePath(path));
    }
}
