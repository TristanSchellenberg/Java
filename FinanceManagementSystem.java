import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FinanceManagementSystem {

    // Renamed 'accountData' for financial context.
    private Map<String, Double> accountDetails;

    // Constructor initializes accountDetails
    public FinanceManagementSystem() {
        accountDetails = new HashMap<>();
    }

    // Renamed 'addNewAccount' to 'createAccount' to make it more general for the financial system.
    public void createAccount(String accountID) {
        if (accountDetails.containsKey(accountID)) {
            System.out.println("Error: Account already exists.");
        } else {
            accountDetails.put(accountID, 0.0);
            System.out.println("Account created successfully for account ID: " + accountID);
        }
    }

    // Renamed 'makeDeposit' to 'depositFunds'
    public void depositFunds(String accountID, double depositAmount) {
        if (accountDetails.containsKey(accountID)) {
            double currentBalance = accountDetails.get(accountID);
            currentBalance += depositAmount;
            accountDetails.put(accountID, currentBalance);
            System.out.println("Deposit of $" + depositAmount + " successful. New balance: $" + currentBalance);
        } else {
            System.out.println("Error: Account ID does not exist.");
        }
    }

    // Renamed 'makeWithdrawal' to 'withdrawFunds'
    public void withdrawFunds(String accountID, double withdrawalAmount) {
        if (accountDetails.containsKey(accountID)) {
            double currentBalance = accountDetails.get(accountID);
            if (currentBalance >= withdrawalAmount) {
                currentBalance -= withdrawalAmount;
                accountDetails.put(accountID, currentBalance);
                System.out.println("Withdrawal of $" + withdrawalAmount + " successful. New balance: $" + currentBalance);
            } else {
                System.out.println("Error: Insufficient funds for withdrawal.");
            }
        } else {
            System.out.println("Error: Account ID does not exist.");
        }
    }

    // Renamed 'viewBalance' to 'checkAccountBalance'
    public void checkAccountBalance(String accountID) {
        if (accountDetails.containsKey(accountID)) {
            double currentBalance = accountDetails.get(accountID);
            System.out.println("The balance for account ID " + accountID + " is: $" + currentBalance);
        } else {
            System.out.println("Error: Account ID does not exist.");
        }
    }

    // Main method with updated structure and class name
    public static void main(String[] args) {
        FinanceManagementSystem financeSystem = new FinanceManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n*** Welcome to the Finance Management System ***");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Check Account Balance");
            System.out.println("5. Exit");
            System.out.print("Please select an option (1-5): ");
            int userChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (userChoice) {
                case 1:
                    System.out.print("Enter new account ID: ");
                    String newAccountID = scanner.nextLine();
                    financeSystem.createAccount(newAccountID);
                    break;

                case 2:
                    System.out.print("Enter account ID: ");
                    String depositAccountID = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    financeSystem.depositFunds(depositAccountID, depositAmount);
                    break;

                case 3:
                    System.out.print("Enter account ID: ");
                    String withdrawalAccountID = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawalAmount = scanner.nextDouble();
                    financeSystem.withdrawFunds(withdrawalAccountID, withdrawalAmount);
                    break;

                case 4:
                    System.out.print("Enter account ID: ");
                    String balanceAccountID = scanner.nextLine();
                    financeSystem.checkAccountBalance(balanceAccountID);
                    break;

                case 5:
                    System.out.println("Exiting the system... Thank you for using the Finance Management System!");
                    System.exit(0);

                default:
                    System.out.println("Invalid selection. Please choose an option between 1 and 5.");
            }
        }
    }
}
