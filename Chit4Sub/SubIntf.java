import java.rmi.*;

public interface SubIntf extends Remote {
	int sub(int a, int b) throws RemoteException;
}


