import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SumExecutorTest {
    private static Integer expected;
    private static SumExecutor executor;
    private static List<Integer> integerList;

    @BeforeAll
    static void beforeAll() {
        integerList = Util.generate();
        expected = integerList.stream()
                .reduce(Integer::sum)
                .get();
        executor = new SumExecutor();
    }

    @Test
    void getSum_Ok() {
        Assertions.assertEquals(expected, executor.getSum(integerList));
    }

    @Test
    void getSum_NotOk() {
        Assertions.assertNotEquals(100, executor.getSum(integerList));
    }
}
