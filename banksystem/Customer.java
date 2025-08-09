import java.util.ArrayList;
import java.util.List;

class Customer{
    private String id;
    private String name;
    private String accountNo;
    private int balance;
    List<String> transactionHistory = new ArrayList<>();
    int transactions = 0;
    
    // Customer Name : Naresh -> Account Transactions
    // S.No    Credit   Debit   Balance
    
    
    Customer(String id, String name, String accountNo, int balance){
        this.id = id;
        this.name = name;
        this.accountNo = accountNo;
        this.balance = balance;
        transactionHistory.add(String.format("%-6d %-15d %-15d %-15d", transactions, 0, balance, balance));

    }
    
    public String getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public String getAccountNo(){
        return accountNo;
    }
    
    public int getBalance(){
        return balance;
    }
    
    public int getTransactions(){
        return transactions;
    }
    
    public void setBalance(int newBalance){
        balance = newBalance;
    }

    
    public void setTransactionHistory(int creditAmount, int debitAmount) {
        transactions++;
        String transactionTemplate = String.format(
            "%-6d %-15d %-15d %-15d",
            transactions, creditAmount, debitAmount, balance
        );
        
        transactionHistory.add(transactionTemplate);
    }
}
