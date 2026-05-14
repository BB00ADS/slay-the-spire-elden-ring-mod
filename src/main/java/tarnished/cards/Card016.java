package tarnished.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;

public class Card016 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card016");
    public Card016(){ super(ID,3,CardType.ATTACK,CardRarity.COMMON,CardTarget.ENEMY); baseDamage=12; }
    public void applyPowers(){ super.applyPowers(); setCostForTurn(Math.max(0, cost - TarnishedMod.cardsExhaustedThisTurn)); }
    public void use(AbstractPlayer p, AbstractMonster m){ addToBot(new DamageAction(m,new DamageInfo(p,damage,damageTypeForTurn),AttackEffect.SLASH_HEAVY)); }
    public void upgrade(){ if(!upgraded){ upgradeName(); upgradeDamage(4); upgradeDescription(); } }
    public AbstractCard makeCopy(){ return new Card016(); }
}
