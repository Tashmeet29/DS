import mpi.*;

public class DistributedSumServer {
    public static void main(String[] args) throws Exception {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int totalNumbers = 8; // Total numbers to sum
        int[] numbers = new int[totalNumbers];
        int chunkSize = totalNumbers / (size - 1); // Exclude server (rank 0)

        if (rank == 0) {
            // Server part: Initialize numbers
            for (int i = 0; i < totalNumbers; i++) {
                numbers[i] = i + 1; // [1,2,3,4,5,6,7,8]
            }

            System.out.println("Server initialized numbers: ");
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();

            // Distribute chunks to clients
            for (int i = 1; i < size; i++) {
                int[] chunk = new int[chunkSize];
                System.arraycopy(numbers, (i - 1) * chunkSize, chunk, 0, chunkSize);
                System.out.println("Server sending chunk to client " + i);
                MPI.COMM_WORLD.Send(chunk, 0, chunkSize, MPI.INT, i, 0);
            }

            // Collect partial sums from clients
            int totalSum = 0;
            for (int i = 1; i < size; i++) {
                int[] partialSum = new int[1];
                MPI.COMM_WORLD.Recv(partialSum, 0, 1, MPI.INT, i, 1);
                totalSum += partialSum[0];
            }

            System.out.println("Final Sum calculated at Server: " + totalSum);
        }

        MPI.Finalize();
    }
}

