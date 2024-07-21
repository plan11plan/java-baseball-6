package baseball.domain.model.gameResult;

import baseball.domain.model.GameConstants;

public class GameResult {
    private final String message;
    private final int balls;
    private final int strikes;

    GameResult(String message, int balls, int strikes) {
        this.message = message;
        this.balls = balls;
        this.strikes = strikes;
    }

    public String getMessage() {
        return message;
    }

    public int getBalls() {
        return balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public boolean isGameOver() {
        return strikes == GameConstants.THREE;
    }

    @Override
    public String toString() {
        return message;
    }
}

