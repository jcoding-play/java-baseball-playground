package baseball.controller;

import baseball.domain.*;
import baseball.utils.Converter;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator<List<Integer>> numberGenerator;

    public MainController(InputView inputView, OutputView outputView, NumberGenerator<List<Integer>> numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        BaseballGame baseballGame = new BaseballGame(numberGenerator);

        start(baseballGame);
    }

    private void start(BaseballGame baseballGame) {
        play(baseballGame);

        outputView.printEndMessage();
        determineToRestartOrNot(baseballGame);
    }

    private void play(BaseballGame baseballGame) {
        while (baseballGame.isPlayable()) {
            Balls userBalls = readUserBalls();
            PlayResult playResult = baseballGame.play(userBalls);

            outputView.printPlayResult(playResult.getBall(), playResult.getStrike());
        }
    }

    private Balls readUserBalls() {
        String readBallNumbers = inputView.readBallNumbers();
        List<Integer> ballNumbers = Converter.convertToIntegerList(readBallNumbers);

        return new Balls(ballNumbers);
    }

    private void determineToRestartOrNot(BaseballGame baseballGame) {
        GameCommand gameCommand = GameCommand.from(inputView.readGameCommand());

        if (baseballGame.canRestart(gameCommand)) {
            baseballGame.restart(numberGenerator);
            start(baseballGame);
        }
    }
}
