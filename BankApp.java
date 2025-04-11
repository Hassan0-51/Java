import java.util.Scanner;

// Custom exception for insufficient funds
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// BankAccount class with accountNumber and balance attributes
class BankAccount {
    private String accountNumber;
    private double balance;

    // Constructor to initialize the account
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money which throws InsufficientFundsException if needed
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. Available balance: $" + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        }
    }
    
    // Getter for balance
    public double getBalance() {
        return balance;
    }
}

// Main class to test the bank account operations
public class BankApp {
    public static void main(String[] args) {
        // Create a BankAccount object with a sample account number and initial balance
        BankAccount account = new BankAccount("12345", 500.0);
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        
        try {
            // Attempt withdrawal
            account.withdraw(amount);
            System.out.println("Withdrawal successful. Remaining balance: $" + account.getBalance());
        } catch (InsufficientFundsException e) {
            // Catch and display the custom exception message
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Finally block always prints this message
            System.out.println("Transaction complete.");
        }
        
        scanner.close();
    }
}
