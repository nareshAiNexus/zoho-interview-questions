import java.util.List;
import java.util.ArrayList;

public class Bank{
    
    public static List<Customer> customerList = new ArrayList<>();
    public static int customerCount = 0;
    
    public static void addCustomer(String name, int initialAmount){
        Customer newCustomer = new Customer(("c00" + customerCount), name, ("67890" + customerCount++), initialAmount);
        customerList.add(newCustomer);
    }
    
    public static void deleteAccount(String accountId) {
        customerList.removeIf(c -> c.getId().equals(accountId));
}

    
    public static void viewAccounts(){
        for(Customer c: customerList){
            System.out.printf("CustID : %-10s Name : %-10s Balance : %-10s\n", c.getId(), c.getName(), c.getBalance());
        }
    }
    
    public static Customer getCustomerObject(String accountId){
        for (Customer customer : customerList)
            if (customer.getId().equals(accountId))
                return customer;
        return null; 
    }
    
    public static void viewAccountDetails(String accountId) {
        Customer c = getCustomerObject(accountId);

        if (c != null) {
            System.out.println("Id : " + c.getId());
            System.out.println("Name : " + c.getName());
            System.out.println("Account No : " + c.getAccountNo());
            System.out.println("Account Balance : " + c.getBalance());
        } else {
            System.out.println("Account not found!");
        }
        System.out.println();
    }

    
    public static void viewTransactionHistory(String accountId){
        Customer c = getCustomerObject(accountId);
        
        System.out.println(c.getName() + "  " + c.getId() + "  " + c.getAccountNo() + "\n");

        // Table header
        System.out.printf("%-6s %-15s %-15s %-15s%n", "S.No", "Credit Amount", "Debit Amount", "Balance");
        System.out.println("----------------------------------------------");

        // Printing each transaction
        for (String s : c.transactionHistory) {
            System.out.println(s);
        }
        System.out.println();
    }
    
    public static void creditAmount(String accountId, int creditAmount){
        Customer c = getCustomerObject(accountId);
        int accountBalance = c.getBalance();
        if(accountBalance < creditAmount){
            System.out.print("Insufficient Balance...");
            return;
        }
        c.setBalance(accountBalance - creditAmount);
        c.setTransactionHistory(creditAmount, 0);
        // System.out.println("Account balance : " + c.getBalance());
    }
    
    public static void debitAmount(String accountId, int debitAmount){
        Customer c = getCustomerObject(accountId);
        int accountBalance = c.getBalance();
        c.setBalance(accountBalance + debitAmount);
        c.setTransactionHistory(0, debitAmount);
        // System.out.println("Account balance : " + c.getBalance());
    }
    
    public static void checkBalance(Customer c){
        System.out.println(c.getBalance());
    }
    
    public static int getTotalTransactions(Customer c){
        return c.getTransactions();
    }
    
}

