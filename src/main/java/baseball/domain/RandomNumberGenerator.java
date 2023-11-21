package baseball.domain;

import baseball.utils.Constants;

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
                .limit(Constants.VALID_BALLS_SIZE)
                .collect(Collectors.toList());
    }

    private int createRandomNumber() {
        return random.nextInt(Constants.MAXIMUM_BALL_NUMBER) + Constants.MINIMUM_BALL_NUMBER;
    }
}
