package pl.eked.exercise.block01.ex03;

import java.math.BigInteger;

/**
 * Topics:
 * - remove thread (still consume resources, CPU, etc. even if not used)
 * - thread.interrupt() aka stop thread gracefully
 *      -> set flag isInterrupted to true, throw exception only if is in state sleep/wait/join
 *      -> do not terminate thread
 *  - daemon threads - background threads that do not prevent the app from exiting if the main thread terminates
 */
public class Main {

    public static void main(String[] args) {
        // Testing thread in sleep state
        Thread thread = new Thread(new BlockingTask());
        thread.start();
        thread.interrupt();

        // Testing thread in running state with checks isInterrupted to prevent long execution
        Thread thread1 = new Thread(new LongComputationTask(new BigInteger("20000"), new BigInteger("10000000"), true));
        thread1.start();
        thread1.interrupt(); // it will not stop thread1 because is in running state, but we can add condition check for isInterrupted()

        // Testing thread in running state with no checks isInterrupted, but executing it in background (daemon) to prevent blocking us
        Thread thread2 = new Thread(new LongComputationTask(new BigInteger("20000"), new BigInteger("10000000"), false));
        thread2.setDaemon(true);
        thread2.start();
        thread2.interrupt();
    }

    private static class BlockingTask implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(500_000);
            } catch (InterruptedException e) {
                System.out.println("Exiting blocking thread");
            }

            System.out.println("Exiting normally thread");
        }
    }

    private static class LongComputationTask implements Runnable {
        private BigInteger base;
        private BigInteger power;
        private boolean conditioned;

        public LongComputationTask(BigInteger base, BigInteger power, boolean conditioned) {
            this.base = base;
            this.power = power;
            this.conditioned = conditioned;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                if (conditioned && Thread.currentThread().isInterrupted()) {
                    System.out.println("Prematurely interrupted computation");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }

            return result;
        }
    }
}
