package tarnished.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;

public class Card028 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card028");
    public Card028(){ super(ID,3,CardType.ATTACK,CardRarity.UNCOMMON,CardTarget.ENEMY); baseDamage=36; }
    public void use(AbstractPlayer p, AbstractMonster m){ for(int i=0;i<1;i++) addToBot(new DamageAction(m,new DamageInfo(p,damage,damageTypeForTurn),AttackEffect.SLASH_HEAVY)); }
    public void upgrade(){ if(!upgraded){ upgradeName(); upgradeDamage(6); upgradeDescription(); } }
    public AbstractCard makeCopy(){ return new Card028(); }
}
