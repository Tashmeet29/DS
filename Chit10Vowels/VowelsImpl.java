import java.rmi.*;
import java.rmi.server.*;

public class VowelsImpl extends UnicastRemoteObject implements VowelsIntf {
	protected VowelsImpl() throws RemoteException {
		super();
	}
	
	public int countVowels(String word) throws RemoteException {
		int count = 0;
		word = word.toLowerCase();
		for(char ch : word.toCharArray()) {
			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				count++;
			}
		}
		return count;
	}
}

