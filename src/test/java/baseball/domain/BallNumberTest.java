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
}