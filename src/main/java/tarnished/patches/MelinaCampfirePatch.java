package tarnished.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.CampfireUI;
import com.megacrit.cardcrawl.ui.campfire.AbstractCampfireOption;
import tarnished.relics.MelinaRelic;
import tarnished.ui.MelinaCampfireOption;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MelinaCampfirePatch {
    @SpirePatch(clz = CampfireUI.class, method = "initializeButtons")
    public static class AddMelinaOption {
        @SpirePostfixPatch
        public static void postfix(CampfireUI __instance) {
            if (AbstractDungeon.player == null || !AbstractDungeon.player.hasRelic(MelinaRelic.ID)) {
                return;
            }

            try {
                Field buttonsField = CampfireUI.class.getDeclaredField("buttons");
                buttonsField.setAccessible(true);
                @SuppressWarnings("unchecked")
                ArrayList<AbstractCampfireOption> buttons =
                        (ArrayList<AbstractCampfireOption>) buttonsField.get(__instance);
                buttons.add(new MelinaCampfireOption());
            } catch (Exception ignored) {
            }
        }
    }
}
