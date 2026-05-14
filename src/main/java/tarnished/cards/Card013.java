package tarnished.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.actions.ApplyBleedAction;

public class Card013 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card013");

    public Card013() {
        super(ID, 0, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        this.baseDamage = 4;
        this.magicNumber = this.baseMagicNumber = 15;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new DamageAction(monster, new DamageInfo(player, damage, damageTypeForTurn), AttackEffect.SLASH_HORIZONTAL));
        addToBot(new ApplyBleedAction(monster, player, magicNumber));
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
        return new Card013();
    }
}
