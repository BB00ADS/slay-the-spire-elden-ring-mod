package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PlatedArmorPower;
import tarnished.TarnishedMod;

public class Card060 extends AbstractTarnishedCard {
 public static final String ID=TarnishedMod.makeID("Card060");
 public Card060(){ super(ID,1,CardType.SKILL,CardRarity.UNCOMMON,CardTarget.SELF); baseBlock=6; magicNumber=baseMagicNumber=3; }
 public void use(AbstractPlayer p, AbstractMonster m){ addToBot(new GainBlockAction(p,p,block)); addToBot(new ApplyPowerAction(p,p,new PlatedArmorPower(p,magicNumber),magicNumber)); }
 public void upgrade(){ if(!upgraded){ upgradeName(); upgradeBlock(2); upgradeMagicNumber(1); upgradeDescription(); } }
 public AbstractCard makeCopy(){ return new Card060(); }
}
