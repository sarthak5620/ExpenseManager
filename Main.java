import java.util.Scanner;

import static ModelClasses.TransactionManager.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //All types of options you need to give in application:
        System.out.println("\nYou have the following options - ");
        System.out.println("\n1. Press 0 if you want to add a transaction to the list.");
        System.out.println("2. Press 1 to edit any existing transaction in the list.");
        System.out.println("3. Press 2 to delete a transaction.");
        System.out.println("4. Press 3 to get details of expends in the month.");
        System.out.println("5. Press 4 to show transactions by month.");
        System.out.println("5. Press 5 to show exit from the application.");
        System.out.println("Choose option:");
        int choice = sc.nextInt();
        while (choice!=5){
            switch (choice) {
                case 0 -> addTransaction();
                case 1 -> editTransaction();
                case 2 -> deleteTransaction();
                case 3 -> summary();
                case 4 -> detailOfTransactionByMonth();
                default -> System.out.println("Enter valid choice");
            }
            System.out.println("Enter you choice - ");
            choice = sc.nextInt();
        }
        System.out.println("Thanks for using the application.");
    }
}
