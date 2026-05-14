package tarnished.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;

public class Card018 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card018");
    public Card018(){ super(ID,1,CardType.ATTACK,CardRarity.COMMON,CardTarget.ENEMY); baseDamage=6; magicNumber=baseMagicNumber=1; }
    public void applyPowers(){ int old=baseDamage; baseDamage = 6 + AbstractDungeon.player.exhaustPile.size() * magicNumber; super.applyPowers(); baseDamage=old; isDamageModified = damage != baseDamage; }
    public void use(AbstractPlayer p, AbstractMonster m){ addToBot(new DamageAction(m,new DamageInfo(p,damage,damageTypeForTurn),AttackEffect.FIRE)); }
    public void upgrade(){ if(!upgraded){ upgradeName(); upgradeMagicNumber(1); upgradeDescription(); } }
    public AbstractCard makeCopy(){ return new Card018(); }
}
