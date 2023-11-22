package baseball.utils;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    private Converter() {
    }

    public static List<Integer> convertToIntegerList(String input) {
        return input.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }
}
