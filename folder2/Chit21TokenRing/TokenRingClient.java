import java.io.*;
import java.net.*;

public class TokenRingClient {
    static final int CLIENT_PORT = 5001;
    static final int SERVER_PORT = 5000;
    static final String SERVER_IP = "localhost";

    public static void main(String[] args) {
        try {
            ServerSocket clientSocket = new ServerSocket(CLIENT_PORT);
            System.out.println("Client started at port " + CLIENT_PORT);

            while (true) {
                Socket server = clientSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
                String received = in.readLine();
                server.close();

                // Process received token
                String[] parts = received.split(";");
                int currentNode = Integer.parseInt(parts[0]);
                int receiverNode = Integer.parseInt(parts[1]);
                String data = parts[2];

                System.out.println("Token at node " + currentNode);

                if (currentNode == receiverNode) {
                    System.out.println("Receiver node " + receiverNode + " received the data: " + data);
                    break; // done
                }

                // Send acknowledgment back to server
                Socket ack = new Socket(SERVER_IP, SERVER_PORT);
                PrintWriter out = new PrintWriter(ack.getOutputStream(), true);
                out.println("ACK");
                ack.close();
            }

            clientSocket.close();
            System.out.println("\nClient exiting...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

