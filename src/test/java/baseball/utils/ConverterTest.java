package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ConverterTest {

    @Test
    @DisplayName("입력된 문자열을 숫자 리스트로 반환할 수 있다.")
    void convertToIntegerList() {
        String input = "123";
        List<Integer> result = Converter.convertToIntegerList(input);

        assertThat(result).contains(1, 2, 3);
    }
}