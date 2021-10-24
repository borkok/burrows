import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MoveToFrontDecoderTest {
    private static Stream<Arguments> paramsDe() {
        return Stream.of(
                Arguments.of(new Character[]{0x41}, "A")
                ,Arguments.of(new Character[]{0x41, 0x00}, "AA")
                ,Arguments.of(new Character[]{
                        0x41, 0x42, 0x52, 0x02, 0x44, 0x01, 0x45, 0x01, 0x04, 0x04, 0x02, 0x26
                }, "ABRACADABRA!")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsDe")
    public void decode(Character[] input, String expected) {
        MoveToFrontDecoder testee = new MoveToFrontDecoder();
        StringBuilder result = new StringBuilder();
        for (char c : input) {
            result.append(testee.decode(c));
        }

        String expectedByteString = makeByteString(expected);
        String actualByteString = makeByteString(result.toString());
        assertThat(actualByteString)
                .isEqualTo(expectedByteString);
    }

    private String makeByteString(String result) {
        return result.chars()
                .mapToObj(Integer::toHexString)
                .collect(Collectors.joining(", "));
    }
}