import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SumForkImplTest {
    private static Integer expected;
    private static SumForkImpl fork;

    @BeforeAll
    static void beforeAll() {
        expected = Util.generate().stream()
                .reduce(Integer::sum)
                .get();
        fork = new SumForkImpl(Util.generate());
    }

    @Test
    void compute_Ok() {
        Assertions.assertEquals(expected, fork.compute());
    }

    @Test
    void compute_NotOk() {
        Assertions.assertNotEquals(100_000, fork.compute());
    }
}
