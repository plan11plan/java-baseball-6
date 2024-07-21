package baseball.infrastructure.persistence;

import baseball.domain.model.game.Game;

public class InMemoryBaseballGameRepository implements BaseballGameRepository {
    private Game currentGame;

    @Override
    public void save(Game game) {
        this.currentGame = game;
    }

    @Override
    public Game getGame() {
        return currentGame;
    }
}