package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import tarnished.TarnishedMod;

public class Card045 extends AbstractTarnishedCard {
 public static final String ID=TarnishedMod.makeID("Card045");
 public Card045(){ super(ID,1,CardType.SKILL,CardRarity.COMMON,CardTarget.SELF); baseBlock=6; magicNumber=baseMagicNumber=1; }
 public void use(AbstractPlayer p, AbstractMonster m){ addToBot(new GainBlockAction(p,p,block)); addToBot(new ApplyPowerAction(p,p,new StrengthPower(p,magicNumber),magicNumber)); }
 public void upgrade(){ if(!upgraded){ upgradeName(); upgradeBaseCost(0); upgradeDescription(); } }
 public AbstractCard makeCopy(){ return new Card045(); }
}
