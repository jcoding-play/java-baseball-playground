package baseball;

import baseball.controller.MainController;
import baseball.domain.NumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        ApplicationConfiguration applicationConfiguration = new ApplicationConfiguration();
        InputView inputView = applicationConfiguration.inputView();
        OutputView outputView = applicationConfiguration.outputView();
        NumberGenerator<List<Integer>> numberGenerator = applicationConfiguration.numberGenerator();

        MainController mainController = new MainController(inputView, outputView, numberGenerator);
        mainController.run();
    }
}
