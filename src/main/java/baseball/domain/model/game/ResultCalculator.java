package baseball.domain.model.game;

import baseball.domain.model.BaseballNumbers;
import baseball.domain.model.gameResult.GameResult;

public interface ResultCalculator {
    GameResult calculateResult(BaseballNumbers targetNumbers, BaseballNumbers guessNumbers);
}