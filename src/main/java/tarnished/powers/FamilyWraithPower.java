package tarnished.powers;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import tarnished.TarnishedMod;
import tarnished.cards.Card041;

public class FamilyWraithPower extends AbstractPower {
    public static final String POWER_ID = TarnishedMod.makeID("FamilyWraith");
    private static final PowerStrings STRINGS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    private final boolean upgradedWraith;

    public FamilyWraithPower(AbstractCreature owner, boolean upgradedWraith) {
        this.name = STRINGS.NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = 1;
        this.upgradedWraith = upgradedWraith;
        this.type = PowerType.BUFF;
        loadRegion("nightmare");
        updateDescription();
    }

    @Override
    public void atStartOfTurnPostDraw() {
        Card041 wraith = new Card041();
        if (upgradedWraith) {
            wraith.upgrade();
        }
        addToBot(new MakeTempCardInHandAction(wraith, 1));
    }

    @Override
    public void updateDescription() {
        this.description = upgradedWraith ? STRINGS.DESCRIPTIONS[1] : STRINGS.DESCRIPTIONS[0];
    }
}
