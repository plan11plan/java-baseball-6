package baseball.domain.model.game;

import baseball.domain.model.BaseballNumbers;
import baseball.domain.model.gameResult.GameResult;
import baseball.domain.model.gameResult.GameResults;

public class DefaultResultCalculator implements ResultCalculator {
    @Override
    public GameResult calculateResult(BaseballNumbers targetNumbers, BaseballNumbers guessNumbers) {
        int strikes = targetNumbers.countMatchingPositions(guessNumbers);
        int balls = targetNumbers.countMatchingNumbers(guessNumbers) - strikes;
        return GameResults.from(balls, strikes);
    }
}