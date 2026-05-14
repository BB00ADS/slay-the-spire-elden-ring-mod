package tarnished.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.actions.ApplyBleedAction;

public class Card003 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card003");

    private static final int BLEED_PERCENT = 20;

    public Card003() {
        super(ID, 2, CardType.ATTACK, CardRarity.BASIC, CardTarget.ENEMY);
        this.baseDamage = 13;
        this.baseBlock = 10;
        this.magicNumber = this.baseMagicNumber = BLEED_PERCENT;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new DamageAction(monster, new DamageInfo(player, damage, damageTypeForTurn), AttackEffect.SLASH_HEAVY));
        addToBot(new ApplyBleedAction(monster, player, magicNumber));
        if (monster != null && isAttackIntent(monster)) {
            addToBot(new GainBlockAction(player, player, block));
        }
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeDamage(3);
            upgradeBlock(2);
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card003();
    }

    private boolean isAttackIntent(AbstractMonster monster) {
        return monster.intent == AbstractMonster.Intent.ATTACK
                || monster.intent == AbstractMonster.Intent.ATTACK_BUFF
                || monster.intent == AbstractMonster.Intent.ATTACK_DEBUFF
                || monster.intent == AbstractMonster.Intent.ATTACK_DEFEND;
    }
}
