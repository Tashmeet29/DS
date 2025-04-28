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
}

public class TokenRingElection {
    static Process[] processes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        processes = new Process[n];
        for (int i = 0; i < n; i++) {
            processes[i] = new Process(i + 1); // Process IDs 1 to n
        }

        System.out.print("Enter the process ID which failed: ");
        int failedId = sc.nextInt();
        processes[failedId - 1].deactivate();

        System.out.print("Enter the process ID which detects failure: ");
        int initiatorId = sc.nextInt();

        startElection(initiatorId);
    }

    static void startElection(int initiatorId) {
        System.out.println("\nElection started by Process " + initiatorId);

        List<Integer> electionList = new ArrayList<>();
        int n = processes.length;
        int current = initiatorId - 1;

        do {
            if (processes[current].isActive) {
                System.out.println("Process " + processes[initiatorId - 1].id + " sends Election message to Process " + processes[current].id);
                electionList.add(processes[current].id);
            }
            current = (current + 1) % n;
        } while (current != (initiatorId - 1));

        int coordinator = Collections.max(electionList);

        System.out.println("\nElection Complete! New Coordinator is Process " + coordinator);

        // Announce coordinator
        current = initiatorId - 1;
        do {
            if (processes[current].isActive) {
                System.out.println("Coordinator message sent from Process " + coordinator + " to Process " + processes[current].id);
            }
            current = (current + 1) % n;
        } while (current != (initiatorId - 1));
    }
}

