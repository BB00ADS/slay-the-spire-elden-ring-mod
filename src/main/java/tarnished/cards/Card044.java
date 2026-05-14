package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;

public class Card044 extends AbstractTarnishedCard {
 public static final String ID=TarnishedMod.makeID("Card044");
 public Card044(){ super(ID,1,CardType.SKILL,CardRarity.COMMON,CardTarget.SELF); baseBlock=10; }
 public void use(AbstractPlayer p, AbstractMonster m){ addToBot(new GainBlockAction(p,p,block)); }
 public void upgrade(){ if(!upgraded){ upgradeName(); upgradeBlock(3); upgradeDescription(); } }
 public AbstractCard makeCopy(){ return new Card044(); }
}
