package tarnished.cards;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;
import tarnished.actions.RewindToTurnStartAction;

public class Card067 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card067");

    public Card067() {
        super(ID, 1, CardType.SKILL, CardRarity.SPECIAL, CardTarget.SELF);
        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        // TODO: 完整回溯需要保存手牌、抽弃牌堆、怪物、Power、遗物等快照；当前回溯 HP/格挡/能量。
        addToBot(new RewindToTurnStartAction());
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeBaseCost(0);
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card067();
    }
}
