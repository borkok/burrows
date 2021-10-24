import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MoveToFrontEncoderTest {
    private static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of("A", new Character[]{0x41}),
                Arguments.of("AA", new Character[]{0x41, 0x00}),
                Arguments.of("ABRACADABRA!", new Character[]{
                        0x41, 0x42, 0x52, 0x02, 0x44, 0x01, 0x45, 0x01, 0x04, 0x04, 0x02, 0x26
                })
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    public void encode(String input, Character[] expected) {
        MoveToFrontEncoder testee = new MoveToFrontEncoder();
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            result.append(testee.encode(c));
        }

        String expectedByteString = makeByteString(expected);
        String actualByteString = makeByteString(result.toString());
        assertThat(actualByteString)
                .isEqualTo(expectedByteString);
    }

    private String makeByteString(Character[] result) {
        return Arrays.stream(result)
                .map(c -> Integer.toHexString((int) c))
                .collect(Collectors.joining(", "));
    }

    private String makeByteString(String result) {
        return result.chars()
                .mapToObj(Integer::toHexString)
                .collect(Collectors.joining(", "));
    }
}