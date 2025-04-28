import mpi.*;

public class DistributedSumServer {
    public static void main(String[] args) throws MPIException {
        // Initialize MPI environment
        MPI.Init(args);
        
        // Get the rank (ID) and size (total number of processes)
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        // Root process (rank 0) initializes the data
        int[] data = null;
        if (rank == 0) {
            // Assume the array has a length equal to the number of processes
            data = new int[size];
            // Fill the array with values (e.g., 1 to size)
            for (int i = 0; i < size; i++) {
                data[i] = i + 1; // Initialize with 1, 2, ..., size
            }
        }

        // Scatter the data to all processes
        int[] recv = new int[1];
        MPI.COMM_WORLD.Scatter(data, 0, 1, MPI.INT, recv, 0, 1, MPI.INT, 0);

        // Each process computes its partial sum
        int partialSum = recv[0];

        // Use MPI.Gather to collect partial sums at root (rank 0)
        int[] totalSums = null;
        if (rank == 0) {
            totalSums = new int[size];
        }
        MPI.COMM_WORLD.Gather(new int[] {partialSum}, 0, 1, MPI.INT, totalSums, 0, 1, MPI.INT, 0);

        // The root process computes and displays the total sum
        if (rank == 0) {
            int totalSum = 0;
            for (int i = 0; i < size; i++) {
                totalSum += totalSums[i];
            }
            System.out.println("Total Sum: " + totalSum);
        }

        // Finalize the MPI environment
        MPI.Finalize();
    }
}

