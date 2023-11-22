package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class BaseballGameTest {
    private BaseballGame baseballGame;

    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGame(() -> Arrays.asList(1, 2, 3));
    }

    @ParameterizedTest
    @MethodSource("ballsAndPlayResult")
    @DisplayName("컴퓨터의 숫자와 게임 플레이어의 숫자를 비교하여 결과를 알 수 있다.")
    void play(Balls balls, PlayResult expected) {
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

    @ParameterizedTest
    @MethodSource("ballsAndExpected")
    @DisplayName("컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.")
    void isPlayable(Balls balls, boolean expected) {
        baseballGame.play(balls);

        boolean actual = baseballGame.isPlayable();

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> ballsAndExpected() {
        return Stream.of(
                arguments(new Balls(Arrays.asList(1, 2, 3)), false),
                arguments(new Balls(Arrays.asList(1, 4, 3)), true),
                arguments(new Balls(Arrays.asList(1, 3, 2)), true),
                arguments(new Balls(Arrays.asList(1, 3, 4)), true),
                arguments(new Balls(Arrays.asList(4, 5, 6)), true)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"RESTART, true", "QUIT, false"})
    @DisplayName("게임이 종료한 후 다시 시작할 수 있는지 없는지를 알 수 있다.")
    void canRestart(GameCommand gameCommand, boolean expected) {
        boolean actual = baseballGame.canRestart(gameCommand);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("게임을 종료한 후 다시 시작할 수 있다.")
    void restart() {
        baseballGame.play(new Balls(Arrays.asList(1, 2, 3)));
        assertThat(baseballGame.isPlayable()).isFalse();

        baseballGame.restart(new RandomNumberGenerator());
        assertThat(baseballGame.isPlayable()).isTrue();
    }

    @Test
    @DisplayName("게임이 종료되지 않은 상태에서 게임을 재시작하려 하면 예외가 발생한다.")
    void invalidToRestart() {
        assertThatThrownBy(() -> baseballGame.restart(new RandomNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임이 종료되지 않은 상태에서 게임을 재시작할 수 없습니다.");
    }
}