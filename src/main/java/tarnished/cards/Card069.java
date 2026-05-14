package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import tarnished.TarnishedMod;
import tarnished.powers.ScarletRotPower;

public class Card069 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card069");

    public Card069() {
        super(ID, 1, CardType.SKILL, CardRarity.RARE, CardTarget.ALL_ENEMY);
        this.magicNumber = this.baseMagicNumber = 99;
        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        for (AbstractMonster m : AbstractDungeon.getMonsters().monsters) {
            if (m.hasPower(ArtifactPower.POWER_ID)) {
                addToBot(new RemoveSpecificPowerAction(m, player, ArtifactPower.POWER_ID));
            }
            addToBot(new ApplyPowerAction(m, player, new ScarletRotPower(m, magicNumber), magicNumber));
        }
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeBaseCost(0);
            this.exhaust = false;
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card069();
    }
}
