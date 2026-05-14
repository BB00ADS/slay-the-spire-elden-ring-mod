package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.actions.DamageAndBleedIfUnblockedAction;

public class Card026 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card026");

    public Card026() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        this.baseDamage = 5;
        this.magicNumber = this.baseMagicNumber = 20;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new LoseHPAction(player, player, 3));
        for (int i = 0; i < 3; i++) {
            addToBot(new DamageAndBleedIfUnblockedAction(monster, new DamageInfo(player, damage, damageTypeForTurn), magicNumber));
        }
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeDamage(1);
            upgradeMagicNumber(5);
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card026();
    }
}
