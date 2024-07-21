package baseball;

import baseball.domain.model.game.DefaultResultCalculator;
import baseball.domain.model.game.ResultCalculator;
import baseball.domain.service.BaseballGameService;
import baseball.infrastructure.input.ConsoleInputReader;
import baseball.infrastructure.numberGenerator.NumberGenerator;
import baseball.infrastructure.numberGenerator.RandomNumberGenerator;
import baseball.presentation.controller.BaseballGameController;
import baseball.presentation.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int count = 3;
        int startInclusive = 1;
        int endInclusive = 9;
        ConsoleInputReader inputReader = new ConsoleInputReader();
        NumberGenerator numberGenerator = new RandomNumberGenerator(3, 1, 9);
        ResultCalculator resultCalculator = new DefaultResultCalculator();
        BaseballGameService gameService = new BaseballGameService(numberGenerator,resultCalculator);
        ConsoleView view = new ConsoleView(inputReader);
        BaseballGameController controller = new BaseballGameController(gameService, view);

        controller.playGame();

    }
}
