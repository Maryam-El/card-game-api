package com.mycompany.cardgameapi.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;

@Entity
public class Player {
    @Id
    private final String id;
    private final String name;

    @ElementCollection
    private final List<Card> hand = new ArrayList<>();

    public Player() {
        this.id = null;
        this.name = null;
    }

    public Player(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<Card> getHand() { return hand; }

    public void addCards(List<Card> cards) {
        hand.addAll(cards);
    }

    public int getTotalValue() {
        return hand.stream().mapToInt(card -> card.getValue().score).sum();
    }
}