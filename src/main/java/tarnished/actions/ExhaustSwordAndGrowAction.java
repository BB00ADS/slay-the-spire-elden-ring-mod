package tarnished.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import tarnished.cards.Card036;
import tarnished.util.TarnishedEnums;

public class ExhaustSwordAndGrowAction extends AbstractGameAction {
    private final Card036 swordGrave;
    private final int growth;

    public ExhaustSwordAndGrowAction(Card036 swordGrave, int growth) {
        this.swordGrave = swordGrave;
        this.growth = growth;
    }

    @Override
    public void update() {
        AbstractPlayer player = AbstractDungeon.player;
        AbstractCard toExhaust = null;
        for (AbstractCard card : player.hand.group) {
            if (card != swordGrave && card.hasTag(TarnishedEnums.TARNISHED_SWORD_ATTACK)) {
                toExhaust = card;
                break;
            }
        }

        if (toExhaust != null) {
            addToTop(new ExhaustSpecificCardAction(toExhaust, player.hand));
            swordGrave.misc += growth;
            swordGrave.baseDamage += growth;
            swordGrave.applyPowers();
            for (AbstractCard card : player.masterDeck.group) {
                if (card.uuid.equals(swordGrave.uuid)) {
                    card.misc = swordGrave.misc;
                    card.baseDamage += growth;
                    card.applyPowers();
                    break;
                }
            }
        }
        isDone = true;
    }
}
