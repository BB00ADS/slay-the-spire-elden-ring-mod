package tarnished.util;

import com.megacrit.cardcrawl.cards.AbstractCard;

public class CardTransformUtil {
    public static void transform(AbstractCard source, AbstractCard target) {
        boolean wasUpgraded = source.upgraded;
        if (wasUpgraded && !target.upgraded) {
            target.upgrade();
        }
        source.cardID = target.cardID;
        source.name = target.name;
        source.rawDescription = target.rawDescription;
        source.cost = target.cost;
        source.costForTurn = target.costForTurn;
        source.type = target.type;
        source.rarity = target.rarity;
        source.target = target.target;
        source.baseDamage = target.baseDamage;
        source.damage = target.damage;
        source.baseBlock = target.baseBlock;
        source.block = target.block;
        source.baseMagicNumber = target.baseMagicNumber;
        source.magicNumber = target.magicNumber;
        source.exhaust = target.exhaust;
        source.cardsToPreview = target.cardsToPreview;
        source.portrait = target.portrait;
        source.jokePortrait = target.jokePortrait;
        source.assetUrl = target.assetUrl;
        source.initializeDescription();
    }
}
