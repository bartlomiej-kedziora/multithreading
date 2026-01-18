package pl.eked.project.block01.pr05;

import java.util.List;
import java.util.Random;

/**
 * MINI-PROJECT 5: join() as Synchronization
 *
 * Goal:
 * Understand join() as a synchronization mechanism without locks.
 *
 * Task:
 * - Start 3 worker threads
 * - Each sleeps for a random time
 * - Run once WITHOUT join()
 * - Run once WITH join()
 *
 * Key Concepts:
 * - join() blocks the calling thread
 * - join() acts as a completion barrier
 *
 * Expected Outcome:
 * - Observe deterministic completion only when join() is used
 */
public class JoinAsSynchronization {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = List.of(
            new Thread(new MyTask()),
            new Thread(new MyTask()),
            new Thread(new MyTask())
        );

        for (Thread thread : threads) {
            thread.start();
            thread.join(); // if commented threads execute in concurrent else step by step
        }
    }

    private static class MyTask implements Runnable {

        @Override
        public void run() {
            int randomSleepCounter = new Random().nextInt(100, 1000);
            try {
                System.out.println(Thread.currentThread().getName() + " went sleep for " + randomSleepCounter + " ms");
                Thread.sleep(randomSleepCounter);
                System.out.println(Thread.currentThread().getName() + " woke up");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
