package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BallNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    @DisplayName("공의 숫자 정보를 가진다.")
    void createBallNumber(int number) {
        BallNumber ballNumber = new BallNumber(number);
        assertThat(ballNumber).isEqualTo(new BallNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    @DisplayName("공의 숫자 범위가 1보다 작거나 9보다 크다면 예외가 발생한다.")
    void invalidBallNumber(int number) {
        assertThatThrownBy(() -> new BallNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공의 숫자 범위는 1에서 9사이의 값이어야 합니다.");
    }
}