package baseball.domain.model.game;

import baseball.domain.model.BaseballNumbers;
import baseball.domain.model.gameResult.GameResult;

public record GameRound(BaseballNumbers guess, GameResult result) {
}
