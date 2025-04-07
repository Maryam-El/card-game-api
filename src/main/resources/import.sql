CREATE TABLE game (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    game_deck_id BIGINT
);

CREATE TABLE game_deck (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    random VARCHAR(255)
);

CREATE TABLE player (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE game_players (
    game_id BIGINT,
    players_id BIGINT,
    PRIMARY KEY (game_id, players_id),
    FOREIGN KEY (game_id) REFERENCES game(id),
    FOREIGN KEY (players_id) REFERENCES player(id)
);