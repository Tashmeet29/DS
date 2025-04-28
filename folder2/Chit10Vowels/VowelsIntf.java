import java.rmi.*;

public interface VowelsIntf extends Remote {
	int countVowels(String word) throws RemoteException;
}


