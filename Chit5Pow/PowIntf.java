import java.rmi.*;

public interface PowIntf extends Remote {
	double calculatePower(int exponent) throws RemoteException;
}

