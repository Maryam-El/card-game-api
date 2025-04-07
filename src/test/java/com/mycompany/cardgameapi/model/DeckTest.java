package com.mycompany.cardgameapi.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void testDefaultConstructor() {
        // Act
        Deck deck = new Deck();

        // Assert
        assertNotNull(deck.getId(), "Deck ID should not be null");
        assertEquals(52, deck.getCards().size(), "Deck should contain 52 cards");

        // Verify that all suits and values are present
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Value value : Card.Value.values()) {
                assertTrue(deck.getCards().contains(new Card(suit, value)),
                        "Deck should contain card: " + suit + " " + value);
            }
        }
    }

    @Test
    void testGetCardsReturnsCopy() {
        // Arrange
        Deck deck = new Deck();
        List<Card> originalCards = deck.getCards();

        // Act
        originalCards.clear(); // Attempt to modify the returned list

        // Assert
        assertEquals(52, deck.getCards().size(), "Original deck should remain unchanged");
    }

    @Test
    void testSetId() {
        // Arrange
        Deck deck = new Deck();
        String newId = UUID.randomUUID().toString();

        // Act
        deck.setId(newId);

        // Assert
        assertEquals(newId, deck.getId(), "Deck ID should be updated");
    }

    @Test
    void testSetCards() {
        // Arrange
        Deck deck = new Deck();
        List<Card> newCards = new ArrayList<>();
        newCards.add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
        newCards.add(new Card(Card.Suit.SPADES, Card.Value.KING));

        // Act
        deck.setCards(newCards);

        // Assert
        assertEquals(2, deck.getCards().size(), "Deck should contain the new cards");
        assertEquals(newCards, deck.getCards(), "Deck cards should match the new cards");
    }
}