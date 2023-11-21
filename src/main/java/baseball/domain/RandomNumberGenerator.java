package baseball.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomNumberGenerator {
    private final Random random;

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    public List<Integer> createRandomNumbers() {
        return Stream.generate(this::createRandomNumber)
                .distinct()
                .limit(3)
                .collect(Collectors.toList());
    }

    private int createRandomNumber() {
        return random.nextInt(9) + 1;
    }
}
