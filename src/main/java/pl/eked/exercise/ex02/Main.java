package pl.eked.exercise.ex02;

/**
 * Topics:
 * - thread creation - another way
 * - case study - hackers as threads break into the vault, policeman thread caught them.
 */
public class Main {

    public static void main(String[] args) {
        Thread thread = new NewThread();
        thread.start();
    }

    private static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from: " + this.getName());
        }
    }
}
