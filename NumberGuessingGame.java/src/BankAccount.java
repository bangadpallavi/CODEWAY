import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true; // Withdrawal successful
        } else {
            return false; // Insufficient balance
        }
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                // Withdraw
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                if (userAccount.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
                } else {
                    System.out.println("Insufficient balance. Withdrawal failed.");
                }
                break;

            case 2:
                // Deposit
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                userAccount.deposit(depositAmount);
                System.out.println("Deposit successful. Updated balance: " + userAccount.getBalance());
                break;

            case 3:
                // Check Balance
                System.out.println("Current balance: " + userAccount.getBalance());
                break;

            case 4:
                // Exit
                System.out.println("Exiting. Thank you!");
                System.exit(0);

            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            atm.performTransaction(choice, scanner);
        }
    }
}

