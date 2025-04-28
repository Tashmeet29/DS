import java.rmi.*;
import java.rmi.server.*;

public class TempImpl extends UnicastRemoteObject implements TempIntf {
	protected TempImpl() throws RemoteException {
		super();
	}
	
	public double ctof(double celcius) throws RemoteException {
		return (celcius * 9/5) + 32;
	}
}

