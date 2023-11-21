package baseball.domain;

import java.util.List;
import java.util.Map;

public class BaseballGame {
    private final Balls computerBalls;
    private GameState gameState;

    public BaseballGame(List<Integer> ballNumbers) {
        this.computerBalls = new Balls(ballNumbers);
        this.gameState = GameState.PLAYING;
    }

    public PlayResult play(Balls userBalls) {
        Map<BallStatus, Integer> result = computerBalls.compare(userBalls);
        PlayResult playResult = new PlayResult(result);

        if (playResult.isThreeStrike()) {
            gameState = GameState.END;
        }
        return playResult;
    }

    public boolean isPlayable() {
        return gameState.isPlaying();
    }
}
