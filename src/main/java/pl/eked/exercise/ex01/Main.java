package pl.eked.exercise.ex01;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * Topics:
 * - thread creation.
 * - thread exception handling.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = createThread();
        System.out.println("We are in thread: " + Thread.currentThread().getName()
            + " before starting a new thread");
        thread.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName()
            + " after starting a new thread");
        Thread.sleep(10_000);

        Thread thread1 = createThread1();
        thread1.start();

        System.out.println("I'm still alive, thread ex");
    }

    private static Thread createThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are now in thread: " + Thread.currentThread().getName());
                System.out.println(
                    "Current thread priority is: " + Thread.currentThread().getPriority());
            }
        });
        thread.setName("New Worker Thread");
        thread.setPriority(Thread.MAX_PRIORITY);

        return thread;
    }

    private static Thread createThread1() {
        Thread thread = new Thread(() -> {
            throw new RuntimeException("Intentional exception");
        });
        thread.setName("Misbehaving thread");

        thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(
                    "A critical error happened in thread " + t.getName() + " the error is "
                        + e.getMessage());
            }
        });

        return thread;
    }
}