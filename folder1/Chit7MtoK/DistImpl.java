import java.rmi.*;
import java.rmi.server.*;

public class DistImpl extends UnicastRemoteObject implements DistIntf {
	protected DistImpl() throws RemoteException {
		super();
	}
	
	public double mtok(double miles) throws RemoteException {
		return miles * 1.60934;
	}
}

