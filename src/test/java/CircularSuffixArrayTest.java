import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CircularSuffixArrayTest {

    @Test
    void index() {
        String input = "ABRACADABRA!";
        int[] expected = new int[] {11,10,7,0,3,5,8,1,4,6,9,2};
        CircularSuffixArray testee = new CircularSuffixArray(input);

        assertThat(testee.length()).isEqualTo(input.length());
        for (int i = 0; i < expected.length; i++) {
            assertThat(testee.index(i)).isEqualTo(expected[i]);
        }
    }
}