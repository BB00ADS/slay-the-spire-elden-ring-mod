package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;

public class Card068 extends AbstractTarnishedCard {
 public static final String ID=TarnishedMod.makeID("Card068");
 public Card068(){ super(ID,2,CardType.SKILL,CardRarity.RARE,CardTarget.SELF); baseBlock=28; }
 public void use(AbstractPlayer p, AbstractMonster m){ addToBot(new GainBlockAction(p,p,block)); }
 public void upgrade(){ if(!upgraded){ upgradeName(); upgradeBlock(4); selfRetain=true; upgradeDescription(); } }
 public AbstractCard makeCopy(){ return new Card068(); }
}
