package tarnished.characters;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import basemod.abstracts.CustomPlayer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.rooms.RestRoom;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import tarnished.TarnishedMod;
import tarnished.cards.Card001;
import tarnished.cards.Card002;
import tarnished.cards.Card003;
import tarnished.cards.Card004;
import tarnished.relics.MelinaRelic;
import tarnished.util.TarnishedEnums;

import java.util.ArrayList;

public class TarnishedCharacter extends CustomPlayer {
    public static final String ID = TarnishedMod.makeID("Tarnished");
    private static final CharacterStrings STRINGS = CardCrawlGame.languagePack.getCharacterString(ID);

    private static final int ENERGY_PER_TURN = 3;
    private static final int STARTING_HP = 75;
    private static final int MAX_HP = 75;
    private static final int STARTING_GOLD = 99;
    private static final int CARD_DRAW = 5;
    private static final int ORB_SLOTS = 0;
    private static final String ENERGY_ORB = TarnishedMod.resourcePath("images/ui/energy_orb.png");
    private static final String[] ORB_TEXTURES = {
            ENERGY_ORB,
            ENERGY_ORB,
            ENERGY_ORB,
            ENERGY_ORB,
            ENERGY_ORB,
            ENERGY_ORB,
            ENERGY_ORB
    };

    public TarnishedCharacter(String name, PlayerClass playerClass) {
        super(name, playerClass, ORB_TEXTURES, "images/ui/topPanel/energyRedVFX.png", (String) null, (String) null);
        initializeClass(
                TarnishedMod.resourcePath("images/char/tarnished/character.png"),
                TarnishedMod.resourcePath("images/char/tarnished/shoulder2.png"),
                TarnishedMod.resourcePath("images/char/tarnished/shoulder.png"),
                TarnishedMod.resourcePath("images/char/tarnished/corpse.png"),
                getLoadout(),
                20.0f, -10.0f, 220.0f, 290.0f,
                new EnergyManager(ENERGY_PER_TURN)
        );
    }

    @Override
    public ArrayList<String> getStartingDeck() {
        ArrayList<String> deck = new ArrayList<>();
        addCopies(deck, Card001.ID, 4);
        addCopies(deck, Card002.ID, 4);
        deck.add(Card003.ID);
        deck.add(Card004.ID);
        return deck;
    }

    @Override
    public ArrayList<String> getStartingRelics() {
        ArrayList<String> relics = new ArrayList<>();
        relics.add(MelinaRelic.ID);
        return relics;
    }

    @Override
    public CharSelectInfo getLoadout() {
        return new CharSelectInfo(
                STRINGS.NAMES[0],
                STRINGS.TEXT[0],
                STARTING_HP,
                MAX_HP,
                ORB_SLOTS,
                STARTING_GOLD,
                CARD_DRAW,
                this,
                getStartingRelics(),
                getStartingDeck(),
                false
        );
    }

    @Override
    public String getTitle(PlayerClass playerClass) {
        return STRINGS.NAMES[0];
    }

    @Override
    public AbstractCard.CardColor getCardColor() {
        return TarnishedEnums.TARNISHED_CARD_COLOR;
    }

    @Override
    public Color getCardRenderColor() {
        return Color.BROWN.cpy();
    }

    @Override
    public AbstractCard getStartCardForEvent() {
        return new Card001();
    }

    @Override
    public Color getCardTrailColor() {
        return Color.BROWN.cpy();
    }

    @Override
    public int getAscensionMaxHPLoss() {
        return 5;
    }

    @Override
    public BitmapFont getEnergyNumFont() {
        return FontHelper.energyNumFontRed;
    }

    @Override
    public void doCharSelectScreenSelectEffect() {
        CardCrawlGame.sound.playA("ATTACK_HEAVY", -0.2f);
        CardCrawlGame.screenShake.shake(ScreenShake.ShakeIntensity.MED, ScreenShake.ShakeDur.SHORT, false);
    }

    @Override
    public String getCustomModeCharacterButtonSoundKey() {
        return "ATTACK_HEAVY";
    }

    @Override
    public String getLocalizedCharacterName() {
        return STRINGS.NAMES[0];
    }

    @Override
    public AbstractPlayer newInstance() {
        return new TarnishedCharacter(name, chosenClass);
    }

    @Override
    public String getSpireHeartText() {
        return STRINGS.TEXT[1];
    }

    @Override
    public Color getSlashAttackColor() {
        return Color.BROWN.cpy();
    }

    @Override
    public AttackEffect[] getSpireHeartSlashEffect() {
        return new AttackEffect[]{
                AttackEffect.SLASH_HEAVY,
                AttackEffect.FIRE,
                AttackEffect.SLASH_DIAGONAL
        };
    }

    @Override
    public String getVampireText() {
        return STRINGS.TEXT[2];
    }

    @Override
    public void renderPlayerImage(SpriteBatch sb) {
        if (AbstractDungeon.getCurrRoom() instanceof RestRoom) {
            return;
        }
        super.renderPlayerImage(sb);
    }

    @Override
    public void render(SpriteBatch sb) {
        if (AbstractDungeon.getCurrRoom() instanceof RestRoom) {
            return;
        }
        super.render(sb);
    }

    private static void addCopies(ArrayList<String> deck, String id, int count) {
        for (int i = 0; i < count; i++) {
            deck.add(id);
        }
    }
}
