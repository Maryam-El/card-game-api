package com.mycompany.cardgameapi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameDeckTest {

    private GameDeck gameDeck;

    @BeforeEach
    void setUp() {
        gameDeck = new GameDeck();
        gameDeck.addDeck(new Deck());
    }

    @Test
    void testAddDeck() {
        // Assert
        assertEquals(52, gameDeck.getRemainingCards().size(), "GameDeck should initially contain 52 cards");
    }

    @Test
    void testShuffleDeck() {
        // Arrange
        List<Card> originalOrder = List.copyOf(gameDeck.getRemainingCards());

        // Act
        gameDeck.shuffle();

        // Assert
        assertNotEquals(originalOrder, gameDeck.getRemainingCards(), "Deck order should change after shuffling");
        assertEquals(52, gameDeck.getRemainingCards().size(), "Deck size should remain 52 after shuffling");
    }

    @Test
    void testDealCards() {
        // Act
        List<Card> dealtCards = gameDeck.deal(5);

        // Assert
        assertEquals(5, dealtCards.size(), "Should deal 5 cards");
        assertEquals(47, gameDeck.getRemainingCards().size(), "Remaining cards should be 47 after dealing 5 cards");
    }

    @Test
    void testDealMoreCardsThanAvailable() {
        // Act
        List<Card> dealtCards = gameDeck.deal(60);

        // Assert
        assertEquals(52, dealtCards.size(), "Should deal all available cards when requesting more than available");
        assertEquals(0, gameDeck.getRemainingCards().size(), "No cards should remain after dealing all cards");
    }
}