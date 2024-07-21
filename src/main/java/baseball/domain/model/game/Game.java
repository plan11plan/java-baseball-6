package baseball.domain.model.game;

import baseball.domain.model.BaseballNumbers;
import baseball.domain.model.game.response.GameResultResponse;
import baseball.domain.model.gameResult.GameResult;

public final class Game {
    private final BaseballNumbers targetNumbers;
    private final GameStatus status;
    private final GameRounds rounds;
    private final ResultCalculator resultCalculator;

    private Game(BaseballNumbers targetNumbers, GameStatus status, GameRounds rounds, ResultCalculator resultCalculator) {
        this.targetNumbers = targetNumbers;
        this.status = status;
        this.rounds = rounds;
        this.resultCalculator = resultCalculator;
    }

    public static Game start(BaseballNumbers targetNumbers, ResultCalculator resultCalculator) {
        return new Game(targetNumbers, GameStatus.IN_PROGRESS, GameRounds.empty(), resultCalculator);
    }
    public GameResultResponse guess(BaseballNumbers guessNumbers) {
        GameResult result = resultCalculator.calculateResult(targetNumbers, guessNumbers);
        GameRounds newRounds = rounds.addRound(new GameRound(guessNumbers, result));
        GameStatus newStatus = status.nextStatus(result);
        Game newGame = new Game(this.targetNumbers, newStatus, newRounds, this.resultCalculator);

        return new GameResultResponse(newGame, result, newStatus.isFinished(), newRounds.size());
    }

    public boolean isFinished() {
        return status.isFinished();
    }

    public GameRounds getRounds() {
        return rounds;
    }
}
