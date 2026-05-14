package tarnished.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;

public class Card024 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card024");
    public Card024(){ super(ID,2,CardType.ATTACK,CardRarity.UNCOMMON,CardTarget.ALL_ENEMY); baseDamage=15; isMultiDamage=true; }
    public void use(AbstractPlayer p, AbstractMonster m){ addToBot(new DamageAllEnemiesAction(p,multiDamage,damageTypeForTurn,AttackEffect.SLASH_HEAVY)); }
    public void upgrade(){ if(!upgraded){ upgradeName(); upgradeDamage(3); upgradeDescription(); } }
    public AbstractCard makeCopy(){ return new Card024(); }
}
