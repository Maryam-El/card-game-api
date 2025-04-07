package com.mycompany.cardgameapi.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testConstructorAndGetters() {
        // Arrange
        String id = "1";
        String name = "Alice";

        // Act
        Player player = new Player(id, name);

        // Assert
        assertEquals(id, player.getId(), "Player ID should match the provided value");
        assertEquals(name, player.getName(), "Player name should match the provided value");
        assertNotNull(player.getHand(), "Player hand should not be null");
        assertTrue(player.getHand().isEmpty(), "Player hand should be empty initially");
    }

    @Test
    void testAddCards() {
        // Arrange
        Player player = new Player("1", "Alice");
        List<Card> cardsToAdd = new ArrayList<>();
        cardsToAdd.add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
        cardsToAdd.add(new Card(Card.Suit.SPADES, Card.Value.KING));

        // Act
        player.addCards(cardsToAdd);

        // Assert
        assertEquals(2, player.getHand().size(), "Player hand should contain 2 cards after adding");
        assertTrue(player.getHand().containsAll(cardsToAdd), "Player hand should contain the added cards");
    }

    @Test
    void testGetTotalValue() {
        // Arrange
        Player player = new Player("1", "Alice");
        List<Card> cardsToAdd = new ArrayList<>();
        cardsToAdd.add(new Card(Card.Suit.HEARTS, Card.Value.ACE)); // Value = 1
        cardsToAdd.add(new Card(Card.Suit.SPADES, Card.Value.KING)); // Value = 13
        player.addCards(cardsToAdd);

        // Act
        int totalValue = player.getTotalValue();

        // Assert
        assertEquals(14, totalValue, "Total value of the player's hand should be 14");
    }

    @Test
    void testEmptyHandTotalValue() {
        // Arrange
        Player player = new Player("1", "Alice");

        // Act
        int totalValue = player.getTotalValue();

        // Assert
        assertEquals(0, totalValue, "Total value of an empty hand should be 0");
    }
}