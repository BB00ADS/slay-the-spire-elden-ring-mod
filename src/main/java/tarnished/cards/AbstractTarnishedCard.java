package tarnished.cards;

import basemod.abstracts.CustomCard;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.CardStrings;
import tarnished.TarnishedMod;
import tarnished.util.TarnishedEnums;

public abstract class AbstractTarnishedCard extends CustomCard {
    protected final CardStrings cardStrings;
    private Texture portraitTexture;

    public AbstractTarnishedCard(
            String id,
            int cost,
            AbstractCard.CardType type,
            AbstractCard.CardRarity rarity,
            AbstractCard.CardTarget target
    ) {
        super(
                id,
                CardCrawlGame.languagePack.getCardStrings(id).NAME,
                cardImagePath(id),
                cost,
                CardCrawlGame.languagePack.getCardStrings(id).DESCRIPTION,
                type,
                TarnishedEnums.TARNISHED_CARD_COLOR,
                rarity,
                target
        );
        this.cardStrings = CardCrawlGame.languagePack.getCardStrings(id);
        this.tags.add(TarnishedEnums.TARNISHED_CARD);
    }

    protected void upgradeDescription() {
        if (cardStrings.UPGRADE_DESCRIPTION != null) {
            this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
            initializeDescription();
        }
    }

    protected void markSwordAttack() {
        this.tags.add(TarnishedEnums.TARNISHED_SWORD_ATTACK);
    }

    @Override
    public AbstractCard makeStatEquivalentCopy() {
        AbstractCard copy = super.makeStatEquivalentCopy();
        if (copy instanceof CustomCard) {
            ((CustomCard) copy).loadCardImage(cardImagePath(cardID));
        }
        return copy;
    }

    @Override
    public Texture getPortraitImage() {
        if (portraitTexture == null) {
            portraitTexture = ImageMaster.loadImage(cardPortraitPath(cardID));
        }
        return portraitTexture;
    }

    private static String cardImagePath(String id) {
        String number = id.substring(id.length() - 3);
        return TarnishedMod.resourcePath("images/cards/" + number + ".png");
    }

    private static String cardPortraitPath(String id) {
        String number = id.substring(id.length() - 3);
        return TarnishedMod.resourcePath("images/cards/portraits/" + number + ".png");
    }
}
