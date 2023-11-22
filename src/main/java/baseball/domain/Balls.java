package baseball.domain;

import baseball.utils.Constants;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> ballNumbers) {
        validateBallNumbers(ballNumbers);
        this.balls = BallMapper.mapFrom(ballNumbers);
    }

    private void validateBallNumbers(List<Integer> ballNumbers) {
        if (isInvalidSize(ballNumbers)) {
            throw new IllegalArgumentException(
                    String.format("공들의 개수는 %d개여야 합니다.", Constants.VALID_BALLS_SIZE));
        }
        if (hasDuplicatedBallNumber(ballNumbers)) {
            throw new IllegalArgumentException("공들 중 중복되는 숫자가 존재합니다.");
        }
    }

    private boolean isInvalidSize(List<Integer> ballNumbers) {
        return ballNumbers.size() != Constants.VALID_BALLS_SIZE;
    }

    private boolean hasDuplicatedBallNumber(List<Integer> ballNumbers) {
        return ballNumbers.size() != new HashSet<>(ballNumbers).size();
    }

    public Map<BallStatus, Integer> compare(Balls userBalls) {
        Map<BallStatus, Integer> result = new EnumMap<>(BallStatus.class);

        for (Ball ball : this.balls) {
            BallStatus ballStatus = userBalls.judgeBallStatusOf(ball);
            result.put(ballStatus, result.getOrDefault(ballStatus, Constants.INITIAL_COUNT) + 1);
        }

        return result;
    }

    protected BallStatus judgeBallStatusOf(Ball ball) {
        return balls.stream()
                .map(ball::compare)
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
