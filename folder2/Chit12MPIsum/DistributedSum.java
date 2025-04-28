import mpi.*;

public class DistributedSum {

    public static void main(String[] args) {
        // Initialize MPI
        MPI.Init(args);

        // Get rank and size
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        // Define the total data to sum
        int[] data = new int[100]; // Assuming 100 elements to sum
        int chunkSize = data.length / size;
        int[] receivedChunk = new int[chunkSize];

        // Initialize the data array (only for the server process)
        if (rank == 0) {
            // Fill the data array with values (1 to 100 for example)
            for (int i = 0; i < data.length; i++) {
                data[i] = i + 1;
            }
        }

        // Scatter the data to all processes
        MPI.COMM_WORLD.Scatter(data, 0, chunkSize, MPI.INT, receivedChunk, 0, chunkSize, MPI.INT, 0);

        // Each process computes the partial sum of its chunk
        int partialSum = 0;
        for (int i = 0; i < receivedChunk.length; i++) {
            partialSum += receivedChunk[i];
        }

        // Collect the partial sums at the server (rank 0)
        int[] partialSums = new int[size];
        MPI.COMM_WORLD.Gather(new int[]{partialSum}, 0, 1, MPI.INT, partialSums, 0, 1, MPI.INT, 0);

        // Server (rank 0) prints the total sum
        if (rank == 0) {
            int totalSum = 0;
            for (int i = 0; i < partialSums.length; i++) {
                totalSum += partialSums[i];
            }
            System.out.println("Total Sum: " + totalSum);
        }

        // Finalize MPI
        MPI.Finalize();
    }
}

