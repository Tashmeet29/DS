import java.rmi.*;

public interface DivIntf extends Remote {
	double div(double a, double b) throws RemoteException;
}


