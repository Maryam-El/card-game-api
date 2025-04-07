package com.mycompany.cardgameapi.service;

import org.springframework.stereotype.Service;

import com.mycompany.cardgameapi.model.*;
import com.mycompany.cardgameapi.repository.DeckRepository;
import com.mycompany.cardgameapi.repository.GameRepository;

import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final DeckRepository deckRepository;

    public GameService(GameRepository gameRepository, DeckRepository deckRepository) {
        this.gameRepository = gameRepository;
        this.deckRepository = deckRepository;
    }

    public Game createGame() {
        Game game = new Game();
        return gameRepository.save(game);
    }

    public void deleteGame(String id) {
        gameRepository.deleteById(id);
    }

    public Game getGame(String id) {
        return gameRepository.findById(id).orElse(null);
    }

    public Deck createDeck() {
        Deck deck = new Deck();
        return deckRepository.save(deck);
    }

    public String addDeckToGame(String gameId, String deckId) {
        Game game = gameRepository.findById(gameId).orElse(null);
        Deck deck = deckRepository.findById(deckId).orElse(null);
    
        if (game != null && deck != null) {
            game.getGameDeck().addDeck(deck); 
            gameRepository.save(game); 
            return "Deck added to game.";
        }
        return "Game or deck not found.";
    }

    public Deck getDeck(String deckId) {
        return deckRepository.findById(deckId)
                .orElseThrow(() -> new NoSuchElementException("Deck with ID " + deckId + " not found"));
    }

    public Player addPlayerToGame(String gameId, String name) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new NoSuchElementException("Game not found"));
        Player player = new Player(UUID.randomUUID().toString(), name);
        game.addPlayer(player);
        gameRepository.save(game); 
        return player;
    }

    public void removePlayerFromGame(String gameId, String playerId) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new NoSuchElementException("Game not found"));
        game.removePlayer(playerId);
        gameRepository.save(game); 
    }

    public List<Card> dealCardsToPlayer(String gameId, String playerId, int count) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new NoSuchElementException("Game not found"));
        List<Card> dealt = game.getGameDeck().deal(count);
        Player player = game.getPlayer(playerId);
        player.addCards(dealt);
        gameRepository.save(game); 
        return dealt;
    }

    public List<Card> getPlayerCards(String gameId, String playerId) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new NoSuchElementException("Game not found"));
        Player player = game.getPlayer(playerId);
        return player.getHand();
    }

    public List<Map<String, Object>> getScoreboard(String gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new NoSuchElementException("Game not found"));
        return game.getPlayers().stream()
            .sorted((a, b) -> Integer.compare(b.getTotalValue(), a.getTotalValue()))
            .map(player -> {
                Map<String, Object> playerData = new HashMap<>();
                playerData.put("id", player.getId());
                playerData.put("name", player.getName());
                playerData.put("totalValue", player.getTotalValue());
                return playerData;
            })
            .collect(Collectors.toList());
    }

    public Map<Card.Suit, Long> getSuitCount(String gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new NoSuchElementException("Game not found"));
        return game.getGameDeck().getRemainingCards().stream()
            .collect(Collectors.groupingBy(Card::getSuit, Collectors.counting()));
    }

    public List<String> getCardCount(String gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new NoSuchElementException("Game not found"));
        return game.getGameDeck().getRemainingCards().stream()
            .sorted(Comparator.comparing(Card::getSuit).thenComparing((Card c) -> -c.getValue().score))
            .map(Card::toString)
            .collect(Collectors.toList());
    }
    
    public void shuffleDeck(String gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new NoSuchElementException("Game not found"));
        game.getGameDeck().shuffle();
        gameRepository.save(game); 
    }
}