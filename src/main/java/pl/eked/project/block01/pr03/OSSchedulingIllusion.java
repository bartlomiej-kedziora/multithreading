package pl.eked.project.block01.pr03;

import java.util.List;

/**
 * MINI-PROJECT 3: OS Scheduling Illusion
 *
 * Goal:
 * Experience non-deterministic execution order caused by OS scheduling.
 *
 * Task:
 * - Start 5 threads
 * - Each thread prints numbers from 1 to 5
 * - Run the program multiple times
 *
 * Key Concept:
 * - Thread start order does NOT guarantee execution order
 *
 * Expected Outcome:
 * - Accept that concurrency is inherently non-deterministic
 */
public class OSSchedulingIllusion {

    public static void main(String[] args) {
        List<Thread> threads = List.of(
            new Thread(new ThreadTask()),
            new Thread(new ThreadTask()),
            new Thread(new ThreadTask()),
            new Thread(new ThreadTask()),
            new Thread(new ThreadTask())
        );

        threads.forEach(Thread::start);
    }

    private static class ThreadTask implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " started counting: ");
            for (int i = 1; i < 6; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
