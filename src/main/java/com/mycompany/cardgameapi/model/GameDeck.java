package com.mycompany.cardgameapi.model;
import java.util.*;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class GameDeck {
    @Id
    private String id;

    @ElementCollection
    private final List<Card> cards = new ArrayList<>();
    private final Random random = new Random();

    public GameDeck() {
        this.id = UUID.randomUUID().toString();
    }

    public void addDeck(Deck deck) {
        cards.addAll(deck.getCards());
    }

    public void shuffle() {
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Collections.swap(cards, i, j);
        }
    }

    public List<Card> deal(int count) {
        List<Card> dealt = new ArrayList<>();
        while (count-- > 0 && !cards.isEmpty()) {
            dealt.add(cards.remove(0));
        }
        return dealt;
    }

    public List<Card> getRemainingCards() {
        return new ArrayList<>(cards);
    }
}