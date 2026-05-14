package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;

public class Card062 extends AbstractTarnishedCard {
 public static final String ID=TarnishedMod.makeID("Card062");
 public Card062(){ super(ID,1,CardType.SKILL,CardRarity.UNCOMMON,CardTarget.SELF); magicNumber=baseMagicNumber=1; }
 public void use(AbstractPlayer p, AbstractMonster m){ addToBot(new HealAction(p,p,Math.max(0, TarnishedMod.hpLossEventsThisTurn))); }
 public void upgrade(){ if(!upgraded){ upgradeName(); upgradeBaseCost(0); upgradeDescription(); } }
 public AbstractCard makeCopy(){ return new Card062(); }
}
