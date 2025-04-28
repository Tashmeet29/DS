import java.rmi.*;
import java.rmi.server.*;

public class MulImpl extends UnicastRemoteObject implements MulIntf {
	protected MulImpl() throws RemoteException {
		super();
	}
	
	public int mul(int a, int b) throws RemoteException {
		return a * b;
	}
}

