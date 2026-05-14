package tarnished.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import tarnished.TarnishedMod;

public class Card014 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card014");
    public Card014(){ super(ID,0,CardType.ATTACK,CardRarity.COMMON,CardTarget.ENEMY); baseDamage=4; magicNumber=baseMagicNumber=1; }
    public void use(AbstractPlayer p, AbstractMonster m){ addToBot(new DamageAction(m,new DamageInfo(p,damage,damageTypeForTurn),AttackEffect.SLASH_HORIZONTAL)); addToBot(new ApplyPowerAction(m,p,new WeakPower(m,magicNumber,false),magicNumber)); }
    public void upgrade(){ if(!upgraded){ upgradeName(); upgradeMagicNumber(1); upgradeDescription(); } }
    public AbstractCard makeCopy(){ return new Card014(); }
}
