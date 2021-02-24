import java.util.List;
import java.util.concurrent.Callable;

public class SumExecutorImpl implements Callable<Integer> {
    private final List<Integer> list;

    public SumExecutorImpl(List<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer call() {
        return list.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
