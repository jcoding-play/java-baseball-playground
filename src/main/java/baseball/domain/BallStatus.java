package baseball.domain;

public enum BallStatus {
    NOTHING, BALL, STRIKE;

    public boolean isNotNothing() {
        return this != NOTHING;
    }
}
