package tarnished.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.actions.ApplyBleedAction;

public class Card012 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card012");

    public Card012() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        this.baseDamage = 7;
        this.magicNumber = this.baseMagicNumber = 5;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        int triggers = 0;
        for (AbstractCard card : AbstractDungeon.player.masterDeck.group) {
            if (card.cardID.equals(ID)) {
                triggers++;
            }
        }
        triggers = Math.max(1, triggers);
        for (int i = 0; i < triggers; i++) {
            addToBot(new DamageAction(monster, new DamageInfo(player, damage, damageTypeForTurn), AttackEffect.SLASH_HORIZONTAL));
            addToBot(new ApplyBleedAction(monster, player, magicNumber));
        }
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeDamage(2);
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card012();
    }
}
