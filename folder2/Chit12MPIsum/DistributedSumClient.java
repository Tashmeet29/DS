import mpi.*;

public class DistributedSumClient {
    public static void main(String[] args) throws Exception {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int chunkSize = 8 / (size - 1); // Number of elements per client

        if (rank != 0) {
            // Client part: Receive chunk from the server
            int[] receivedChunk = new int[chunkSize];
            MPI.COMM_WORLD.Recv(receivedChunk, 0, chunkSize, MPI.INT, 0, 0);

            System.out.println("Client " + rank + " received chunk: ");
            for (int num : receivedChunk) {
                System.out.print(num + " ");
            }
            System.out.println();

            // Calculate partial sum
            int partialSum = 0;
            for (int num : receivedChunk) {
                partialSum += num;
            }

            // Send partial sum to server
            int[] sendPartialSum = new int[]{partialSum};
            MPI.COMM_WORLD.Send(sendPartialSum, 0, 1, MPI.INT, 0, 1);

            System.out.println("Client " + rank + " calculated partial sum: " + partialSum);
        }

        MPI.Finalize();
    }
}

