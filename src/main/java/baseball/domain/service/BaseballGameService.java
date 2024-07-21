package baseball.domain.service;


import baseball.domain.model.BaseballNumbers;
import baseball.domain.model.game.Game;
import baseball.domain.model.game.response.GameResultResponse;
import baseball.domain.model.game.ResultCalculator;
import baseball.infrastructure.numberGenerator.NumberGenerator;

public class BaseballGameService {
    private final NumberGenerator numberGenerator;
    private final ResultCalculator resultCalculator;

    public BaseballGameService(NumberGenerator numberGenerator, ResultCalculator resultCalculator) {
        this.numberGenerator = numberGenerator;
        this.resultCalculator = resultCalculator;
    }

    public Game startNewGame() {
        BaseballNumbers targetNumbers = numberGenerator.generateUniqueNumbers();
       targetNumbers.numbers().stream().forEach(i-> System.out.print(i+" "));
        return Game.start(targetNumbers, resultCalculator);
    }
    public GameResultResponse makeGuess(Game game, BaseballNumbers guessNumbers) {
        return game.guess(guessNumbers);
    }
}