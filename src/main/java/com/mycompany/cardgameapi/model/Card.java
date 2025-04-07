package com.mycompany.cardgameapi.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Card {
    public enum Suit {HEARTS, SPADES, CLUBS, DIAMONDS}
    public enum Value {
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(11), QUEEN(12), KING(13);

        public final int score;
        Value(int score) { this.score = score; }
    }

    private final Suit suit;

    @Column(name = "card_value")
    private final Value value;

    public Card() {
        this.suit = null;
        this.value = null;
    }

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() { return suit; }
    public Value getValue() { return value; }

    @Override
    public String toString() {
        return value + " of " + suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit && value == card.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, value);
    }
}