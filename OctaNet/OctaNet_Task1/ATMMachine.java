package OctaNet_Task1;

import java.util.ArrayList;
import java.util.Scanner;


@SuppressWarnings("all")
class InfoATM {

    private int pin = 1234;
    private final int accountNo = 1234567890;
    private int balance = 100;
    private final ArrayList<String> transactionHistory = new ArrayList<>();

    // Login method
    public boolean login(int userAccountNo, int userPin) {
        if (accountNo == userAccountNo) {
            System.out.println("Hello Mr. Manish Giri");

            if (pin == userPin) {
                System.out.println("Login successfully.");
                return true;
            } else {
                System.out.println("Invalid PIN.");
                return false;
            }
        } else {
            System.out.println("Invalid Account Number.");
            return false;
        }
    }

    // Change PIN section
    public void changePIN() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your old PIN: ");
        int oldPIN = scanner.nextInt();

        if (oldPIN != pin) {
            System.out.println("Incorrect old PIN.");
            return;
        }

        System.out.println("Enter your new PIN: ");
        int newPIN = scanner.nextInt();
        System.out.println("Confirm your new PIN: ");
        int confirmNewPIN = scanner.nextInt();

        if (newPIN == confirmNewPIN) {
            pin = newPIN;
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("PIN unchanged. The new PIN and confirmation PIN do not match.");
        }
    }

    // Withdraw section
    public void withdraw(int withdrawAmount) {
        if (withdrawAmount <= 0) {
            System.out.println("Invalid amount.");
        } else if (withdrawAmount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= withdrawAmount;
            System.out.println("\nWithdrawal successfully.");
            System.out.println("Your current balance is: Rs. " + balance);
            transactionHistory.add("Withdrawal of Rs. " + withdrawAmount);
        }
    }

    // Deposit section
    public void deposit(int depositAmount) {
        if (depositAmount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            balance += depositAmount;
            System.out.println("\nDeposit successfully.");
            System.out.println("Your current balance is: Rs. " + balance);
            transactionHistory.add("Deposit of Rs. " + depositAmount);
        }
    }

    // Check balance section
    public void checkBalance() {
        System.out.println("\nYour current balance is: Rs. " + balance);
    }

    // Show transaction history section
    public void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    // Menu panel
    public void menuPanel() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.err.println("\t\t------------------------------\n\t\t------------------------------");
            System.out.println("\n\t\t1. Deposit");
            System.out.println("\t\t2. Withdraw");
            System.out.println("\t\t3. Check Balance");
            System.out.println("\t\t4. Show Transaction History");
            System.out.println("\t\t5. Change PIN");
            System.out.println("\t\t6. Logout");
            System.err.println("\t\t------------------------------\n\t\t------------------------------");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    int depositAmount = sc.nextInt();
                    deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdraw amount: ");
                    int withdrawAmount = sc.nextInt();
                    withdraw(withdrawAmount);
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    showTransactionHistory();
                    break;

                case 5:
                    changePIN();
                    break;

                case 6:
                    System.out.println("Visit again..!!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

// Main class
@SuppressWarnings("all")
public class ATMMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InfoATM atm = new InfoATM();

        System.out.print("\nEnter your account number: ");
        int userAccountNo = scanner.nextInt();
        System.out.print("Enter your PIN: ");
        int userPin = scanner.nextInt();

        if (atm.login(userAccountNo, userPin)) {
            atm.menuPanel();
        } else {
            System.out.println("Incorrect login.");
        }
    }
}
