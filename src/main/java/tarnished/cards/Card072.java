package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.RegenPower;
import tarnished.TarnishedMod;

public class Card072 extends AbstractTarnishedCard {
 public static final String ID=TarnishedMod.makeID("Card072");
 public Card072(){ super(ID,1,CardType.POWER,CardRarity.UNCOMMON,CardTarget.SELF); magicNumber=baseMagicNumber=5; }
 public void use(AbstractPlayer p, AbstractMonster m){ addToBot(new ApplyPowerAction(p,p,new RegenPower(p,magicNumber),magicNumber)); }
 public void upgrade(){ if(!upgraded){ upgradeName(); upgradeMagicNumber(2); upgradeDescription(); } }
 public AbstractCard makeCopy(){ return new Card072(); }
}
