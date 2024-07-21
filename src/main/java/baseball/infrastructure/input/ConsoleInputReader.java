package baseball.infrastructure.input;

import java.util.Scanner;

public class ConsoleInputReader {
    private final Scanner scanner = new Scanner(System.in);

    public String readLine() {
        return scanner.nextLine();
    }

}
