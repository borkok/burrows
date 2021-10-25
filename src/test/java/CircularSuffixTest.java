import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CircularSuffixTest {

    @Test
    public void absoluteIndex_same() {
        CircularSuffix testee = new CircularSuffix("ABCDE", 0);
        assertThat(testee.absoluteIndex(0)).isEqualTo(0);
        assertThat(testee.absoluteIndex(4)).isEqualTo(4);
    }

    @Test
    public void absoluteIndex_relative() {
        CircularSuffix testee = new CircularSuffix("ABCDE", 4);
        assertThat(testee.absoluteIndex(0)).isEqualTo(4);
        assertThat(testee.absoluteIndex(1)).isEqualTo(0);
        assertThat(testee.absoluteIndex(4)).isEqualTo(3);
    }

    @Test
    public void getAtRelativeIndex() {
        CircularSuffix testee = new CircularSuffix("ABCDE", 3);
        assertThat(testee.getAtRelativeIndex(0)).isEqualTo('D');
        assertThat(testee.getAtRelativeIndex(1)).isEqualTo('E');
        assertThat(testee.getAtRelativeIndex(4)).isEqualTo('C');
    }

    @Test
    public void compare() {
        CircularSuffix one = new CircularSuffix("ABCDE", 2);
        CircularSuffix other = new CircularSuffix("EDCBA", 4);
        assertThat(one.compareTo(other)).isGreaterThan(0);
        assertThat(other.compareTo(one)).isLessThan(0);
    }

    @Test
    public void compare_equal() {
        CircularSuffix one = new CircularSuffix("ABABAB", 2);
        CircularSuffix other = new CircularSuffix("ABABAB", 4);
        assertThat(one.compareTo(other)).isZero();
        assertThat(other.compareTo(one)).isZero();
    }
}