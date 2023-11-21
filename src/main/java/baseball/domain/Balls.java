package baseball.domain;

import java.util.HashSet;
import java.util.List;

public class Balls {
    private static final int VALID_BALLS_SIZE = 3;

    private final List<Ball> balls;

    public Balls(List<Integer> ballNumbers) {
        validateBallNumbers(ballNumbers);
        this.balls = BallMapper.mapFrom(ballNumbers);
    }

    private void validateBallNumbers(List<Integer> ballNumbers) {
        if (isInvalidSize(ballNumbers)) {
            throw new IllegalArgumentException(
                    String.format("공들의 개수는 %d개여야 합니다.", VALID_BALLS_SIZE));
        }
        if (hasDuplicatedBallNumber(ballNumbers)) {
            throw new IllegalArgumentException("공들 중 중복되는 숫자가 존재합니다.");
        }
    }

    private boolean isInvalidSize(List<Integer> ballNumbers) {
        return ballNumbers.size() != VALID_BALLS_SIZE;
    }

    private boolean hasDuplicatedBallNumber(List<Integer> ballNumbers) {
        return ballNumbers.size() != new HashSet<>(ballNumbers).size();
    }

    public BallStatus compare(Ball ball) {
        return balls.stream()
                .map(ball::compare)
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
