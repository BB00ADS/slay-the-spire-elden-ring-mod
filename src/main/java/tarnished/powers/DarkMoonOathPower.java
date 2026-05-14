package tarnished.powers;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import tarnished.TarnishedMod;

public class DarkMoonOathPower extends AbstractPower {
    public static final String POWER_ID = TarnishedMod.makeID("DarkMoonOath");
    private static final PowerStrings STRINGS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    private boolean usedThisTurn = false;

    public DarkMoonOathPower(AbstractCreature owner, int amount) {
        this.name = STRINGS.NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amount;
        this.type = PowerType.BUFF;
        loadRegion("accuracy");
        updateDescription();
    }

    @Override
    public void atStartOfTurn() {
        usedThisTurn = false;
    }

    @Override
    public float atDamageGive(float damage, com.megacrit.cardcrawl.cards.DamageInfo.DamageType type, AbstractCard card) {
        if (!usedThisTurn && card != null && card.type == AbstractCard.CardType.ATTACK && type == com.megacrit.cardcrawl.cards.DamageInfo.DamageType.NORMAL) {
            usedThisTurn = true;
            return damage + amount;
        }
        return damage;
    }

    @Override
    public void updateDescription() {
        this.description = STRINGS.DESCRIPTIONS[0] + amount + STRINGS.DESCRIPTIONS[1];
    }
}
