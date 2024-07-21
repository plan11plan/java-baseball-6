package baseball.domain.model.gameResult;

import java.util.Arrays;
import java.util.List;

public class GameResults {
    private static final List<GameResult> ALL_RESULTS = Arrays.asList(
            new GameResult(GameResultMessage.NOTHING, 0, 0),
            new GameResult(GameResultMessage.ONE_BALL, 1, 0),
            new GameResult(GameResultMessage.TWO_BALLS, 2, 0),
            new GameResult(GameResultMessage.THREE_BALLS, 3, 0),
            new GameResult(GameResultMessage.ONE_STRIKE, 0, 1),
            new GameResult(GameResultMessage.TWO_STRIKES, 0, 2),
            new GameResult(GameResultMessage.THREE_STRIKES, 0, 3),
            new GameResult(GameResultMessage.ONE_BALL_ONE_STRIKE, 1, 1),
            new GameResult(GameResultMessage.ONE_BALL_TWO_STRIKES, 1, 2),
            new GameResult(GameResultMessage.TWO_BALLS_ONE_STRIKE, 2, 1)
    );

    public static GameResult from(int balls, int strikes) {
        return ALL_RESULTS.stream()
                .filter(result -> result.getBalls() == balls && result.getStrikes() == strikes)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid game result"));
    }
}