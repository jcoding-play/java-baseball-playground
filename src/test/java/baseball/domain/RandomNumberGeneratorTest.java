package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("1에서 9까지 서로 다른 임의의 수 3개를 선택한다.")
    void createRandomNumbers() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<Integer> randomNumbers = randomNumberGenerator.createRandomNumbers();

        for (Integer randomNumber : randomNumbers) {
            assertThat(randomNumber).isBetween(1, 9);
        }
        assertThat(randomNumbers.size()).isEqualTo(new HashSet<>(randomNumbers).size());
        assertThat(randomNumbers.size()).isEqualTo(3);
    }
}