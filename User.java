import java.util.Scanner;

public class User {
    private String name;
    private int accountBalance;

    public User(String name, int accountBalance) {
        this.name = name;
        this.accountBalance = accountBalance;
    }

    public String getName() {
        return this.name;
    }

    public String getAccountBalance() {
        String balance = new CurrencyFormatter(this.accountBalance).formatCurrency();
        return this.name + " your account balance is: " + balance;
    }

    public String deposit(Scanner scanner) {
        System.out.print("Enter a deposit amount: ");
        String amount = scanner.nextLine();

        try {
            this.accountBalance += Integer.parseInt(amount);
            String formattedCurrency = new CurrencyFormatter(this.accountBalance).formatCurrency();
            return "Deposit successful. Your new balance is: " + formattedCurrency;

        } catch (NumberFormatException e) {
            return "Please enter a valid amount.";
        }
    }

    public String withdraw(Scanner scanner) {
        System.out.print("Enter withdrawal amount: ");

        try {
            int amount = Integer.parseInt(scanner.nextLine());

            if (amount <= 0) {
                return amount + " cannot be accepted as a withdrawal amount.";
            }

            if (amount > this.accountBalance) {
                return this.name + ", your balance is insufficient to perform the withdrawal.";
            }

            this.accountBalance -= amount;
            String formattedCurrency = new CurrencyFormatter(this.accountBalance).formatCurrency();
            return "Withdrawal successful. Your new balance is: " + formattedCurrency;

        } catch (NumberFormatException e) {
            return "Please enter a valid amount.";
        }
    }
}
