package com.mycompany.cardgameapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.cardgameapi.model.Game;

public interface GameRepository extends JpaRepository<Game, String> {
}