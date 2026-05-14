package tarnished.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import tarnished.util.TarnishedEnums;

import java.util.ArrayList;

public class TarnishedRewardPatch {
    @SpirePatch(clz = AbstractDungeon.class, method = "getRewardCards")
    public static class NoNaturalUpgradedRewards {
        @SpirePostfixPatch
        public static ArrayList<AbstractCard> postfix(ArrayList<AbstractCard> cards) {
            for (int i = 0; i < cards.size(); i++) {
                AbstractCard card = cards.get(i);
                if (card.color == TarnishedEnums.TARNISHED_CARD_COLOR && card.upgraded) {
                    cards.set(i, card.makeCopy());
                }
            }
            return cards;
        }
    }
}
