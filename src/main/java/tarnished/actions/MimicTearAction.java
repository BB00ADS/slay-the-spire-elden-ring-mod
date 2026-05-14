package tarnished.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class MimicTearAction extends AbstractGameAction {
    private final AbstractPlayer player;
    private final boolean chooseFromDeck;
    private boolean opened = false;

    public MimicTearAction(AbstractPlayer player, boolean chooseFromDeck) {
        this.player = player;
        this.chooseFromDeck = chooseFromDeck;
        this.actionType = ActionType.CARD_MANIPULATION;
        this.duration = Settings.ACTION_DUR_FAST;
    }

    @Override
    public void update() {
        if (!opened) {
            opened = true;
            if (chooseFromDeck) {
                CardGroup choices = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
                for (AbstractCard card : player.masterDeck.group) {
                    choices.addToBottom(card);
                }
                if (choices.isEmpty()) {
                    isDone = true;
                    return;
                }
                AbstractDungeon.gridSelectScreen.open(choices, 1, "选择要仿身的牌", false, false, false, false);
            } else {
                if (player.hand.isEmpty()) {
                    isDone = true;
                    return;
                }
                AbstractDungeon.handCardSelectScreen.open("选择要仿身的牌", 1, false, false);
            }
            tickDuration();
            return;
        }

        if (chooseFromDeck) {
            if (!AbstractDungeon.gridSelectScreen.selectedCards.isEmpty()) {
                AbstractCard copy = AbstractDungeon.gridSelectScreen.selectedCards.get(0).makeStatEquivalentCopy();
                addToTop(new MakeTempCardInHandAction(copy, 1));
                AbstractDungeon.gridSelectScreen.selectedCards.clear();
                isDone = true;
                return;
            }
        } else if (!AbstractDungeon.handCardSelectScreen.wereCardsRetrieved) {
            if (!AbstractDungeon.handCardSelectScreen.selectedCards.group.isEmpty()) {
                AbstractCard selected = AbstractDungeon.handCardSelectScreen.selectedCards.group.get(0);
                AbstractCard copy = selected.makeStatEquivalentCopy();
                addToTop(new MakeTempCardInHandAction(copy, 1));
                player.hand.addToTop(selected);
                player.hand.refreshHandLayout();
            }
            AbstractDungeon.handCardSelectScreen.wereCardsRetrieved = true;
            AbstractDungeon.handCardSelectScreen.selectedCards.group.clear();
            isDone = true;
            return;
        }

        tickDuration();
    }
}
