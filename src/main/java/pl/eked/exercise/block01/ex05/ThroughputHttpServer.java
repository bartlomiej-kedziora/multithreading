package pl.eked.exercise.block01.ex05;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThroughputHttpServer {
    private static final InetSocketAddress PORT = new InetSocketAddress(8000);
    private static final int NUMBER_OF_THREADS = 1;

    public static void startServer(String text) throws IOException {
        HttpServer server = HttpServer.create(PORT, 0);
        server.createContext("/search", new WordCountHandler(text));
        Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        server.setExecutor(executor);
        server.start();
    }
}
