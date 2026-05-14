package tarnished;

import basemod.BaseMod;
import basemod.ModPanel;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.EditKeywordsSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.OnStartBattleSubscriber;
import basemod.interfaces.OnPlayerTurnStartSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import basemod.interfaces.PostBattleSubscriber;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.Gson;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import tarnished.cards.*;
import tarnished.characters.TarnishedCharacter;
import tarnished.powers.FrenzyFlamePower;
import tarnished.relics.*;
import tarnished.util.TarnishedEnums;

import java.util.HashMap;
import java.util.Map;

@SpireInitializer
public class TarnishedMod implements
        EditCardsSubscriber,
        EditCharactersSubscriber,
        EditKeywordsSubscriber,
        EditRelicsSubscriber,
        EditStringsSubscriber,
        OnPlayerTurnStartSubscriber,
        OnStartBattleSubscriber,
        PostBattleSubscriber,
        PostInitializeSubscriber {

    public static final String MOD_ID = "tarnished";
    public static final String ID_PREFIX = MOD_ID + ":";
    private static int carriedFrenzyFlame = 0;
    public static int turnStartHp = 0;
    public static int turnStartBlock = 0;
    public static int turnStartEnergy = 0;
    public static int turnStartStrength = 0;
    public static int turnStartDexterity = 0;
    public static boolean turnStartHadStrength = false;
    public static boolean turnStartHadDexterity = false;
    public static final Map<String, PowerSnapshot> turnStartDebuffs = new HashMap<>();
    public static int cardsExhaustedThisTurn = 0;
    public static int hpLossEventsThisTurn = 0;
    private static boolean hasTurnStartSnapshot = false;

    private static final Color TARNISHED_COLOR = CardHelper.getColor(126.0f, 93.0f, 61.0f);

    private static final String ATTACK_BG = resourcePath("images/ui/card_bg_attack.png");
    private static final String SKILL_BG = resourcePath("images/ui/card_bg_skill.png");
    private static final String POWER_BG = resourcePath("images/ui/card_bg_power.png");
    private static final String ENERGY_ORB = resourcePath("images/ui/card_small_orb.png");
    private static final String CARD_ENERGY_ORB = resourcePath("images/ui/card_small_orb.png");

    public TarnishedMod() {
        BaseMod.subscribe(this);
        BaseMod.addColor(
                TarnishedEnums.TARNISHED_CARD_COLOR,
                TARNISHED_COLOR, TARNISHED_COLOR, TARNISHED_COLOR, TARNISHED_COLOR,
                TARNISHED_COLOR, TARNISHED_COLOR, TARNISHED_COLOR,
                ATTACK_BG, SKILL_BG, POWER_BG, ENERGY_ORB,
                ATTACK_BG, SKILL_BG, POWER_BG, ENERGY_ORB,
                CARD_ENERGY_ORB
        );
    }

    public static void initialize() {
        new TarnishedMod();
    }

    public static String makeID(String id) {
        return ID_PREFIX + id;
    }

    public static String resourcePath(String path) {
        return "tarnishedResources/" + path;
    }

    @Override
    public void receiveEditStrings() {
        String lang = getLocalizationLang();
        BaseMod.loadCustomStringsFile(CardStrings.class, resourcePath("localization/" + lang + "/CardStrings.json"));
        BaseMod.loadCustomStringsFile(CharacterStrings.class, resourcePath("localization/" + lang + "/CharacterStrings.json"));
        BaseMod.loadCustomStringsFile(PowerStrings.class, resourcePath("localization/" + lang + "/PowerStrings.json"));
        BaseMod.loadCustomStringsFile(RelicStrings.class, resourcePath("localization/" + lang + "/RelicStrings.json"));
    }

    @Override
    public void receiveEditCharacters() {
        CharacterStrings strings = CardCrawlGame.languagePack.getCharacterString(TarnishedCharacter.ID);
        BaseMod.addCharacter(
                new TarnishedCharacter(strings.NAMES[0], TarnishedEnums.THE_TARNISHED),
                resourcePath("images/char/tarnished/button.png"),
                resourcePath("images/char/tarnished/portrait.png"),
                TarnishedEnums.THE_TARNISHED
        );
    }

    @Override
    public void receiveEditCards() {
BaseMod.addCard(new Card001());
        BaseMod.addCard(new Card002());
        BaseMod.addCard(new Card003());
        BaseMod.addCard(new Card004());
        BaseMod.addCard(new Card005());
        BaseMod.addCard(new Card006());
        BaseMod.addCard(new Card007());
        BaseMod.addCard(new Card008());
        BaseMod.addCard(new Card009());
        BaseMod.addCard(new Card010());
        BaseMod.addCard(new Card011());
        BaseMod.addCard(new Card012());
        BaseMod.addCard(new Card013());
        BaseMod.addCard(new Card014());
        BaseMod.addCard(new Card015());
        BaseMod.addCard(new Card016());
        BaseMod.addCard(new Card017());
        BaseMod.addCard(new Card018());
        BaseMod.addCard(new Card019());
        BaseMod.addCard(new Card020());
        BaseMod.addCard(new Card021());
        BaseMod.addCard(new Card022());
        BaseMod.addCard(new Card023());
        BaseMod.addCard(new Card024());
        BaseMod.addCard(new Card025());
        BaseMod.addCard(new Card026());
        BaseMod.addCard(new Card027());
        BaseMod.addCard(new Card028());
        BaseMod.addCard(new Card029());
        BaseMod.addCard(new Card030());
        BaseMod.addCard(new Card031());
        BaseMod.addCard(new Card032());
        BaseMod.addCard(new Card033());
        BaseMod.addCard(new Card034());
        BaseMod.addCard(new Card035());
        BaseMod.addCard(new Card036());
        BaseMod.addCard(new Card037());
        BaseMod.addCard(new Card038());
        BaseMod.addCard(new Card039());
        BaseMod.addCard(new Card040());
        BaseMod.addCard(new Card041());
        BaseMod.addCard(new Card042());
        BaseMod.addCard(new Card043());
        BaseMod.addCard(new Card044());
        BaseMod.addCard(new Card045());
        BaseMod.addCard(new Card046());
        BaseMod.addCard(new Card047());
        BaseMod.addCard(new Card048());
        BaseMod.addCard(new Card049());
        BaseMod.addCard(new Card050());
        BaseMod.addCard(new Card051());
        BaseMod.addCard(new Card052());
        BaseMod.addCard(new Card053());
        BaseMod.addCard(new Card054());
        BaseMod.addCard(new Card055());
        BaseMod.addCard(new Card056());
        BaseMod.addCard(new Card057());
        BaseMod.addCard(new Card058());
        BaseMod.addCard(new Card059());
        BaseMod.addCard(new Card060());
        BaseMod.addCard(new Card061());
        BaseMod.addCard(new Card062());
        BaseMod.addCard(new Card063());
        BaseMod.addCard(new Card064());
        BaseMod.addCard(new Card065());
        BaseMod.addCard(new Card066());
        BaseMod.addCard(new Card067());
        BaseMod.addCard(new Card068());
        BaseMod.addCard(new Card069());
        BaseMod.addCard(new Card070());
        BaseMod.addCard(new Card071());
        BaseMod.addCard(new Card072());
        BaseMod.addCard(new Card073());
        BaseMod.addCard(new Card074());
        BaseMod.addCard(new Card075());
        BaseMod.addCard(new Card076());
        BaseMod.addCard(new Card077());
        BaseMod.addCard(new Card078());
        BaseMod.addCard(new Card079());
        BaseMod.addCard(new Card080());
        BaseMod.addCard(new Card081());
        BaseMod.addCard(new Card082());
        BaseMod.addCard(new Card083());

        UnlockTracker.unlockCard(Card001.ID);
        UnlockTracker.unlockCard(Card002.ID);
        UnlockTracker.unlockCard(Card003.ID);
        UnlockTracker.unlockCard(Card004.ID);
        UnlockTracker.unlockCard(Card005.ID);
        UnlockTracker.unlockCard(Card006.ID);
        UnlockTracker.unlockCard(Card007.ID);
        UnlockTracker.unlockCard(Card008.ID);
        UnlockTracker.unlockCard(Card009.ID);
        UnlockTracker.unlockCard(Card010.ID);
        UnlockTracker.unlockCard(Card011.ID);
        UnlockTracker.unlockCard(Card012.ID);
        UnlockTracker.unlockCard(Card013.ID);
        UnlockTracker.unlockCard(Card014.ID);
        UnlockTracker.unlockCard(Card015.ID);
        UnlockTracker.unlockCard(Card016.ID);
        UnlockTracker.unlockCard(Card017.ID);
        UnlockTracker.unlockCard(Card018.ID);
        UnlockTracker.unlockCard(Card019.ID);
        UnlockTracker.unlockCard(Card020.ID);
        UnlockTracker.unlockCard(Card021.ID);
        UnlockTracker.unlockCard(Card022.ID);
        UnlockTracker.unlockCard(Card023.ID);
        UnlockTracker.unlockCard(Card024.ID);
        UnlockTracker.unlockCard(Card025.ID);
        UnlockTracker.unlockCard(Card026.ID);
        UnlockTracker.unlockCard(Card027.ID);
        UnlockTracker.unlockCard(Card028.ID);
        UnlockTracker.unlockCard(Card029.ID);
        UnlockTracker.unlockCard(Card030.ID);
        UnlockTracker.unlockCard(Card031.ID);
        UnlockTracker.unlockCard(Card032.ID);
        UnlockTracker.unlockCard(Card033.ID);
        UnlockTracker.unlockCard(Card034.ID);
        UnlockTracker.unlockCard(Card035.ID);
        UnlockTracker.unlockCard(Card036.ID);
        UnlockTracker.unlockCard(Card037.ID);
        UnlockTracker.unlockCard(Card038.ID);
        UnlockTracker.unlockCard(Card039.ID);
        UnlockTracker.unlockCard(Card040.ID);
        UnlockTracker.unlockCard(Card041.ID);
        UnlockTracker.unlockCard(Card042.ID);
        UnlockTracker.unlockCard(Card043.ID);
        UnlockTracker.unlockCard(Card044.ID);
        UnlockTracker.unlockCard(Card045.ID);
        UnlockTracker.unlockCard(Card046.ID);
        UnlockTracker.unlockCard(Card047.ID);
        UnlockTracker.unlockCard(Card048.ID);
        UnlockTracker.unlockCard(Card049.ID);
        UnlockTracker.unlockCard(Card050.ID);
        UnlockTracker.unlockCard(Card051.ID);
        UnlockTracker.unlockCard(Card052.ID);
        UnlockTracker.unlockCard(Card053.ID);
        UnlockTracker.unlockCard(Card054.ID);
        UnlockTracker.unlockCard(Card055.ID);
        UnlockTracker.unlockCard(Card056.ID);
        UnlockTracker.unlockCard(Card057.ID);
        UnlockTracker.unlockCard(Card058.ID);
        UnlockTracker.unlockCard(Card059.ID);
        UnlockTracker.unlockCard(Card060.ID);
        UnlockTracker.unlockCard(Card061.ID);
        UnlockTracker.unlockCard(Card062.ID);
        UnlockTracker.unlockCard(Card063.ID);
        UnlockTracker.unlockCard(Card064.ID);
        UnlockTracker.unlockCard(Card065.ID);
        UnlockTracker.unlockCard(Card066.ID);
        UnlockTracker.unlockCard(Card067.ID);
        UnlockTracker.unlockCard(Card068.ID);
        UnlockTracker.unlockCard(Card069.ID);
        UnlockTracker.unlockCard(Card070.ID);
        UnlockTracker.unlockCard(Card071.ID);
        UnlockTracker.unlockCard(Card072.ID);
        UnlockTracker.unlockCard(Card073.ID);
        UnlockTracker.unlockCard(Card074.ID);
        UnlockTracker.unlockCard(Card075.ID);
        UnlockTracker.unlockCard(Card076.ID);
        UnlockTracker.unlockCard(Card077.ID);
        UnlockTracker.unlockCard(Card078.ID);
        UnlockTracker.unlockCard(Card079.ID);
        UnlockTracker.unlockCard(Card080.ID);
        UnlockTracker.unlockCard(Card081.ID);
        UnlockTracker.unlockCard(Card082.ID);
        UnlockTracker.unlockCard(Card083.ID);
    }

    @Override
    public void receiveEditRelics() {
        BaseMod.addRelicToCustomPool(new MelinaRelic(), TarnishedEnums.TARNISHED_CARD_COLOR);
        BaseMod.addRelicToCustomPool(new AlexanderShardRelic(), TarnishedEnums.TARNISHED_CARD_COLOR);
        BaseMod.addRelicToCustomPool(new ShabririWoeRelic(), TarnishedEnums.TARNISHED_CARD_COLOR);
        BaseMod.addRelicToCustomPool(new BloodLordExultationRelic(), TarnishedEnums.TARNISHED_CARD_COLOR);
        BaseMod.addRelicToCustomPool(new DragonHeartRelic(), TarnishedEnums.TARNISHED_CARD_COLOR);
        BaseMod.addRelicToCustomPool(new DarkMoonRingRelic(), TarnishedEnums.TARNISHED_CARD_COLOR);
    }

    @Override
    public void receiveEditKeywords() {
        String json = Gdx.files.internal(resourcePath("localization/" + getLocalizationLang() + "/KeywordStrings.json")).readString("UTF-8");
        KeywordInfo[] keywords = new Gson().fromJson(json, KeywordInfo[].class);
        for (KeywordInfo keyword : keywords) {
            BaseMod.addKeyword(MOD_ID, keyword.PROPER_NAME, keyword.NAMES, keyword.DESCRIPTION);
        }
    }

    private static String getLocalizationLang() {
        return Settings.language == Settings.GameLanguage.ZHS ? "zhs" : "eng";
    }

    @Override
    public void receivePostInitialize() {
        Texture badge = ImageMaster.loadImage(resourcePath("images/ui/badge.png"));
        BaseMod.registerModBadge(
                badge,
                "The Tarnished",
                "Codex",
                "The Tarnished character mod. Current scope: batches 0-1.",
                new ModPanel()
        );
    }

    @Override
    public void receiveOnBattleStart(AbstractRoom room) {
        if (carriedFrenzyFlame > 0 && AbstractDungeon.player != null) {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(
                    AbstractDungeon.player,
                    AbstractDungeon.player,
                    new FrenzyFlamePower(AbstractDungeon.player, carriedFrenzyFlame),
                    carriedFrenzyFlame
            ));
        }
        captureTurnStartSnapshot();
    }

    @Override
    public void receiveOnPlayerTurnStart() {
        captureTurnStartSnapshot();
        cardsExhaustedThisTurn = 0;
        hpLossEventsThisTurn = 0;
    }

    public static boolean hasTurnStartSnapshot() {
        return hasTurnStartSnapshot;
    }

    @Override
    public void receivePostBattle(AbstractRoom room) {
        if (AbstractDungeon.player != null && AbstractDungeon.player.hasPower(FrenzyFlamePower.POWER_ID)) {
            carriedFrenzyFlame = AbstractDungeon.player.getPower(FrenzyFlamePower.POWER_ID).amount;
        } else {
            carriedFrenzyFlame = 0;
        }
    }

    private static class KeywordInfo {
        String PROPER_NAME;
        String[] NAMES;
        String DESCRIPTION;
    }

    public static void captureTurnStartSnapshot() {
        if (AbstractDungeon.player == null) {
            return;
        }
        turnStartHp = AbstractDungeon.player.currentHealth;
        turnStartBlock = AbstractDungeon.player.currentBlock;
        turnStartEnergy = AbstractDungeon.player.energy.energy;
        captureTurnStartPowers();
        hasTurnStartSnapshot = true;
    }

    private static void captureTurnStartPowers() {
        turnStartStrength = 0;
        turnStartDexterity = 0;
        turnStartHadStrength = false;
        turnStartHadDexterity = false;
        turnStartDebuffs.clear();

        for (AbstractPower power : AbstractDungeon.player.powers) {
            if ("Strength".equals(power.ID)) {
                turnStartHadStrength = true;
                turnStartStrength = power.amount;
            } else if ("Dexterity".equals(power.ID)) {
                turnStartHadDexterity = true;
                turnStartDexterity = power.amount;
            } else if (power.type == AbstractPower.PowerType.DEBUFF) {
                turnStartDebuffs.put(power.ID, new PowerSnapshot(power, power.amount));
            }
        }
    }

    public static class PowerSnapshot {
        public final AbstractPower power;
        public final int amount;

        private PowerSnapshot(AbstractPower power, int amount) {
            this.power = power;
            this.amount = amount;
        }
    }
}
