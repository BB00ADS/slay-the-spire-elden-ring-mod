package tarnished.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.RelicStrings;
import tarnished.TarnishedMod;

public class DarkMoonRingRelic extends CustomRelic {
    public static final String ID = TarnishedMod.makeID("DarkMoonRing");
    private static final RelicStrings STRINGS = CardCrawlGame.languagePack.getRelicStrings(ID);

    public DarkMoonRingRelic() {
        super(ID, image("images/relics/dark_moon_ring.png"), image("images/relics/dark_moon_ring_outline.png"), RelicTier.RARE, LandingSound.CLINK);
    }

    @Override
    public void onExhaust(AbstractCard card) {
        flash();
        addToBot(new DamageAllEnemiesAction(
                null,
                DamageInfo.createDamageMatrix(3, true),
                DamageInfo.DamageType.THORNS,
                AbstractGameAction.AttackEffect.SLASH_HORIZONTAL
        ));
    }

    @Override
    public String getUpdatedDescription() {
        return STRINGS.DESCRIPTIONS[0];
    }

    private static Texture image(String path) {
        return ImageMaster.loadImage(TarnishedMod.resourcePath(path));
    }
}
