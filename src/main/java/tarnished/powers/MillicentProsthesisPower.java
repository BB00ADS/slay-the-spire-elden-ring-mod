package tarnished.powers;

import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import tarnished.TarnishedMod;

public class MillicentProsthesisPower extends AbstractPower {
    public static final String POWER_ID = TarnishedMod.makeID("MillicentProsthesis");
    private static final PowerStrings STRINGS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    private int attacksThisTurn = 0;

    public MillicentProsthesisPower(AbstractCreature owner) {
        this.name = STRINGS.NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = -1;
        this.type = PowerType.BUFF;
        loadRegion("accuracy");
        updateDescription();
    }

    @Override
    public void atStartOfTurn() {
        attacksThisTurn = 0;
    }

    @Override
    public void onUseCard(AbstractCard card, com.megacrit.cardcrawl.actions.utility.UseCardAction action) {
        if (card.type == AbstractCard.CardType.ATTACK) {
            attacksThisTurn++;
        }
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        if (isPlayer && attacksThisTurn > 0) {
            addToBot(new DamageAllEnemiesAction(
                    null,
                    DamageInfo.createDamageMatrix(attacksThisTurn, true),
                    DamageInfo.DamageType.THORNS,
                    com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect.SLASH_HORIZONTAL
            ));
        }
    }

    @Override
    public void updateDescription() {
        this.description = STRINGS.DESCRIPTIONS[0];
    }
}
