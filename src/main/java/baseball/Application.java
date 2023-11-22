package baseball;

import baseball.controller.MainController;
import baseball.domain.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.validator.InputValidator;

public class Application {

    public static void main(String[] args) {
        MainController mainController = new MainController(new InputView(new InputValidator()), new OutputView(), new RandomNumberGenerator());
        mainController.run();
    }
}
