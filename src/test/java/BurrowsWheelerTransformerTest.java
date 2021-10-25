import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BurrowsWheelerTransformerTest {

    @Test
    void transform() {
        BurrowsWheelerTransformer testee = new BurrowsWheelerTransformer("ABRACADABRA!");
        assertThat(testee.getFirst()).isEqualTo(3);
        assertThat(testee.getLastColumn()).isEqualTo("ARD!RCAAAABB");
    }
}