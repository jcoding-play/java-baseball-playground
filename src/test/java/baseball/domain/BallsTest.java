package baseball.domain;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class BallsTest {

    @Test
    @DisplayName("공들에 대한 정보를 가진다.")
    void createBalls() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

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
}