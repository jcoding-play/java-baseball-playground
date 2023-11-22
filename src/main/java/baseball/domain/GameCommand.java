package baseball.domain;

import java.util.Arrays;

public enum GameCommand {
    RESTART(1),
    QUIT(2);

    private final int command;

    GameCommand(int command) {
        this.command = command;
    }

    public static GameCommand from(int command) {
        return Arrays.stream(values())
                .filter(gameCommand -> gameCommand.isMatchCommand(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다."));
    }

    private boolean isMatchCommand(int command) {
        return this.command == command;
    }

    public boolean isRestart() {
        return this == RESTART;
    }
}
