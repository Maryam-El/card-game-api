package com.mycompany.cardgameapi.model;
import java.util.*;

import jakarta.persistence.*;

@Entity
public class Game {
    @Id
    private final String id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private final Map<String, Player> players = new HashMap<>();

    @OneToOne(cascade = CascadeType.ALL)
    private GameDeck gameDeck = new GameDeck();

    public Game() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() { return id; }

    public void addPlayer(Player player) {
        players.put(player.getId(), player);
    }

    public void removePlayer(String playerId) {
        players.remove(playerId);
    }

    public Collection<Player> getPlayers() {
        return players.values();
    }

    public Player getPlayer(String playerId) {
        return players.get(playerId);
    }

    public void setPlayers(Map<String, Player> players) {
        this.players.clear();
        this.players.putAll(players);
    }

    public GameDeck getGameDeck() {
        return gameDeck;
    }

    public void setGameDeck(GameDeck gameDeck) {
        this.gameDeck = gameDeck;
    }
}
