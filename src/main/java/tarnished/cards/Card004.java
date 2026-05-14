package tarnished.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.rooms.MonsterRoomBoss;
import com.megacrit.cardcrawl.vfx.combat.SmokeBombEffect;
import tarnished.TarnishedMod;

public class Card004 extends AbstractTarnishedCard {
    public static final String ID = TarnishedMod.makeID("Card004");

    public Card004() {
        super(ID, 0, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF);
        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        addToBot(new AbstractGameAction() {
            @Override
            public void update() {
                AbstractRoom room = AbstractDungeon.getCurrRoom();
                // TODO(待确认问题): 按烟雾弹流程实现逃离。当前限定非 Boss 战。
                if (room != null && room.phase == AbstractRoom.RoomPhase.COMBAT && !(room instanceof MonsterRoomBoss)) {
                    room.smoked = true;
                    addToTop(new VFXAction(new SmokeBombEffect(player.hb.cX, player.hb.cY)));
                    player.hideHealthBar();
                    player.isEscaping = true;
                    player.flipHorizontal = !player.flipHorizontal;
                    AbstractDungeon.overlayMenu.endTurnButton.disable();
                    player.escapeTimer = 2.5f;
                }
                isDone = true;
            }
        });
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Card004();
    }
}
