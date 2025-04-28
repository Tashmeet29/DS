import java.rmi.*;
import java.rmi.server.*;

public class FactImpl extends UnicastRemoteObject implements FactIntf {
	public FactImpl() throws RemoteException {
		super();
	}
	
	public long calculateFact(int number) throws RemoteException {
		long factorial = 1;
		for(int i=1; i <= number; i++) {
			factorial *= i;
		}
		return factorial;
	}
}
