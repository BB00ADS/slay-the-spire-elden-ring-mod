package tarnished.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import tarnished.TarnishedMod;

public class MelinaRelic extends CustomRelic {
    public static final String ID = TarnishedMod.makeID("Melina");
    public static final int GOLD_COST = 100;
    public static final int STRENGTH_GAIN = 2;
    public static final int DEXTERITY_GAIN = 2;
    public static final int MAX_HP_GAIN = 5;
    private static final RelicStrings STRINGS = CardCrawlGame.languagePack.getRelicStrings(ID);

    public MelinaRelic() {
        super(
                ID,
                image("images/relics/melina.png"),
                image("images/relics/melina_outline.png"),
                RelicTier.STARTER,
                LandingSound.MAGICAL
        );
    }

    @Override
    public String getUpdatedDescription() {
        return STRINGS.DESCRIPTIONS[0];
    }

    @Override
    public void onEquip() {
        if (counter < 0) {
            counter = 0;
        }
    }

    @Override
    public void atBattleStart() {
        int bonus = getStatBonus();
        if (bonus > 0) {
            flash();
            AbstractPlayer player = AbstractDungeon.player;
            addToBot(new ApplyPowerAction(player, player, new StrengthPower(player, bonus), bonus));
            addToBot(new ApplyPowerAction(player, player, new DexterityPower(player, bonus), bonus));
        }
    }

    public static boolean canCommune() {
        return AbstractDungeon.player != null
                && AbstractDungeon.player.hasRelic(ID)
                && AbstractDungeon.player.gold >= GOLD_COST;
    }

    public static void commune() {
        AbstractPlayer player = AbstractDungeon.player;
        if (player == null || !player.hasRelic(ID) || player.gold < GOLD_COST) {
            return;
        }

        MelinaRelic relic = (MelinaRelic) player.getRelic(ID);
        relic.flash();
        relic.counter = Math.max(0, relic.counter) + 1;
        player.loseGold(GOLD_COST);
        player.increaseMaxHp(MAX_HP_GAIN, true);
    }

    public static int getStatBonus() {
        AbstractPlayer player = AbstractDungeon.player;
        if (player == null || !player.hasRelic(ID)) {
            return 0;
        }
        MelinaRelic relic = (MelinaRelic) player.getRelic(ID);
        return Math.max(0, relic.counter) * STRENGTH_GAIN;
    }

    private static Texture image(String path) {
        return ImageMaster.loadImage(TarnishedMod.resourcePath(path));
    }
}
