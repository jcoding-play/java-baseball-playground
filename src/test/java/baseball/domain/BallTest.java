package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class BallTest {

    @ParameterizedTest
    @MethodSource("ballAndBallStatus")
    @DisplayName("공의 숫자와 위치 정보를 통해 다른 공과 비교할 수 있다.")
    void compare(Ball other, BallStatus expected) {
        Ball ball = new Ball(1, 1);

        BallStatus actual = ball.compare(other);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> ballAndBallStatus() {
        return Stream.of(
                arguments(new Ball(1, 1), BallStatus.STRIKE),
                arguments(new Ball(1, 3), BallStatus.BALL),
                arguments(new Ball(2, 1), BallStatus.NOTHING)
        );
    }
}