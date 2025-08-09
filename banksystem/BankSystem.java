import java.util.Scanner;

class BankSystem{
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        Bank bank = new Bank();
        boolean isRunning = true;
        
        while(isRunning){
            System.out.println("1. Create Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Delete Account");
            System.out.println("4. View Account Details");
            System.out.println("5. View Account Transactions");
            System.out.println("6. Credit Money");
            System.out.println("7. Debit Money");
            System.out.println("8. Exit \n");
            
            System.out.print("Enter you Choice ");
            int userChoice = scan.nextInt();
            scan.nextLine();
            switch (userChoice){
                case 1 -> {
                    System.out.print("Enter your name : ");
                    String name = scan.nextLine();
                    System.out.print("Enter Initial amount to deposit : ");
                    int initialBalance = scan.nextInt();
                    System.out.println();
                    bank.addCustomer(name, initialBalance);
                }
                case 2 -> {
                    System.out.println("\nAccount Holders ...");
                    bank.viewAccounts();
                    System.out.println();
                }
                case 3 -> {
                    System.out.print("Enter your ID: ");
                    String accountId = scan.nextLine();
                    bank.deleteAccount(accountId);
                    System.out.println("Your Account was deleted succesfully...\n");
                }
                case 4 -> {
                    System.out.print("Enter your ID: ");
                    String accountId = scan.nextLine();
                    bank.viewAccountDetails(accountId);
                }
                case 5 -> {
                    System.out.print("Enter your ID: ");
                    String accountId = scan.nextLine();
                    bank.viewTransactionHistory(accountId);
                }
                case 6 -> {
                    System.out.print("Enter your Id: ");
                    String accountId = scan.nextLine();
                    System.out.print("Enter Amount to Credit : ");
                    int creditAmount = scan.nextInt();
                    bank.creditAmount(accountId, creditAmount);
                }
                case 7 -> {
                    System.out.print("Enter your Id: ");
                    String accountId = scan.nextLine();
                    System.out.print("Enter Amount to Withdraw : ");
                    int creditAmount = scan.nextInt();
                    bank.debitAmount(accountId, creditAmount);
                }
                case 8 -> {
                    System.out.println("Exiting ...");
                    isRunning = false;
                }
            } 
        }
    }
}