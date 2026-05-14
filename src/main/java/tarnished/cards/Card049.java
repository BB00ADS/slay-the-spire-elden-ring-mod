package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;
import tarnished.TarnishedMod;
import tarnished.powers.DragonFaithPower;

public class Card049 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card049");

    public Card049() {
        super(ID, 2, CardType.SKILL, CardRarity.COMMON, CardTarget.ALL_ENEMY);
        this.magicNumber = this.baseMagicNumber = 3;
        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        for (AbstractMonster m : AbstractDungeon.getMonsters().monsters) {
            addToBot(new ApplyPowerAction(m, player, new WeakPower(m, magicNumber, false), magicNumber));
            addToBot(new ApplyPowerAction(m, player, new VulnerablePower(m, magicNumber, false), magicNumber));
        }
        addToBot(new ApplyPowerAction(player, player, new DragonFaithPower(player, upgraded ? 3 : 2), upgraded ? 3 : 2));
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeMagicNumber(2);
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card049();
    }
}
