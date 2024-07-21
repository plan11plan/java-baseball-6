package baseball.presentation.controller;

import baseball.domain.model.BaseballNumbers;
import baseball.domain.model.game.Game;
import baseball.domain.model.game.response.GameResultResponse;
import baseball.domain.service.BaseballGameService;
import baseball.presentation.view.ConsoleView;
import java.util.List;

public class BaseballGameController {
    private final BaseballGameService gameService;
    private final ConsoleView view;

    public BaseballGameController(BaseballGameService gameService, ConsoleView view) {
        this.gameService = gameService;
        this.view = view;
    }


    public void playGame() {
        view.displayWelcomeMessage();
        Game game = gameService.startNewGame();

        while (!game.isFinished()) {
            List<Integer> guessNumbers = view.getPlayerGuess();
            GameResultResponse result = gameService.makeGuess(game, BaseballNumbers.of(guessNumbers));
            game = result.getGame();
            view.displayResult(result.getGameResult());
        }

        view.displayGameOverMessage();
        if (view.askForRestart()) {
            playGame();
        }
    }
}