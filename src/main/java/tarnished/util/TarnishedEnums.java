package tarnished.util;

import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.helpers.CardLibrary;

public class TarnishedEnums {
    @SpireEnum
    public static AbstractPlayer.PlayerClass THE_TARNISHED;

    @SpireEnum(name = "TARNISHED_BROWN")
    public static AbstractCard.CardColor TARNISHED_CARD_COLOR;

    @SpireEnum(name = "TARNISHED_BROWN")
    public static CardLibrary.LibraryType TARNISHED_LIBRARY;

    @SpireEnum(name = "TARNISHED_BROWN")
    public static AbstractCard.CardTags TARNISHED_CARD;

    @SpireEnum
    public static AbstractCard.CardTags TARNISHED_SWORD_ATTACK;
}
