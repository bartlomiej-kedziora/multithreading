package pl.eked.exercise.block02.ex06;

/**
 * Topics:
 * - debug main method line by line to see stack frames (main, sum) contain new items every line step
 */
public class Main {

    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        int result = sum(x, y);
    }

    private static int sum(int a, int b) {
        int s = a + b;
        return s;
    }
}
