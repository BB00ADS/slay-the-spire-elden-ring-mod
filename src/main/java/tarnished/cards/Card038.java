package tarnished.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;

public class Card038 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card038");
    public Card038(){ super(ID,3,CardType.ATTACK,CardRarity.RARE,CardTarget.ENEMY); baseDamage=40; exhaust=true; }
    public void use(AbstractPlayer p, AbstractMonster m){
        addToBot(new AbstractGameAction() {
            @Override
            public void update() {
                for (AbstractCard card : p.hand.group) {
                    if (card != Card038.this) {
                        AbstractDungeon.actionManager.addToTop(new ExhaustSpecificCardAction(card, p.hand));
                    }
                }
                isDone = true;
            }
        });
        if (m != null) {
            addToBot(new DamageAction(m,new DamageInfo(p,damage,damageTypeForTurn),AttackEffect.FIRE));
        }
    }
    public void upgrade(){ if(!upgraded){ upgradeName(); upgradeDamage(10); upgradeDescription(); } }
    public AbstractCard makeCopy(){ return new Card038(); }
}
