import org.apache.log4j.Logger;

public class ThreadImpl extends Thread {
    private static final Logger logger = Logger.getLogger(ThreadImpl.class);
    private final Counter counter;

    public ThreadImpl(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        while (counter.getCount() < 100) {
            counter.increment();
            logger.info(Thread.currentThread().getName() + ":" + counter.getCount());
        }
    }
}
