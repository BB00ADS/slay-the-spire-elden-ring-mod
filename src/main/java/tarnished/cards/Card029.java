package tarnished.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;

public class Card029 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card029");
    public Card029(){ super(ID,2,CardType.ATTACK,CardRarity.UNCOMMON,CardTarget.ENEMY); baseDamage=16; cardsToPreview=new Card041(); }
    public void use(AbstractPlayer p, AbstractMonster m){ addToBot(new DamageAction(m,new DamageInfo(p,damage,damageTypeForTurn),AttackEffect.FIRE)); addToBot(new MakeTempCardInDrawPileAction(new Card041(),1,true,true)); addToBot(new MakeTempCardInHandAction(new Card041(),1)); addToBot(new MakeTempCardInDiscardAction(new Card041(),1)); }
    public void upgrade(){ if(!upgraded){ upgradeName(); upgradeDamage(5); upgradeDescription(); } }
    public AbstractCard makeCopy(){ return new Card029(); }
}
