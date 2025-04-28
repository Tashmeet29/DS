import java.rmi.*;
import java.rmi.server.*;

public class SubImpl extends UnicastRemoteObject implements SubIntf {
	protected SubImpl() throws RemoteException {
		super();
	}
	
	public int sub(int a, int b) throws RemoteException {
		return a - b;
	}
}

