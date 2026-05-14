package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;

public class Card057 extends AbstractTarnishedCard {
 public static final String ID=TarnishedMod.makeID("Card057");
 public Card057(){ super(ID,1,CardType.SKILL,CardRarity.UNCOMMON,CardTarget.SELF); magicNumber=baseMagicNumber=6; exhaust=true; }
 public void use(AbstractPlayer p, AbstractMonster m){ addToBot(new HealAction(p,p,magicNumber)); }
 public void upgrade(){ if(!upgraded){ upgradeName(); upgradeBaseCost(0); upgradeDescription(); } }
 public AbstractCard makeCopy(){ return new Card057(); }
}
