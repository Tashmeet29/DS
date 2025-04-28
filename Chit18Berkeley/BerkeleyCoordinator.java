import java.io.*;
import java.net.*;
import java.util.*;

public class BerkeleyCoordinator {
    private static final int PORT = 12345; // Port number for communication
    private static final int NUM_CLIENTS = 2; // Number of clients (for this example)

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Coordinator started...");
            
            // Listen for clients
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

                // Calculate average time (simulating a single coordinator in this case)
                long serverTime = System.currentTimeMillis();
                long averageTime = (serverTime + clientClock) / 2;

                // Send the average time back to the client for synchronization
                out.println(averageTime);
                System.out.println("Coordinator sent synchronized time: " + averageTime);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

