package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import tarnished.TarnishedMod;

public class Card053 extends AbstractTarnishedCard {
 public static final String ID=TarnishedMod.makeID("Card053");
 public Card053(){ super(ID,0,CardType.SKILL,CardRarity.UNCOMMON,CardTarget.ALL_ENEMY); magicNumber=baseMagicNumber=3; exhaust=true; }
 public void use(AbstractPlayer p, AbstractMonster m){ for(AbstractMonster mo: AbstractDungeon.getMonsters().monsters) addToBot(new ApplyPowerAction(mo,p,new VulnerablePower(mo,99,false),99)); addToBot(new ApplyPowerAction(p,p,new VulnerablePower(p,magicNumber,false),magicNumber)); }
 public void upgrade(){ if(!upgraded){ upgradeName(); upgradeMagicNumber(-1); upgradeDescription(); } }
 public AbstractCard makeCopy(){ return new Card053(); }
}
