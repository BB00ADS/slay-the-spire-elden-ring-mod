package tarnished.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import tarnished.TarnishedMod;
import tarnished.util.TarnishedEnums;

@SpirePatch(clz = AbstractCard.class, method = "triggerOnExhaust")
public class CountExhaustedCardsThisTurnPatch {
    @SpirePostfixPatch
    public static void postfix(AbstractCard __instance) {
        if (AbstractDungeon.player != null && AbstractDungeon.player.chosenClass == TarnishedEnums.THE_TARNISHED) {
            TarnishedMod.cardsExhaustedThisTurn++;
        }
    }
}
