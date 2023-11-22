package baseball;

import baseball.domain.NumberGenerator;
import baseball.domain.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.validator.InputValidator;

import java.util.List;

public class ApplicationConfiguration {

    public InputView inputView() {
        return new InputView(inputValidator());
    }

    private InputValidator inputValidator() {
        return new InputValidator();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public NumberGenerator<List<Integer>> numberGenerator() {
        return new RandomNumberGenerator();
    }
}
