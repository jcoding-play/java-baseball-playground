package baseball.domain;

public enum GameCommand {
    RESTART(1),
    QUIT(2);

    private final int command;

    GameCommand(int command) {
        this.command = command;
    }

    public boolean isRestart() {
        return this == RESTART;
    }
}
