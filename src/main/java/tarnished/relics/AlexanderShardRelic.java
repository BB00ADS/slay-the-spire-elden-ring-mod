package tarnished.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.RelicStrings;
import tarnished.TarnishedMod;

public class AlexanderShardRelic extends CustomRelic {
    public static final String ID = TarnishedMod.makeID("AlexanderShard");
    private static final RelicStrings STRINGS = CardCrawlGame.languagePack.getRelicStrings(ID);
    private boolean usedThisTurn = false;
    private AbstractCard activeCard = null;

    public AlexanderShardRelic() {
        super(ID, image("images/relics/alexander_shard.png"), image("images/relics/alexander_shard_outline.png"), RelicTier.RARE, LandingSound.HEAVY);
    }

    @Override
    public void atTurnStart() {
        usedThisTurn = false;
        activeCard = null;
    }

    @Override
    public void onPlayCard(AbstractCard card, com.megacrit.cardcrawl.monsters.AbstractMonster monster) {
        if (!usedThisTurn && card.type == AbstractCard.CardType.ATTACK) {
            usedThisTurn = true;
            activeCard = card;
            flash();
        }
    }

    @Override
    public float atDamageModify(float damage, AbstractCard card) {
        if (card == activeCard && card != null && card.type == AbstractCard.CardType.ATTACK) {
            return damage * 2.0f;
        }
        return damage;
    }

    @Override
    public String getUpdatedDescription() {
        return STRINGS.DESCRIPTIONS[0];
    }

    private static Texture image(String path) {
        return ImageMaster.loadImage(TarnishedMod.resourcePath(path));
    }
}
