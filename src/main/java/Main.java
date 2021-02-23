public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread firstThread = new Thread(new RunnableImpl(counter));
        Thread secondThread = new ThreadImpl(counter);
        firstThread.start();
        secondThread.start();
    }
}
