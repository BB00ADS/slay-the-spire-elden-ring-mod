package tarnished.powers;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import tarnished.TarnishedMod;

public class FriendOfDragonsPower extends AbstractPower {
    public static final String POWER_ID = TarnishedMod.makeID("FriendOfDragons");
    private static final PowerStrings STRINGS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);

    public FriendOfDragonsPower(AbstractCreature owner) {
        this.name = STRINGS.NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = -1;
        this.type = PowerType.BUFF;
        loadRegion("curiosity");
        updateDescription();
    }

    @Override
    public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
        if (power.ID.equals(DragonmanPower.POWER_ID) && owner instanceof AbstractPlayer) {
            reduceDragonFaithCardCosts((AbstractPlayer) owner);
        }
    }

    private void reduceDragonFaithCardCosts(AbstractPlayer player) {
        for (AbstractCard card : player.hand.group) reduce(card);
        for (AbstractCard card : player.drawPile.group) reduce(card);
        for (AbstractCard card : player.discardPile.group) reduce(card);
    }

    private void reduce(AbstractCard card) {
        if (card.cost > 0 && (card.rawDescription.contains("龙信仰") || card.name.contains("龙"))) {
            card.updateCost(-1);
        }
    }

    @Override
    public void updateDescription() {
        this.description = STRINGS.DESCRIPTIONS[0];
    }
}
