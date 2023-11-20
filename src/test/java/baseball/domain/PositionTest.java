package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    @DisplayName("공의 위치 정보를 알 수 있다.")
    void createPosition(int pos) {
        Position position = new Position(pos);
        assertThat(position).isEqualTo(new Position(pos));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 4})
    @DisplayName("공의 위치가 1에서 3사이의 값이 아니라면 예외가 발생한다.")
    void invalidPosition(int pos) {
        assertThatThrownBy(() -> new Position(pos))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공의 위치는 1에서 3사이어야 합니다.");
    }
}