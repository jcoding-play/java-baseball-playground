package baseball.domain;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BallsTest {
    private Balls balls;

    @BeforeEach
    void setUp() {
        balls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("공들에 대한 정보를 가진다.")
    void createBalls() {
        assertThat(balls).extracting("balls", InstanceOfAssertFactories.list(Ball.class))
                .containsExactly(new Ball(1, 1), new Ball(2, 2), new Ball(3, 3));
    }

    @ParameterizedTest
    @MethodSource("ballNumbers")
    @DisplayName("공들의 개수가 3개가 아니라면 예외가 발생한다.")
    void invalidBallsSize(List<Integer> ballNumbers) {
        assertThatThrownBy(() -> new Balls(ballNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공들의 개수는 3개여야 합니다.");
    }

    static Stream<List<Integer>> ballNumbers() {
        return Stream.of(
                Arrays.asList(1, 2),
                Arrays.asList(1, 2, 3, 4)
        );
    }

    @Test
    @DisplayName("공들 중 중복된 수가 있으면 예외가 발생한다.")
    void hasDuplicatedBallNumber() {
        assertThatThrownBy(() -> new Balls(Arrays.asList(1, 2, 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공들 중 중복되는 숫자가 존재합니다.");
    }

    @ParameterizedTest
    @MethodSource("ballAndBallStatus")
    @DisplayName("공 하나와 비교하여 결과를 알 수 있다.")
    void judgeBallStatusOf(Ball ball, BallStatus expected) {
        BallStatus actual = balls.judgeBallStatusOf(ball);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> ballAndBallStatus() {
        return Stream.of(
                arguments(new Ball(1, 1), BallStatus.STRIKE),
                arguments(new Ball(1, 3), BallStatus.BALL),
                arguments(new Ball(4, 1), BallStatus.NOTHING)
        );
    }

    @Test
    @DisplayName("사용자와 컴퓨터의 공을 비교하여 결과를 알 수 있다.")
    void compare() {
        Balls userBalls = new Balls(Arrays.asList(1, 4, 2));
        Map<BallStatus, Integer> result = balls.compare(userBalls);

        assertThat(result).contains(
                entry(BallStatus.STRIKE, 1), entry(BallStatus.BALL, 1), entry(BallStatus.NOTHING, 1)
        );
    }
}