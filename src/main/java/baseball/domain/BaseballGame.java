package baseball.domain;

import java.util.List;
import java.util.Map;

public class BaseballGame {
    private final Balls computerBalls;

    public BaseballGame(List<Integer> ballNumbers) {
        this.computerBalls = new Balls(ballNumbers);
    }

    public PlayResult play(Balls userBalls) {
        Map<BallStatus, Integer> result = computerBalls.compare(userBalls);

        return new PlayResult(result);
    }
}
