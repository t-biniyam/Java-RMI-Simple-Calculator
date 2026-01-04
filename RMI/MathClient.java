import java.rmi.Naming;
import java.util.Scanner;

public class MathClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            MathRemote math = (MathRemote) Naming.lookup("rmi://localhost/MATH-SERVER");

            System.out.println("=== Remote Calculator ===");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.print("Choose operation (1-4): ");
            int choice = sc.nextInt();

            String operation = "";
            switch (choice) {
                case 1 -> operation = "add";
                case 2 -> operation = "subtract";
                case 3 -> operation = "multiply";
                case 4 -> operation = "divide";
                default -> {
                    System.out.println("Invalid choice!");
                    System.exit(0);
                }
            }

            System.out.print("How many numbers? ");
            int count = sc.nextInt();

            double[] numbers = new double[count];
            for (int i = 0; i < count; i++) {
                System.out.print("Enter number " + (i + 1) + ": ");
                numbers[i] = sc.nextDouble();
            }

            double result = math.calculate(operation, numbers);
            System.out.println("Result: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
