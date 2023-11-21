package baseball.domain;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Balls {
    public static final int VALID_BALLS_SIZE = 3;

    private final List<Ball> balls;

    public Balls(List<Integer> ballNumbers) {
        validateBallNumbers(ballNumbers);
        this.balls = mapBall(ballNumbers);
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

    private List<Ball> mapBall(List<Integer> ballNumbers) {
        List<Ball> balls = new LinkedList<>();

        for (int index = 0; index < ballNumbers.size(); index++) {
            balls.add(generateBall(ballNumbers, index));
        }

        return balls;
    }

    private Ball generateBall(List<Integer> ballNumbers, int index) {
        return new Ball(ballNumbers.get(index), index + 1);
    }

    public BallStatus compare(Ball ball) {
        return balls.stream()
                .map(ball::compare)
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
