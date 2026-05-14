package tarnished.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.LoseStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import tarnished.TarnishedMod;

public class Card017 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card017");
    public Card017(){ super(ID,1,CardType.ATTACK,CardRarity.COMMON,CardTarget.ENEMY); baseDamage=9; magicNumber=baseMagicNumber=2; }
    public void use(AbstractPlayer p, AbstractMonster m){ addToBot(new ApplyPowerAction(p,p,new StrengthPower(p,magicNumber),magicNumber)); addToBot(new ApplyPowerAction(p,p,new LoseStrengthPower(p,magicNumber),magicNumber)); addToBot(new DamageAction(m,new DamageInfo(p,damage,damageTypeForTurn),AttackEffect.FIRE)); }
    public void upgrade(){ if(!upgraded){ upgradeName(); upgradeDamage(1); upgradeMagicNumber(1); upgradeDescription(); } }
    public AbstractCard makeCopy(){ return new Card017(); }
}
