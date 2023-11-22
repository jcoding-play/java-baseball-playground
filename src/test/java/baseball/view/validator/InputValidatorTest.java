package baseball.view.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력이 null 이거나 공백이면 예외가 발생한다.")
    void validateInput(String input) {
        assertThatThrownBy(() -> inputValidator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 공백일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "!", "12A"})
    @DisplayName("공의 숫자에 대한 입력이 숫자가 아니면 예외가 발생한다.")
    void validateBallNumbers(String input) {
        assertThatThrownBy(() -> inputValidator.validateBallNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공의 숫자에 대한 입력은 숫자만 가능합니다.");
    }
}