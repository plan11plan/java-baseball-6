package baseball.infrastructure.persistence;

import baseball.domain.model.game.Game;

public interface BaseballGameRepository {
    void save(Game game);
    Game getGame();
}