package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BufferPower;
import tarnished.TarnishedMod;

public class Card042 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card042");
    public Card042(){ super(ID,0,CardType.SKILL,CardRarity.COMMON,CardTarget.SELF); baseBlock=4; }
    public void use(AbstractPlayer p, AbstractMonster m){ addToBot(new GainBlockAction(p,p,block)); if(p.currentBlock==0 && p.hand.size()<=1){ addToBot(new ApplyPowerAction(p,p,new BufferPower(p,1),1)); exhaust=true; } }
    public void upgrade(){ if(!upgraded){ upgradeName(); upgradeBlock(2); upgradeDescription(); } }
    public AbstractCard makeCopy(){ return new Card042(); }
}
