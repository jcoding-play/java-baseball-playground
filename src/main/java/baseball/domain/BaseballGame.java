package baseball.domain;

import java.util.List;
import java.util.Map;

public class BaseballGame {
    private Balls computerBalls;
    private GameState gameState;

    public BaseballGame(NumberGenerator<List<Integer>> numberGenerator) {
        initializeBaseballGame(numberGenerator);
    }

    private void initializeBaseballGame(NumberGenerator<List<Integer>> numberGenerator) {
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

    public void restart(NumberGenerator<List<Integer>> numberGenerator) {
        validateGameState();

        initializeBaseballGame(numberGenerator);
    }

    private void validateGameState() {
        if (gameState.isPlaying()) {
            throw new IllegalArgumentException("게임이 종료되지 않은 상태에서 게임을 재시작할 수 없습니다.");
        }
    }
}
