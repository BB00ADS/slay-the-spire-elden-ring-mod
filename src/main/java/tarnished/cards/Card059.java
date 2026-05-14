package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.actions.ClearDebuffsAction;

public class Card059 extends AbstractTarnishedCard {
 public static final String ID=TarnishedMod.makeID("Card059");
 public Card059(){ super(ID,1,CardType.SKILL,CardRarity.UNCOMMON,CardTarget.SELF); baseBlock=8; exhaust=true; }
 public void use(AbstractPlayer p, AbstractMonster m){ addToBot(new GainBlockAction(p,p,block)); addToBot(new ClearDebuffsAction(p)); }
 public void upgrade(){ if(!upgraded){ upgradeName(); upgradeBaseCost(0); upgradeDescription(); } }
 public AbstractCard makeCopy(){ return new Card059(); }
}
