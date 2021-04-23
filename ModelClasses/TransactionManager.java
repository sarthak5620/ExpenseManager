package ModelClasses;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TransactionManager {
    public static HashMap<String, ArrayList<Transaction>> transactions;
    public static ArrayList<Transaction> transaction;
    public static void addTransaction(){
        transactions = new HashMap<>();
        transaction = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Select Transaction Type:
                0: INCOME
                1: EXPENSE""");

        System.out.print("Enter your choice: ");
        int type = sc.nextInt();
        if (type==TransactionType.TYPE_INCOME) System.out.println("Income Saved Successfully!");
        else if (type==TransactionType.TYPE_EXPENSE)System.out.println("Transaction saved as Expenditure successfully!");
        System.out.println("Enter amount of transaction:");
        float amount = sc.nextFloat();

        System.out.print("Enter Date (yyyy-mm-dd): ");
        String date = sc.next();

        System.out.print("Enter info: ");
        String info = sc.next();
        //Object created of class transaction
        Transaction transaction1 = new Transaction(amount,type,info,date);
        transaction.add(transaction1);
        LocalDate localDate = LocalDate.parse(transaction1.date, DateTimeFormatter.ISO_DATE);
        String key = localDate.getMonth().toString() + " " + localDate.getYear();
        System.out.println(key);
        //check whether month contains a transaction
        if (transactions.containsKey(key))
            transactions.get(key).add(transaction1);
        else {
            //initialise an arraylist to contain transactions
            ArrayList<Transaction> array = new ArrayList<>();
            array.add(transaction1);
            transactions.put(key, array);
        }
        System.out.println("Transaction added successfully!");
    }

    public static void deleteTransaction(){
        //initialise a hashmap and arraylist
        transactions = new HashMap<>();
        transaction = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the month and year you want to delete the transaction:(as JUNE 2000)");
        //key to access hashmap
        String key = sc.next();
        //check whether month and year are correct and contains the transaction.
        if (!transactions.containsKey(key))
            System.out.println("Error! Invalid Transaction.Please check the details you entered.");
        else {
            ArrayList<Transaction> allTransactions;
            allTransactions= transactions.get(key);
            //print and get all transactions of month
            for (int i = 0; i < allTransactions.size(); i++)
                System.out.println((i + 1) + ". " + allTransactions.get(i));
            System.out.print("Choose from above transactions : ");
            int choice = sc.nextInt();
            Transaction transaction1 = allTransactions.get(choice - 1);
            //remove transaction from arraylist
            allTransactions.remove(transaction1);
            System.out.println("Transaction deleted successfully!");
        }
    }
    public static void editTransaction(){
        transactions = new HashMap<>();
        transaction = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the month and year you want to edit transaction:(as JUNE 2000)");
        String key = sc.nextLine();
        //get user input otherwise wont continue
        while(key.isEmpty()) key = sc.nextLine();
        ArrayList<Transaction> allTransactions;
        allTransactions= transactions.get(key);

        //print and get all transactions of month
        for (Transaction allTransaction : allTransactions) {
            System.out.println(allTransaction);
        }
        System.out.print("Choose from above transactions : ");
        int choice = sc.nextInt();
        Transaction transaction1 = allTransactions.get(choice-1);
        System.out.println("Enter new amount of transaction:");
        transaction1.amount = sc.nextFloat();

        System.out.print("Enter new Date (yyyy-mm-dd): ");
        transaction1.date = sc.next();

        System.out.print("Enter new info: ");
        transaction1.info = sc.next();
    }
    public static void detailOfTransactionByMonth(){
        transactions = new HashMap<>();
        transaction = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the month and year you want to see details of transaction:(as JUNE 2000)");
        String key = sc.nextLine();
        if (!transactions.containsKey(key)){
            System.out.println("No transactions in given month! Please try again with different details.");
        }
        ArrayList<Transaction> allTransactions = transactions.get(key);
        for (int i=0;i< allTransactions.size();i++) System.out.println((i + 1) + ". " + allTransactions.get(i));
    }
    public static void summary(){
        transactions = new HashMap<>();
        transaction = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the month and year you want to see details of transaction:(as JUNE 2000)");
        String key = sc.next();
        //calculate income and overall savings
        float expends=0;
        float earning =0;
        ArrayList<Transaction> allTransactions = transactions.get(key);
        for (Transaction allTransaction : allTransactions) {
            if (allTransaction.transactionType == TransactionType.TYPE_INCOME) earning += allTransaction.amount;
            else expends += allTransaction.amount;
        }
        System.out.println("Earned: " + earning + "\nExpends: " + expends + "\nOverall savings: " + (earning - expends) );
    }
}
