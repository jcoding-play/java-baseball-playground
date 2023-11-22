package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BallMapperTest {

    @Test
    @DisplayName("숫자 리스트를 통해 List<Ball>을 생성할 수 있다.")
    void mapFrom() {
        List<Ball> balls = BallMapper.mapFrom(Arrays.asList(1, 2, 3));

        assertThat(balls).containsExactly(
                new Ball(1, 1),
                new Ball(2, 2),
                new Ball(3, 3)
        );
    }
}