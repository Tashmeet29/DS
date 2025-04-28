import java.io.*;
import java.net.*;

public class TokenRingServer {
    private static final int PORT = 12345; // Port number for communication
    private static final String NEXT_HOST = "192.168.1.2"; // Next machine's IP
    private static final int NEXT_PORT = 12345; // Same port as this server

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Token Ring Server started, waiting for client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Token ring communication
            while (true) {
                // Simulate Critical Section Access
                System.out.println("Server (Coordinator) has the token and entering Critical Section...");
                Thread.sleep(5000); // Critical Section Access (simulated for 5 seconds)

                // After using CS, pass the token to the next machine
                passTokenToNext();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void passTokenToNext() {
        try (Socket socket = new Socket(NEXT_HOST, NEXT_PORT)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("TOKEN"); // Send token to the next machine
            System.out.println("Server passed the token to the next machine.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

