import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATMOperations {
    private static final Map<String, String> userPasswords = new HashMap<>();
    private static final Map<String, Double> userBalances = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        userPasswords.put("denis", "1234");
        userPasswords.put("güli", "5678");

        userBalances.put("denis", 1000.0);
        userBalances.put("güli", 50000.0);

        System.out.println(" Welcome to the ATM System");

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (userPasswords.containsKey(username) &&
                userPasswords.get(username).equals(password)) {

            System.out.println("✅ Login successful. Welcome, " + username + "!\n");
            double balance = userBalances.get(username);
            int choice;

            do {
                System.out.println("1. View Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("💰 Current Balance: " + balance + " TL\n");
                        break;
                    case 2:
                        System.out.print("Enter the amount you want to deposit: ");
                        double deposited = scanner.nextDouble();
                        if (deposited > 0) {
                            balance += deposited;
                            System.out.println(" Money deposited. New balance: " + balance + " TL\n");
                        } else {
                            System.out.println("⚠️ Invalid amount!\n");
                        }
                        break;
                    case 3:
                        System.out.print("Enter the amount you want to withdraw: ");
                        double withdrawn = scanner.nextDouble();
                        if (withdrawn > 0 && withdrawn <= balance) {
                            balance -= withdrawn;
                            System.out.println(" Money withdrawn. New balance: " + balance + " TL\n");
                        } else {
                            System.out.println("⚠️ Insufficient balance or invalid amount!\n");
                        }
                        break;
                    case 4:
                        System.out.println("Logging out. Have a nice day!\n");
                        break;
                    default:
                        System.out.println("⚠️ Invalid selection!\n");
                }
            } while (choice != 4);

            userBalances.put(username, balance);
        } else {
            System.out.println("Login failed! Invalid username or password.");
        }

        scanner.close();
    }
}
