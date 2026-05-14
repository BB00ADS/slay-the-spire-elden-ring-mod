package tarnished.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;

public class ExhaustAnyHandCardsDealDamageAction extends AbstractGameAction {
    private final AbstractPlayer player;
    private final int damage;
    private final DamageInfo.DamageType damageType;
    private boolean selectionOpened = false;

    public ExhaustAnyHandCardsDealDamageAction(AbstractPlayer player, int damage, DamageInfo.DamageType damageType) {
        this.player = player;
        this.damage = damage;
        this.damageType = damageType;
        this.actionType = ActionType.CARD_MANIPULATION;
        this.duration = Settings.ACTION_DUR_FAST;
    }

    @Override
    public void update() {
        if (!selectionOpened) {
            selectionOpened = true;
            if (player.hand.isEmpty()) {
                isDone = true;
                return;
            }
            AbstractDungeon.handCardSelectScreen.open("选择要消耗的牌", player.hand.size(), true, true);
            tickDuration();
            return;
        }

        if (!AbstractDungeon.handCardSelectScreen.wereCardsRetrieved) {
            int selectedCount = AbstractDungeon.handCardSelectScreen.selectedCards.group.size();
            ArrayList<AbstractCard> selectedCards = new ArrayList<>(AbstractDungeon.handCardSelectScreen.selectedCards.group);
            for (AbstractCard card : selectedCards) {
                AbstractDungeon.handCardSelectScreen.selectedCards.moveToExhaustPile(card);
            }
            for (int i = 0; i < selectedCount; i++) {
                addToBot(new DamageRandomEnemyAction(
                        new DamageInfo(player, damage, damageType),
                        AttackEffect.FIRE
                ));
            }
            AbstractDungeon.handCardSelectScreen.wereCardsRetrieved = true;
            AbstractDungeon.handCardSelectScreen.selectedCards.group.clear();
        }
        tickDuration();
    }
}
