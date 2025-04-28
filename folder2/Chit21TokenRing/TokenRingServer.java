import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TokenRingServer {
    static final int SERVER_PORT = 5000;
    static final int CLIENT_PORT = 5001;
    static final String CLIENT_IP = "localhost";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started at port " + SERVER_PORT);

            System.out.print("Enter number of nodes in ring: ");
            int nodes = scanner.nextInt();

            System.out.print("Enter sender node ID (0 to " + (nodes - 1) + "): ");
            int sender = scanner.nextInt();

            System.out.print("Enter receiver node ID (0 to " + (nodes - 1) + "): ");
            int receiver = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Enter data to send: ");
            String data = scanner.nextLine();

            int current = sender;

            while (true) {
                System.out.println("Token at node " + current);

                // Send current node info to client
                Socket clientSocket = new Socket(CLIENT_IP, CLIENT_PORT);
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println(current + ";" + receiver + ";" + data);
                clientSocket.close();

                if (current == receiver) {
                    System.out.println("Receiver node " + receiver + " received the data: " + data);
                    break;
                }

                current = (current + 1) % nodes; // next node in ring

                // Wait for acknowledgment from client
                Socket ackSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(ackSocket.getInputStream()));
                String ack = in.readLine();
                if (ack.equals("ACK")) {
                    System.out.println("Acknowledgement received from client.");
                }
                ackSocket.close();
            }

            serverSocket.close();
            System.out.println("\nServer exiting...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

