package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import tarnished.TarnishedMod;

public class Card065 extends AbstractTarnishedCard {
 public static final String ID=TarnishedMod.makeID("Card065");
 public Card065(){ super(ID,1,CardType.SKILL,CardRarity.RARE,CardTarget.SELF); magicNumber=baseMagicNumber=2; }
 public void use(AbstractPlayer p, AbstractMonster m){ addToBot(new ApplyPowerAction(p,p,new StrengthPower(p,magicNumber),magicNumber)); addToBot(new ApplyPowerAction(p,p,new DexterityPower(p,magicNumber),magicNumber)); }
 public void upgrade(){ if(!upgraded){ upgradeName(); upgradeBaseCost(0); upgradeDescription(); } }
 public AbstractCard makeCopy(){ return new Card065(); }
}
