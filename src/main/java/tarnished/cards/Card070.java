package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.powers.DragonFaithPower;

public class Card070 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card070");

    public Card070() {
        super(ID, 3, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        this.magicNumber = this.baseMagicNumber = 2;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new MakeTempCardInHandAction(new Card005(), magicNumber));
        addToBot(new ApplyPowerAction(player, player, new DragonFaithPower(player, 2), 2));
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeMagicNumber(1);
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card070();
    }
}
