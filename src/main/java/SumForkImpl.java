import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SumForkImpl extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 100_000;
    private final List<Integer> list;

    public SumForkImpl(List<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer compute() {
        return list.size() > THRESHOLD ? ForkJoinTask.invokeAll(createSubtask())
                .stream()
                .mapToInt(ForkJoinTask::join)
                .sum()
                : processing(list);
    }

    private Collection<SumForkImpl> createSubtask() {
        List<SumForkImpl> tasks = new ArrayList<>();
        tasks.add(new SumForkImpl(list.subList(0, list.size() / 2)));
        tasks.add(new SumForkImpl(list.subList(list.size() / 2, list.size())));
        return tasks;
    }

    private Integer processing(List<Integer> list) {
        return list.stream()
                .reduce(Integer::sum)
                .get();
    }
}
