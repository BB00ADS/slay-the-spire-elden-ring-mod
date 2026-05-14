package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;

public class Card050 extends AbstractTarnishedCard {
 public static final String ID=TarnishedMod.makeID("Card050");
 public Card050(){ super(ID,1,CardType.SKILL,CardRarity.COMMON,CardTarget.SELF); baseBlock=8; magicNumber=baseMagicNumber=1; }
 public void use(AbstractPlayer p, AbstractMonster m){ addToBot(new GainBlockAction(p,p,block)); addToBot(new DrawCardAction(p,magicNumber)); }
 public void upgrade(){ if(!upgraded){ upgradeName(); upgradeBlock(3); upgradeDescription(); } }
 public AbstractCard makeCopy(){ return new Card050(); }
}
