package tarnished.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.util.CardTransformUtil;

public class Card033 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card033");

    public Card033() {
        super(ID, 1, CardType.ATTACK, CardRarity.SPECIAL, CardTarget.ALL_ENEMY);
        this.baseDamage = 15;
        this.isMultiDamage = true;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new DamageAllEnemiesAction(player, multiDamage, damageTypeForTurn, AttackEffect.FIRE));
        CardTransformUtil.transform(this, new Card032());
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card033();
    }
}
