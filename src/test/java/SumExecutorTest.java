import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SumExecutorTest {
    private static Integer expected;
    private static SumExecutor executor;

    @BeforeAll
    static void beforeAll() {
        expected = Util.generate().stream()
                .reduce(Integer::sum)
                .get();
        executor = new SumExecutor();
    }

    @Test
    void getSum_Ok() {
        Assertions.assertEquals(expected, executor.getSum());
    }

    @Test
    void getSum_NotOk() {
        Assertions.assertNotEquals(100, executor.getSum());
    }
}
