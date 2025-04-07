package com.mycompany.cardgameapi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void testCardConstructorAndGetters() {
        Card.Suit suit = Card.Suit.HEARTS;
        Card.Value value = Card.Value.ACE;

        Card card = new Card(suit, value);

        assertEquals(suit, card.getSuit());
        assertEquals(value, card.getValue());
    }

    @Test
    void testDefaultConstructor() {
        Card card = new Card();

        assertNull(card.getSuit());
        assertNull(card.getValue());
    }

    @Test
    void testValueEnumScores() {
        assertEquals(1, Card.Value.ACE.score);
        assertEquals(2, Card.Value.TWO.score);
        assertEquals(11, Card.Value.JACK.score);
        assertEquals(13, Card.Value.KING.score);
    }

    @Test
    void testSuitEnumValues() {
        assertEquals(Card.Suit.HEARTS, Card.Suit.valueOf("HEARTS"));
        assertEquals(Card.Suit.SPADES, Card.Suit.valueOf("SPADES"));
        assertEquals(Card.Suit.CLUBS, Card.Suit.valueOf("CLUBS"));
        assertEquals(Card.Suit.DIAMONDS, Card.Suit.valueOf("DIAMONDS"));
    }
}