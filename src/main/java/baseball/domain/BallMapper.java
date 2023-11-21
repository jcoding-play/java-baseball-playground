package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BallMapper {
    private static final int START_INDEX = 0;
    private static final int ADD_TO_OBTAIN_POSITION_VALUE = 1;

    private BallMapper() {
    }

    public static List<Ball> mapFrom(List<Integer> ballNumbers) {
        return IntStream.range(START_INDEX, ballNumbers.size())
                .mapToObj(index -> generateBall(ballNumbers, index))
                .collect(Collectors.toList());
    }

    private static Ball generateBall(List<Integer> ballNumbers, int index) {
        return new Ball(ballNumbers.get(index), index + ADD_TO_OBTAIN_POSITION_VALUE);
    }
}
