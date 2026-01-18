package pl.eked.exercise.block01.ex04;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Topics:
 * - thread.join() as a solution for waiting on the results of thread
 * - thread.join(x ms) as a solution for skipping thread if executed more than x ms.
 * - case study - sum result of base^power for two threads
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = List.of(1000000L, 0L, 100L, 3435L, 35435L, 2324L, 4656L, 23L, 2435L, 5566L);

        List<FactorialThread> threads = new ArrayList<>();

        for (long inputNumber : inputNumbers) {
            threads.add(new FactorialThread(inputNumber));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread: threads) {
            thread.join(2_000); //wait 2s per computation -> will skip first 1000000L
        }

        for (int i = 0; i < threads.size(); i++) {
            FactorialThread factorialThread = threads.get(i);
            if (factorialThread.isFinished()) {
                System.out.println(
                    "Factorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
            } else {
                System.out.println(
                    "The calculation for " + inputNumbers.get(i) + " is still in progress.");
            }
        }
    }

    private static class FactorialThread extends Thread {

        private long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;

        public FactorialThread(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.isFinished = true;
        }

        public BigInteger factorial(long n) {
            BigInteger tempResult = BigInteger.ONE;

            for (long i = n; i > 0; i--) {
                tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
            }
            return tempResult;
        }

        public boolean isFinished() {
            return isFinished;
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
