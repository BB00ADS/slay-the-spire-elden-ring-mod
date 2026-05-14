package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;

public class Card052 extends AbstractTarnishedCard {
 public static final String ID=TarnishedMod.makeID("Card052");
 public Card052(){ super(ID,2,CardType.SKILL,CardRarity.COMMON,CardTarget.SELF); baseBlock=16; }
 public void use(AbstractPlayer p, AbstractMonster m){ addToBot(new LoseHPAction(p,p,1)); addToBot(new GainBlockAction(p,p,block)); }
 public void upgrade(){ if(!upgraded){ upgradeName(); upgradeBlock(5); upgradeDescription(); } }
 public AbstractCard makeCopy(){ return new Card052(); }
}
