package pl.eked.project.block01.pr05;

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

    public static void main(String[] args) {

    }
}
