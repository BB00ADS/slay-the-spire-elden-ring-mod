package tarnished.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.RelicStrings;
import tarnished.TarnishedMod;

public class DragonHeartRelic extends CustomRelic {
    public static final String ID = TarnishedMod.makeID("DragonHeart");
    private static final RelicStrings STRINGS = CardCrawlGame.languagePack.getRelicStrings(ID);

    public DragonHeartRelic() {
        super(ID, image("images/relics/dragon_heart.png"), image("images/relics/dragon_heart_outline.png"), RelicTier.RARE, LandingSound.MAGICAL);
    }

    @Override
    public String getUpdatedDescription() {
        return STRINGS.DESCRIPTIONS[0];
    }

    private static Texture image(String path) {
        return ImageMaster.loadImage(TarnishedMod.resourcePath(path));
    }
}
