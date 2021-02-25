import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumExecutor {
    private static final int THREADS = 4;

    private List<Callable<Integer>> getCallables(List<Integer> list) {
        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < list.size(); i += list.size() / THREADS) {
            int length = i + list.size() / THREADS;
            tasks.add(new SumExecutorImpl(list.subList(i, Math.min(length, list.size()))));
        }
        return tasks;
    }

    public int getSum(List<Integer> list) {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        List<Callable<Integer>> tasks = getCallables(list);
        try {
            List<Future<Integer>> futures = executor.invokeAll(tasks);
            int result = 0;
            for (Future<Integer> future : futures) {
                result += future.get();
            }
            executor.shutdown();
            return result;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Can't calculate result", e);
        }
    }
}
