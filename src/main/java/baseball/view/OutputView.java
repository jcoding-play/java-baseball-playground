package baseball.view;

import baseball.utils.Constants;

public class OutputView {
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String RESULT_MESSAGE_FORMAT = "%s %s";
    private static final String END_MESSAGE_FORMAT = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private static final int NOTHING_COUNT = 0;

    public void printPlayResult(int ball, int strike) {
        System.out.println(generateResultMessage(ball, strike));
    }

    private String generateResultMessage(int ball, int strike) {
        if (isNothing(ball, strike)) {
            return NOTHING_MESSAGE;
        }
        return generateResultMessageOf(ball, strike);
    }

    private boolean isNothing(int ball, int strike) {
        return ball == NOTHING_COUNT && strike == NOTHING_COUNT;
    }

    private String generateResultMessageOf(int ball, int strike) {
        String ballMessage = generateMessageOf(ball, BALL_MESSAGE);
        String strikeMessage = generateMessageOf(strike, STRIKE_MESSAGE);

        return String.format(RESULT_MESSAGE_FORMAT, ballMessage, strikeMessage).trim();
    }

    private String generateMessageOf(int count, String suffix) {
        return count + suffix;
    }

    public void printEndMessage() {
        System.out.printf(END_MESSAGE_FORMAT, Constants.VALID_BALLS_SIZE);
    }
}
