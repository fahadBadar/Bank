import java.util.ArrayList;
public class BankStatement {
    String bankStatement = "";

    public BankStatement(ArrayList<Transaction> transactions) {
        int balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
            bankStatement = transaction.toString() + balance + "\n" + bankStatement;
        }
        bankStatement = "Date||Amount||Balance\n" + bankStatement;
        this.bankStatement = bankStatement.substring(0, bankStatement.length() - 1);
    }

    public String getBankStatement() {
        return this.bankStatement;
    }
}