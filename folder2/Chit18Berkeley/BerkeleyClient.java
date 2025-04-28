import java.io.*;
import java.net.*;
import java.util.*;

public class BerkeleyClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Simulate a random client clock
            Random random = new Random();
            long clientClock = System.currentTimeMillis() + random.nextInt(1000) - 500;
            System.out.println("Client clock before synchronization: " + clientClock);

            // Send the client's clock to the coordinator
            out.println(clientClock);

            // Receive the synchronized time from the coordinator
            String averageClockStr = in.readLine();
            long synchronizedClock = Long.parseLong(averageClockStr);
            System.out.println("Client clock after synchronization: " + synchronizedClock);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

