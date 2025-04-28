import java.rmi.*;
import java.rmi.server.*;

public class PowImpl extends UnicastRemoteObject implements PowIntf {
	protected PowImpl() throws RemoteException {
		super();
	}
	
	public double calculatePower(int exponent) throws RemoteException {
		return Math.pow(2, exponent);
	}
}

