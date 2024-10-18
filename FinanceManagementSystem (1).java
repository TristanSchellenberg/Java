import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FinanceManagementSystem {

    // Map to store account details with account ID as the key and balance as the value
    private Map<String, Double> accountDetails;

    // Constructor initializes the accountDetails map
    public FinanceManagementSystem() {
        accountDetails = new HashMap<>();
    }

    // Creates a new account with an initial balance of 0
    public void createAccount(String accountID) {
        if (accountDetails.containsKey(accountID)) {
            System.out.println("Error: Account already exists.");
        } else {
            accountDetails.put(accountID, 0.0); // Set initial balance to 0.0
            System.out.println("Account created successfully for account ID: " + accountID);
        }
    }

    // Adds money to the specified account
    public void depositFunds(String accountID, double depositAmount) {
        if (accountDetails.containsKey(accountID)) {
            double currentBalance = accountDetails.get(accountID); // Get current balance
            currentBalance += depositAmount; // Add deposit amount to current balance
            accountDetails.put(accountID, currentBalance); // Update the balance
            System.out.println("Deposit of $" + depositAmount + " successful. New balance: $" + currentBalance);
        } else {
            System.out.println("Error: Account ID does not exist.");
        }
    }

    // Withdraws money from the specified account if there are sufficient funds
    public void withdrawFunds(String accountID, double withdrawalAmount) {
        if (accountDetails.containsKey(accountID)) {
            double currentBalance = accountDetails.get(accountID); // Get current balance
            if (currentBalance >= withdrawalAmount) {
                currentBalance -= withdrawalAmount; // Subtract the withdrawal amount from the balance
                accountDetails.put(accountID, currentBalance); // Update the balance
                System.out.println("Withdrawal of $" + withdrawalAmount + " successful. New balance: $" + currentBalance);
            } else {
                System.out.println("Error: Insufficient funds for withdrawal.");
            }
        } else {
            System.out.println("Error: Account ID does not exist.");
        }
    }

    // Displays the current balance for the specified account
    public void checkAccountBalance(String accountID) {
        if (accountDetails.containsKey(accountID)) {
            double currentBalance = accountDetails.get(accountID); // Get the balance
            System.out.println("The balance for account ID " + accountID + " is: $" + currentBalance);
        } else {
            System.out.println("Error: Account ID does not exist.");
        }
    }

    // Main method - entry point of the program
    public static void main(String[] args) {
        FinanceManagementSystem financeSystem = new FinanceManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu options
            System.out.println("\nWelcome to Tristan's Finance Management System");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Check Account Balance");
            System.out.println("5. Exit");
            System.out.print("Please select an option (1-5): ");
            int userChoice = scanner.nextInt(); // Get user's choice
            scanner.nextLine(); // Consume newline

            switch (userChoice) {
                case 1:
                    // Create a new account
                    System.out.print("Enter new account ID: ");
                    String newAccountID = scanner.nextLine();
                    financeSystem.createAccount(newAccountID);
                    break;

                case 2:
                    // Deposit money into an account
                    System.out.print("Enter account ID: ");
                    String depositAccountID = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    financeSystem.depositFunds(depositAccountID, depositAmount);
                    break;

                case 3:
                    // Withdraw money from an account
                    System.out.print("Enter account ID: ");
                    String withdrawalAccountID = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawalAmount = scanner.nextDouble();
                    financeSystem.withdrawFunds(withdrawalAccountID, withdrawalAmount);
                    break;

                case 4:
                    // Check account balance
                    System.out.print("Enter account ID: ");
                    String balanceAccountID = scanner.nextLine();
                    financeSystem.checkAccountBalance(balanceAccountID);
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Exiting the system... Thank you for using the Finance Management System!");
                    System.exit(0);

                default:
                    // Handle invalid menu options
                    System.out.println("Invalid selection. Please choose an option between 1 and 5.");
            }
        }
    }
}
