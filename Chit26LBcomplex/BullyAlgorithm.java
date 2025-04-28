import java.util.*;

class Process {
    int id;
    boolean isActive;

    Process(int id) {
        this.id = id;
        this.isActive = true;
    }

    void deactivate() {
        isActive = false;
    }

    void activate() {
        isActive = true;
    }
}

public class BullyAlgorithm {
    static Process[] processes;
    static int messageCount = 0; // to demonstrate time complexity

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        
        processes = new Process[n];
        for (int i = 0; i < n; i++) {
            processes[i] = new Process(i + 1); // IDs from 1 to n
        }

        System.out.print("Enter the process ID which failed: ");
        int failedId = sc.nextInt();
        processes[failedId - 1].deactivate();

        System.out.print("Enter the process ID which detects failure: ");
        int initiatorId = sc.nextInt();

        int coordinator = initiateElection(initiatorId);
        System.out.println("\nNew Coordinator is Process " + coordinator);
        System.out.println("\nTotal messages exchanged: " + messageCount);
    }

    static int initiateElection(int initiatorId) {
        System.out.println("\nElection initiated by Process " + initiatorId);

        boolean higherProcessExists = false;
        for (int i = initiatorId; i < processes.length; i++) {
            if (processes[i].isActive) {
                System.out.println("Process " + initiatorId + " sends Election message to Process " + processes[i].id);
                messageCount++;
                higherProcessExists = true;
            }
        }

        if (!higherProcessExists) {
            System.out.println("Process " + initiatorId + " becomes Coordinator (no higher active processes)");
            return initiatorId;
        }

        int newCoordinator = -1;
        for (int i = processes.length - 1; i >= 0; i--) {
            if (processes[i].isActive) {
                newCoordinator = processes[i].id;
                break;
            }
        }

        for (int i = 0; i < processes.length; i++) {
            if (processes[i].isActive && processes[i].id != newCoordinator) {
                System.out.println("Coordinator message sent from Process " + newCoordinator + " to Process " + processes[i].id);
                messageCount++;
            }
        }
        return newCoordinator;
    }
}

