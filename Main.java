import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        if (!name.isEmpty()) {
            User user = new User(name, 0);
            System.out.printf("Welcome %s, follow the instructions to bank with us%n", user.getName());

            boolean onContinue = true;

            while (onContinue) {
                System.out.println("\nAvailable options:");
                System.out.println("D - Deposit");
                System.out.println("W - Withdraw");
                System.out.println("B - Check Balance");
                System.out.print("Select an option: ");
                String response = scanner.nextLine().trim().toUpperCase();

                switch (response) {
                    case "D":
                        System.out.println(user.deposit(scanner));
                        break;

                    case "W":
                        System.out.println(user.withdraw(scanner));
                        break;

                    case "B":
                        System.out.println(user.getAccountBalance());
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }

                System.out.print("Do you wish to continue? Enter Yes or No: ");
                String continueResponse = scanner.nextLine().trim().toUpperCase();
                if (continueResponse.equals("NO")) {
                    onContinue = false;
                } else if (!continueResponse.equals("YES")) {
                    System.out.println("Invalid input. Assuming you wish to exit.");
                    onContinue = false;
                }
            }

            System.out.println(user.getName() + " Thank you for using our banking app. Goodbye!");
        } else {
            System.out.println("Name cannot be empty. Exiting.");
        }

        scanner.close();
    }
}
