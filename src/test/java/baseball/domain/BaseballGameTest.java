package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class BaseballGameTest {

    @ParameterizedTest
    @MethodSource("ballsAndPlayResult")
    @DisplayName("컴퓨터의 숫자와 게임 플레이어의 숫자를 비교하여 결과를 알 수 있다.")
    void play(Balls balls, PlayResult expected) {
        BaseballGame baseballGame = new BaseballGame(Arrays.asList(1, 2, 3));

        PlayResult actual = baseballGame.play(balls);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> ballsAndPlayResult() {
        return Stream.of(
                arguments(new Balls(Arrays.asList(1, 2, 3)), new PlayResult(3, 0)),
                arguments(new Balls(Arrays.asList(1, 4, 3)), new PlayResult(2, 0)),
                arguments(new Balls(Arrays.asList(1, 3, 2)), new PlayResult(1, 2)),
                arguments(new Balls(Arrays.asList(1, 3, 4)), new PlayResult(1, 1)),
                arguments(new Balls(Arrays.asList(4, 5, 6)), new PlayResult(0, 0))
        );
    }
}