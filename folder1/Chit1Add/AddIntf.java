import java.rmi.*;

public interface AddIntf extends Remote {
	int add(int a, int b) throws RemoteException;
}


