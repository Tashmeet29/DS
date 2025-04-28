import mpi.*;

public class MPIMultiplication {

    public static void main(String[] args) {
        try {
            // Initialize MPI
            MPI.Init(args);

            // Get the rank (ID) and size (total number of processes)
            int rank = MPI.COMM_RANK();
            int size = MPI.COMM_SIZE();
            
            // Define the array and local result
            int n = size;  // Size of the array, equal to the number of processes
            int localResult = 1; // Local result for each process
            
            // Root process generates the array
            int[] array = new int[n];
            if (rank == 0) {
                // Root process creates an array of size n
                for (int i = 0; i < n; i++) {
                    array[i] = i + 1;  // Values 1 to n
                }
            }
            
            // Scatter the array to all processes
            int localValue = 0;
            MPI.COMM_WORLD.scatter(array, 0, 1, MPI.INT, localValue, 0, 1, MPI.INT, 0);

            // Each process computes its local multiplication result
            localResult = localValue;
            
            // Display intermediate results at each process
            System.out.println("Process " + rank + " computed result: " + localResult);
            
            // Reduce all results to the root process using multiplication
            int totalResult = 0;
            totalResult = MPI.COMM_WORLD.reduce(localResult, MPI.PROD, 0);
            
            // Root process displays the final result
            if (rank == 0) {
                System.out.println("Final result of the multiplication: " + totalResult);
            }

            // Finalize MPI
            MPI.Finalize();
        } catch (MPIException e) {
            e.printStackTrace();
        }
    }
}

