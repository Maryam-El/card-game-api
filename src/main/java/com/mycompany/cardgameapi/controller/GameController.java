package com.mycompany.cardgameapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mycompany.cardgameapi.model.*;
import com.mycompany.cardgameapi.service.GameService;

import java.util.*;

@RestController
@RequestMapping("/api/games")
public class GameController {


    @Autowired
    private GameService gameService;

    @PostMapping
    public Game createGame() {
        return gameService.createGame();
    }

    @DeleteMapping("/{gameId}")
    public void deleteGame(@PathVariable String gameId) {
        gameService.deleteGame(gameId);
    }

    @PostMapping("/decks")
    public Deck createDeck() {
        return gameService.createDeck();
    }

    @PostMapping("/{gameId}/decks/{deckId}")
    public String addDeckToGame(@PathVariable String gameId, @PathVariable String deckId) {
        gameService.addDeckToGame(gameId, deckId);
        return "Deck added to game.";
    }

    @PostMapping("/{gameId}/players")
    public Player addPlayer(@PathVariable String gameId, @RequestParam String name) {
        return gameService.addPlayerToGame(gameId, name);
    }

    @DeleteMapping("/{gameId}/players/{playerId}")
    public void removePlayer(@PathVariable String gameId, @PathVariable String playerId) {
        gameService.removePlayerFromGame(gameId, playerId);
    }

    @PostMapping("/{gameId}/players/{playerId}/deal")
    public List<Card> dealCards(@PathVariable String gameId, @PathVariable String playerId, @RequestParam int count) {
        return gameService.dealCardsToPlayer(gameId, playerId, count);
    }

    @GetMapping("/{gameId}/players/{playerId}/cards")
    public List<Card> getPlayerCards(@PathVariable String gameId, @PathVariable String playerId) {
        return gameService.getPlayerCards(gameId, playerId);
    }

    @GetMapping("/{gameId}/players/scoreboard")
    public List<Map<String, Object>> getScoreboard(@PathVariable String gameId) {
        return gameService.getScoreboard(gameId);
    }

    @GetMapping("/{gameId}/deck/count-by-suit")
    public Map<Card.Suit, Long> getSuitCount(@PathVariable String gameId) {
        return gameService.getSuitCount(gameId);
    }

    @GetMapping("/{gameId}/deck/count-by-card")
    public List<String> getCardCount(@PathVariable String gameId) {
        return gameService.getCardCount(gameId);
    }

    @PostMapping("/{gameId}/deck/shuffle")
    public void shuffleDeck(@PathVariable String gameId) {
        gameService.shuffleDeck(gameId);
    }
}
