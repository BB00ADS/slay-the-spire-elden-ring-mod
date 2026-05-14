package tarnished.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import tarnished.TarnishedMod;
import tarnished.util.TarnishedEnums;

@SpirePatch(clz = AbstractPlayer.class, method = "damage")
public class CountHpLossThisTurnPatch {
    @SpirePostfixPatch
    public static void postfix(AbstractPlayer __instance, DamageInfo info) {
        if (__instance.chosenClass == TarnishedEnums.THE_TARNISHED && __instance.lastDamageTaken > 0) {
            TarnishedMod.hpLossEventsThisTurn++;
        }
    }
}
