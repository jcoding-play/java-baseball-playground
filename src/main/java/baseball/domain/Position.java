package baseball.domain;

import java.util.Objects;

public class Position {
    private static final int MINIMUM_POSITION = 1;
    private static final int MAXIMUM_POSITION = 3;

    private final int position;

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < MINIMUM_POSITION || position > MAXIMUM_POSITION) {
            throw new IllegalArgumentException(
                    String.format("공의 위치는 %d에서 %d사이어야 합니다.", MINIMUM_POSITION, MAXIMUM_POSITION));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
