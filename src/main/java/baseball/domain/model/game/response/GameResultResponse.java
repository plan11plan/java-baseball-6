package baseball.domain.model.game.response;

import baseball.domain.model.game.Game;
import baseball.domain.model.gameResult.GameResult;

public class GameResultResponse {
    private final Game game;
    private final GameResult gameResult;
    private final boolean isGameFinished;
    private final int roundNumber;

    public GameResultResponse(Game game, GameResult gameResult, boolean isGameFinished, int roundNumber) {
        this.game = game;
        this.gameResult = gameResult;
        this.isGameFinished = isGameFinished;
        this.roundNumber = roundNumber;
    }

    public Game getGame() {
        return game;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public boolean isGameFinished() {
        return isGameFinished;
    }

    public int getRoundNumber() {
        return roundNumber;
    }
}
