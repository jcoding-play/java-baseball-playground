package baseball.view;

import baseball.view.validator.InputValidator;

import java.util.Scanner;

public class InputView {
    private static final String READ_BALL_NUMBERS_MESSAGE = "숫자를 입력해 주세요 : ";

    private static Scanner scanner = new Scanner(System.in);
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String readBallNumbers() {
        System.out.println(READ_BALL_NUMBERS_MESSAGE);
        String input = scanner.nextLine();

        inputValidator.validateBallNumbers(input);
        return input;
    }
}
