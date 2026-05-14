package tarnished.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.RelicStrings;
import tarnished.TarnishedMod;
import tarnished.powers.FrenzyFlamePower;

public class ShabririWoeRelic extends CustomRelic {
    public static final String ID = TarnishedMod.makeID("ShabririWoe");
    private static final RelicStrings STRINGS = CardCrawlGame.languagePack.getRelicStrings(ID);

    public ShabririWoeRelic() {
        super(ID, image("images/relics/shabriri_woe.png"), image("images/relics/shabriri_woe_outline.png"), RelicTier.RARE, LandingSound.MAGICAL);
    }

    @Override
    public void atTurnStart() {
        AbstractPlayer player = AbstractDungeon.player;
        if (player != null) {
            flash();
            addToBot(new ApplyPowerAction(player, player, new FrenzyFlamePower(player, 20), 20));
        }
    }

    public static void onFrenzyTriggered(AbstractPlayer player) {
        if (player != null && player.hasRelic(ID)) {
            player.getRelic(ID).flash();
            AbstractDungeon.actionManager.addToBottom(new HealAction(player, player, Math.max(1, player.maxHealth / 5)));
        }
    }

    @Override
    public String getUpdatedDescription() {
        return STRINGS.DESCRIPTIONS[0];
    }

    private static Texture image(String path) {
        return ImageMaster.loadImage(TarnishedMod.resourcePath(path));
    }
}
