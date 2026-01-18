package pl.eked.project.block01.pr01;

/**
 * MINI-PROJECT 1: Thread Lifecycle in Practice
 *
 * Goal:
 * Observe real Java thread states during execution and understand that
 * RUNNABLE does NOT mean "currently running on CPU".
 *
 * Task:
 * - Create a worker thread that:
 *   - prints its name
 *   - sleeps for a short time
 *   - finishes execution
 * - From the main thread:
 *   - print the thread state BEFORE start()
 *   - print the state AFTER start()
 *   - print the state WHILE the thread is sleeping
 *   - print the state AFTER join()
 *
 * Key Concepts:
 * - Thread states: NEW, RUNNABLE, WAITING, TERMINATED
 * - OS scheduling vs JVM thread state
 *
 * Expected Outcome:
 * - Understand that RUNNABLE includes both "ready" and "running"
 * - See how join() moves a thread into WAITING
 */
public class ThreadLifecycle {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = createThread();

        System.out.println("thread state BEFORE start(): " + thread.getState());
        thread.start();
        Thread.sleep(100);
        System.out.println("thread state AFTER start(): " + thread.getState());
        thread.join();
        System.out.println("thread state AFTER join(): " + thread.getState());
    }

    private static Thread createThread() {
        return new Thread(() -> {
            System.out.println("My name is: " + Thread.currentThread().getName());
            try {
                System.out.println("thread state before sleep(): " + Thread.currentThread().getState());
                Thread.sleep(2_000);
                System.out.println("thread state after sleep(): " + Thread.currentThread().getState());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
