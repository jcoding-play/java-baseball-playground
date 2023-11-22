package baseball.view.validator;

import java.util.regex.Pattern;

public class InputValidator {
    private final Pattern ONLY_DIGIT = Pattern.compile("-?[0-9]+");

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
}
