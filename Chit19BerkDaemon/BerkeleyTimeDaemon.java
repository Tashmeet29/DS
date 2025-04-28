import java.io.*;
import java.net.*;
import java.util.*;

public class BerkeleyTimeDaemon {
    private static final int PORT = 12345; // Port number for communication
    private static final int NUM_CLIENTS = 2; // Number of clients (can be adjusted)

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Time Daemon Server started, waiting for clients...");

            // Listen for clients and handle each in a separate thread
            for (int i = 0; i < NUM_CLIENTS; i++) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Receive the client's clock time
                String clientClockStr = in.readLine();
                long clientClock = Long.parseLong(clientClockStr);

                // Get the current time of the server (coordinator)
                long serverClock = System.currentTimeMillis();
                long averageTime = (serverClock + clientClock) / 2;

                // Send the average time back to the client for synchronization
                out.println(averageTime);
                System.out.println("Coordinator sent synchronized time: " + averageTime);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

