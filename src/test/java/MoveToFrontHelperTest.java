import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MoveToFrontHelperTest {
    private static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of("A", new Character[]{0x41})
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    public void test(String input, Character[] expected) {
        MoveToFrontHelper testee = new MoveToFrontHelper();
        LinkedList<Character> result = new LinkedList<>();

        for (char c : input.toCharArray()) {
            result.add(testee.encode(c));
        }

        assertThat(result).hasSize(input.length())
                .containsExactlyElementsOf(Arrays.asList(expected));
    }
}