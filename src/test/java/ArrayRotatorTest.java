import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ArrayRotatorTest {

    @Test
    void rotateRight() {
        char[] input = {'A', 'B', 'C', 'D', 'E'};
        ArrayRotator.rotateRight(input,2);
        assertThat(input).containsExactly('C','A','B','D','E');
    }

    @Test
    void rotateRight_noMoveNeeded() {
        char[] input = {'A', 'B', 'C', 'D', 'E'};
        ArrayRotator.rotateRight(input,0);
        assertThat(input).containsExactly('A', 'B', 'C', 'D', 'E');
    }

    @Test
    void rotateRight_exception() {
        char[] input = {'A', 'B', 'C', 'D', 'E'};
        assertThatThrownBy(() -> ArrayRotator.rotateRight(input,5)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ArrayRotator.rotateRight(input,-1)).isInstanceOf(IllegalArgumentException.class);
    }
}