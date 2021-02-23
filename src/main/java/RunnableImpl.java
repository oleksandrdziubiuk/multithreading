import org.apache.log4j.Logger;

public class RunnableImpl implements Runnable {
    private static final Logger logger = Logger.getLogger(RunnableImpl.class);
    private final Counter counter;

    public RunnableImpl(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getCount() < 100) {
            counter.increment();
            logger.info(Thread.currentThread().getName() + ":" + counter.getCount());
        }
    }
}
