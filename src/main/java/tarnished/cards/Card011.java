package tarnished.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.util.CardTransformUtil;

public class Card011 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card011");

    public Card011() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        this.baseDamage = 6;
        this.cardsToPreview = new Card023();
        markSwordAttack();
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new DamageAction(monster, new DamageInfo(player, damage, damageTypeForTurn), AttackEffect.SLASH_HEAVY));
        CardTransformUtil.transform(this, new Card023());
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            this.cardsToPreview.upgrade();
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card011();
    }
}
