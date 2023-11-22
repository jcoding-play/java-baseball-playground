package baseball.domain;

import baseball.utils.Constants;

import java.util.Map;
import java.util.Objects;

public class PlayResult {
    private static final int MAXIMUM_STRIKE_COUNT = 3;

    private final int strike;
    private final int ball;

    protected PlayResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public PlayResult(Map<BallStatus, Integer> playResult) {
        this.strike = findCountOf(BallStatus.STRIKE, playResult);
        this.ball = findCountOf(BallStatus.BALL, playResult);
    }

    private int findCountOf(BallStatus ballStatus, Map<BallStatus, Integer> playResult) {
        return playResult.getOrDefault(ballStatus, Constants.INITIAL_COUNT);
    }

    public boolean isThreeStrike() {
        return strike == MAXIMUM_STRIKE_COUNT;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayResult result = (PlayResult) o;
        return strike == result.strike && ball == result.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
