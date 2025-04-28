import java.rmi.*;

public interface MulIntf extends Remote {
	int mul(int a, int b) throws RemoteException;
}


