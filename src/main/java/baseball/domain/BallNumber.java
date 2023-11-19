package baseball.domain;

import java.util.Objects;

public class BallNumber {
    private static final int MIN_BALL_NUMBER = 1;
    private static final int MAX_BALL_NUMBER = 9;

    private final int ballNumber;

    public BallNumber(int ballNumber) {
        validateBallNumber(ballNumber);
        this.ballNumber = ballNumber;
    }

    private void validateBallNumber(int ballNumber) {
        if (ballNumber < MIN_BALL_NUMBER || ballNumber > MAX_BALL_NUMBER) {
            throw new IllegalArgumentException(
                    String.format("공의 숫자 범위는 %d에서 %d사이의 값이어야 합니다.", MIN_BALL_NUMBER, MAX_BALL_NUMBER)
            );
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return ballNumber == that.ballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber);
    }
}
