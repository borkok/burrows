import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BurrowsWheelerInverterTest {

    @Test
    void next() {
        BurrowsWheelerInverter testee = new BurrowsWheelerInverter(3, "ARD!RCAAAABB");
        assertThat(testee.next(0)).isEqualTo(3);
        assertThat(testee.next(8)).isEqualTo(5);
        assertThat(testee.next(9)).isEqualTo(2);
        assertThat(testee.next(10)).isEqualTo(1);
        assertThat(testee.next(11)).isEqualTo(4);
    }

    @Test
    void inverseTransform() {
        BurrowsWheelerInverter testee = new BurrowsWheelerInverter(3, "ARD!RCAAAABB");
        assertThat(testee.getResult()).isEqualTo("ABRACADABRA!");
    }
}
