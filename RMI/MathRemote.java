import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MathRemote extends Remote {
    double calculate(String operation, double[] numbers) throws RemoteException;
}
