package tarnished.cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import tarnished.TarnishedMod;

public class Card002 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card002");

    public Card002() {
        super(ID, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF);
        this.baseBlock = 5;
        this.tags.add(CardTags.STARTER_DEFEND);
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new GainBlockAction(player, player, block));
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeBlock(3);
            upgradeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card002();
    }
}
