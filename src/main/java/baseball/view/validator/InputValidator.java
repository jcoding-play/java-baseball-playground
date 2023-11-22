package baseball.view.validator;

import java.util.regex.Pattern;

public class InputValidator {
    private final Pattern ONLY_DIGIT = Pattern.compile("-?[0-9]+");
    private final Pattern VALID_GAME_COMMAND = Pattern.compile("[1|2]");

    protected void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력은 공백일 수 없습니다.");
        }
    }

    public void validateBallNumbers(String input) {
        validateInput(input);

        if (isNotDigit(input)) {
            throw new IllegalArgumentException("공의 숫자에 대한 입력은 숫자만 가능합니다.");
        }
    }

    private boolean isNotDigit(String input) {
        return !ONLY_DIGIT.matcher(input)
                .matches();
    }

    public void validateGameCommand(String input) {
        validateInput(input);

        if (isInvalidInput(input)) {
            throw new IllegalArgumentException("게임 재시작 여부에 대한 입력은 1 또는 2로만 가능합니다. 현재 입력 값=" + input);
        }
    }

    private boolean isInvalidInput(String input) {
        return !VALID_GAME_COMMAND.matcher(input)
                .matches();
    }
}
