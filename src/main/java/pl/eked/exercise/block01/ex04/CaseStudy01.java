package pl.eked.exercise.block01.ex04;

import java.math.BigInteger;
import java.util.List;

/**
 * Calculate result = ( base1 ^ power1 ) + (base2 ^ power2). Where each calculation in (..) is
 * calculated on a different thread Note : base1 >= 0, base2 >= 0, power1 >= 0, power2 >= 0
 */
public class CaseStudy01 {

    public static void main(String[] args) throws InterruptedException {
        int base1 = 10;
        int power1 = 2;
        int base2 = 100;
        int power2 = 2;
        PowerCalculatingThread powerCalculatingThread1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread powerCalculatingThread2 = new PowerCalculatingThread(base2, power2);
        List<PowerCalculatingThread> threads = List.of(powerCalculatingThread1,
            powerCalculatingThread2);

        for (PowerCalculatingThread thread : threads) {
            thread.start();
        }

        for (PowerCalculatingThread thread : threads) {
            thread.join();
        }

        BigInteger sum = threads.stream()
            .map(PowerCalculatingThread::getResult)
            .reduce(BigInteger.ZERO, BigInteger::add);

        System.out.println(base1 + "^" + power1 + " + " + base2 + "^" + power2
            + " = " + powerCalculatingThread1.getResult() + " + "
            + powerCalculatingThread2.getResult()
            + " = " + sum);
    }

    private static class PowerCalculatingThread extends Thread {

        private final int base;
        private final int power;
        private BigInteger result;

        public PowerCalculatingThread(int base, int power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            this.result = calculate();
        }

        public BigInteger getResult() {
            return result;
        }

        private BigInteger calculate() {
            if (base < 0 || power < 0) {
                System.out.println("Base or power value is less than 0. Resetting result to Zero");
                return BigInteger.ZERO;
            }

            return BigInteger.valueOf(base).pow(power);
        }
    }
}
