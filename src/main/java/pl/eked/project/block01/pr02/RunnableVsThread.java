package pl.eked.project.block01.pr02;

/**
 * MINI-PROJECT 2: Runnable vs Thread
 *
 * Goal:
 * Understand why implementing Runnable is preferred over extending Thread.
 *
 * Task:
 * - Create one thread by extending Thread
 * - Create another thread by implementing Runnable
 * - Assign names to both threads
 * - Start both and print their names
 *
 * Key Questions:
 * - What do you lose by extending Thread?
 * - What is the difference between "task" and "execution mechanism"?
 *
 * Expected Outcome:
 * - Clear separation between business logic (Runnable)
 *   and execution (Thread)
 */
public class RunnableVsThread {

    public static void main(String[] args) {
        Thread thread1 = new MyCustomThread();
        thread1.setName("MyCustomThread");

        Thread thread2 = new Thread(new MyCustomThreadTask());
        thread2.setName("MyCustomThread2");

        thread1.start();
        thread2.start();
    }

    private static class MyCustomThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread1 strong coupling WHAT + WHERE + HOW");
            System.out.println("Thread1 name: " + this.getName());
        }
    }

    private static class MyCustomThreadTask implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread2 decoupling WHAT");
            System.out.println("Thread2 name: " + Thread.currentThread().getName());
        }
    }
}
