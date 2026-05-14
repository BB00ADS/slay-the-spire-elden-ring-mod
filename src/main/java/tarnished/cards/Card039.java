package tarnished.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;

public class Card039 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card039");
    public Card039(){ super(ID,3,CardType.ATTACK,CardRarity.RARE,CardTarget.ENEMY); baseDamage=0; exhaust=true; }
    public void applyPowers(){ int old=baseDamage; baseDamage=AbstractDungeon.player.exhaustPile.size(); super.applyPowers(); baseDamage=old; isDamageModified=true; }
    public void use(AbstractPlayer p, AbstractMonster m){ for(int i=0;i<3;i++) addToBot(new DamageAction(m,new DamageInfo(p,damage,damageTypeForTurn),AttackEffect.SLASH_HEAVY)); }
    public void upgrade(){ if(!upgraded){ upgradeName(); upgradeBaseCost(2); upgradeDescription(); } }
    public AbstractCard makeCopy(){ return new Card039(); }
}
