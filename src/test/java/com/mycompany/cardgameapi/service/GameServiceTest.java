package com.mycompany.cardgameapi.service;

import com.mycompany.cardgameapi.model.Game;
import com.mycompany.cardgameapi.repository.DeckRepository;
import com.mycompany.cardgameapi.repository.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameServiceTest {

    private GameRepository gameRepository;
    private DeckRepository deckRepository;
    private GameService gameService;

    @BeforeEach
    void setUp() {
        gameRepository = mock(GameRepository.class);
        deckRepository = mock(DeckRepository.class);
        gameService = new GameService(gameRepository, deckRepository);
    }

    @Test
    void testCreateGame() {
        // Arrange
        Game game = new Game();
        when(gameRepository.save(any(Game.class))).thenReturn(game);

        // Act
        Game createdGame = gameService.createGame();

        // Assert
        assertNotNull(createdGame, "Created game should not be null");
        verify(gameRepository, times(1)).save(any(Game.class));
    }

    @Test
    void testDeleteGame() {
        // Arrange
        String gameId = "123";

        // Act
        gameService.deleteGame(gameId);

        // Assert
        verify(gameRepository, times(1)).deleteById(gameId);
    }
}