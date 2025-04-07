package com.mycompany.cardgameapi.model;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testAddPlayer() {
        // Arrange
        Game game = new Game();
        Player player = new Player("1", "Alice");

        // Act
        game.addPlayer(player);

        // Assert
        assertEquals(1, game.getPlayers().size(), "Game should have 1 player");
        assertTrue(game.getPlayers().contains(player), "Game should contain the added player");
    }

    @Test
    void testRemovePlayer() {
        // Arrange
        Game game = new Game();
        Player player = new Player("1", "Alice");
        game.addPlayer(player);

        // Act
        game.removePlayer(player.getId());

        // Assert
        assertEquals(0, game.getPlayers().size(), "Game should have no players after removal");
    }

    @Test
    void testGetPlayers() {
        // Arrange
        Game game = new Game();
        Player player1 = new Player("1", "Alice");
        Player player2 = new Player("2", "Bob");
        game.addPlayer(player1);
        game.addPlayer(player2);

        // Act
        Collection<Player> players = game.getPlayers();

        // Assert
        assertEquals(2, players.size(), "Game should have 2 players");
        assertTrue(players.contains(player1), "Game should contain player1");
        assertTrue(players.contains(player2), "Game should contain player2");
    }

    @Test
    void testGetPlayer() {
        // Arrange
        Game game = new Game();
        Player player = new Player("1", "Alice");
        game.addPlayer(player);

        // Act
        Player retrievedPlayer = game.getPlayer(player.getId());

        // Assert
        assertNotNull(retrievedPlayer, "Retrieved player should not be null");
        assertEquals(player, retrievedPlayer, "Retrieved player should match the added player");
    }

    @Test
    void testSetPlayers() {
        // Arrange
        Game game = new Game();
        Map<String, Player> newPlayers = new HashMap<>();
        Player player1 = new Player("1", "Alice");
        Player player2 = new Player("2", "Bob");
        newPlayers.put(player1.getId(), player1);
        newPlayers.put(player2.getId(), player2);

        // Act
        game.setPlayers(newPlayers);

        // Assert
        assertEquals(2, game.getPlayers().size(), "Game should have 2 players after setting players");
        assertTrue(game.getPlayers().contains(player1), "Game should contain player1");
        assertTrue(game.getPlayers().contains(player2), "Game should contain player2");
    }

    @Test
    void testSetAndGetGameDeck() {
        // Arrange
        Game game = new Game();
        GameDeck gameDeck = new GameDeck();

        // Act
        game.setGameDeck(gameDeck);

        // Assert
        assertEquals(gameDeck, game.getGameDeck(), "GameDeck should match the set value");
    }
}