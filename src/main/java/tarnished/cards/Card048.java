package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.LoseDexterityPower;
import com.megacrit.cardcrawl.powers.DexterityPower;
import tarnished.TarnishedMod;

public class Card048 extends AbstractTarnishedCard {
 public static final String ID=TarnishedMod.makeID("Card048");
 public Card048(){ super(ID,1,CardType.SKILL,CardRarity.COMMON,CardTarget.SELF); baseBlock=9; magicNumber=baseMagicNumber=2; }
 public void use(AbstractPlayer p, AbstractMonster m){ addToBot(new ApplyPowerAction(p,p,new DexterityPower(p,magicNumber),magicNumber)); addToBot(new ApplyPowerAction(p,p,new LoseDexterityPower(p,magicNumber),magicNumber)); addToBot(new GainBlockAction(p,p,block)); }
 public void upgrade(){ if(!upgraded){ upgradeName(); upgradeBlock(1); upgradeMagicNumber(1); upgradeDescription(); } }
 public AbstractCard makeCopy(){ return new Card048(); }
}
