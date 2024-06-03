package ATMmachine;

import java.util.Scanner;

public class ATMmachine {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.checkpin();
    }
}


class ATM {
    float Balance = 0;
    int PIN = 5674;
    Scanner sc = new Scanner(System.in);

    public void checkpin() {
        System.out.println("Enter your pin:");
        int enteredpin = sc.nextInt();
        if (enteredpin == PIN) {
            menu();
        } else {
            System.out.println("Enter a valid pin");
            checkpin(); // Prompt again for pin
        }
    }

    public void menu() {
        while (true) {
            System.out.println("Enter Your Choice:");
            System.out.println("1. Check A/C Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");

            int opt = sc.nextInt();

            switch (opt) {
                case 1 -> checkBalance();
                case 2 -> withdrawMoney();
                case 3 -> depositMoney();
                case 4 -> {
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Enter a Valid Choice");
            }
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + Balance);
    }

    public void withdrawMoney() {
        System.out.println("Enter amount to Withdraw:");
        float amount = sc.nextFloat();
        if (amount > Balance) {
            System.out.println("Insufficient Balance");
        } else {
            Balance = Balance - amount;
            System.out.println("Money Withdrawal Successful");
        }
    }

    public void depositMoney() {
        System.out.println("Enter the Amount:");
        float amount = sc.nextFloat();
        Balance = Balance + amount;
        System.out.println("Money Deposited Successfully");
    }
}

