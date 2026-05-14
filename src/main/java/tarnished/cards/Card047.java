package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;

public class Card047 extends AbstractTarnishedCard {
 public static final String ID=TarnishedMod.makeID("Card047");
 public Card047(){ super(ID,0,CardType.SKILL,CardRarity.COMMON,CardTarget.SELF); magicNumber=baseMagicNumber=2; }
 public void use(AbstractPlayer p, AbstractMonster m){ addToBot(new LoseHPAction(p,p,3)); addToBot(new GainEnergyAction(magicNumber)); }
 public void upgrade(){ if(!upgraded){ upgradeName(); upgradeMagicNumber(1); upgradeDescription(); } }
 public AbstractCard makeCopy(){ return new Card047(); }
}
