package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import tarnished.TarnishedMod;

public class Card061 extends AbstractTarnishedCard {
 public static final String ID=TarnishedMod.makeID("Card061");
 public Card061(){ super(ID,2,CardType.SKILL,CardRarity.UNCOMMON,CardTarget.SELF); baseBlock=15; magicNumber=baseMagicNumber=2; }
 public void use(AbstractPlayer p, AbstractMonster m){ addToBot(new GainBlockAction(p,p,block)); for(AbstractMonster mo: AbstractDungeon.getMonsters().monsters) addToBot(new ApplyPowerAction(mo,p,new WeakPower(mo,magicNumber,false),magicNumber)); }
 public void upgrade(){ if(!upgraded){ upgradeName(); upgradeBlock(3); upgradeMagicNumber(1); upgradeDescription(); } }
 public AbstractCard makeCopy(){ return new Card061(); }
}
