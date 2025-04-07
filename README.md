# Card Game API

Card Game API is a RESTful service designed to manage and simulate card games. It provides endpoints for creating decks, shuffling cards, drawing cards, and more. This API is built using Java and follows best practices for clean and maintainable code.

## Features
- Create a new deck of cards.
- Create a new game.
- Add decks to a game.
- Add players to a game.
- Deal cards to players.
- Shuffle the deck.
- Draw cards from the deck.
- Support for multiple decks and players.
- Secure API endpoints with Basic Authentication.

## Prerequisites
- Java 17 or higher
- Maven
- Postman (optional, for testing)

## Installation
1. Clone the repository:
    
2. Build the project:
    ```bash
    mvn clean install
    ```
3. Run the application:
    ```bash
    mvnw spring-boot:run
    ```

## Running Tests
Run the following command to execute unit tests:
```bash
mvn test
```

## Postman Collection
A Postman collection is available in the repository as `Card Game API.postman_collection.json`. Import it into Postman to test the API endpoints.
