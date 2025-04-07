package com.mycompany.cardgameapi.model;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Deck {
    @Id
    private String id;

    @ElementCollection
    private List<Card> cards;

    public Deck() {
        this.id = UUID.randomUUID().toString();
        this.cards = new ArrayList<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Value value : Card.Value.values()) {
                cards.add(new Card(suit, value));
            }
        }
    }

    public String getId() { return id; }
    public List<Card> getCards() { return new ArrayList<>(cards); }

    public void setId(String id) {
        this.id = id;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}