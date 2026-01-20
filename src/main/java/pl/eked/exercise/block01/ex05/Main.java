package pl.eked.exercise.block01.ex05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Topics:
 * - throughput - measure throughput in jmeter by changing number of threads in pool
 */
public class Main {
    private static final String INPUT_FILE = "src/main/resources/block01/ex05/war_and_peace.txt";

    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
        ThroughputHttpServer.startServer(text);
    }
}
