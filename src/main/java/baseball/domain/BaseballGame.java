package baseball.domain;

import java.util.List;
import java.util.Map;

public class BaseballGame {
    private final Balls computerBalls;
    private GameState gameState;

    public BaseballGame(NumberGenerator<List<Integer>> numberGenerator) {
        this.computerBalls = new Balls(numberGenerator.generate());
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

    public boolean canRestart(GameCommand gameCommand) {
        return gameCommand.isRestart();
    }
}
