package com.mycompany.cardgameapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.cardgameapi.model.Deck;

public interface DeckRepository extends JpaRepository<Deck, String> {
}