package pl.eked.project.block01.pr04;

/**
 * MINI-PROJECT 4: Daemon Thread Experiment
 *
 * Goal:
 * Understand the difference between daemon and worker threads.
 *
 * Task:
 * - Create a daemon thread that prints a message every second
 * - Do NOT block the main thread
 *
 * Key Concepts:
 * - JVM shutdown rules
 * - Daemon threads do not keep JVM alive
 *
 * Expected Outcome:
 * - JVM exits even if daemon thread is still running
 */
public class DaemonThreads {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyTask());
        thread.setDaemon(true);
        thread.start();
        //thread.join(); -> this will block main thread even if set daemon
    }

    private static class MyTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Message executed every 1s");
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
