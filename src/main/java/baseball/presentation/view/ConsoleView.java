package baseball.presentation.view;

import baseball.domain.model.gameResult.GameResult;
import baseball.infrastructure.input.ConsoleInputReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleView {
    private final ConsoleInputReader inputReader;

    public ConsoleView(ConsoleInputReader inputReader) {
        this.inputReader = inputReader;
    }

    public void displayWelcomeMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public List<Integer> getPlayerGuess() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = inputReader.readLine();
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void displayResult(GameResult result) {
        System.out.println(result.toString());
    }

    public void displayGameOverMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean askForRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String readLine = inputReader.readLine();
        return readLine.equals("1");
    }
}