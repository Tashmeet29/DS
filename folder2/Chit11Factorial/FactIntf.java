import java.rmi.*;

public interface FactIntf extends Remote {
	long calculateFact(int number) throws RemoteException;
}
