import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;

public class MathProvider extends UnicastRemoteObject implements MathRemote {

    protected MathProvider() throws RemoteException {
        super();
    }

    @Override
    public double calculate(String operation, double[] numbers) throws RemoteException {
        double result = 0;

        switch (operation.toLowerCase()) {
            case "add":
                for (double n : numbers)
                    result += n;
                break;
            case "subtract":
                result = numbers[0];
                for (int i = 1; i < numbers.length; i++)
                    result -= numbers[i];
                break;
            case "multiply":
                result = 1;
                for (double n : numbers)
                    result *= n;
                break;
            case "divide":
                result = numbers[0];
                for (int i = 1; i < numbers.length; i++) {
                    if (numbers[i] == 0)
                        throw new ArithmeticException("Cannot divide by zero");
                    result /= numbers[i];
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation);
        }

        return result;
    }

    public static void main(String[] args) {
        try {
            // Start RMI registry in code
            LocateRegistry.createRegistry(1099);

            MathProvider provider = new MathProvider();
            Naming.rebind("MATH-SERVER", provider);
            System.out.println("Math Server running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
