import java.util.ArrayList;

public class TransactionHistory {
    ArrayList<Transaction> transactions = new ArrayList<>();
    DateFactory dateFactory = new DateFactory();

    public void addTransaction(int amount) {
        transactions.add(new Transaction(dateFactory, amount));
    }

    public String generateBankStatement() {
        return new BankStatement(transactions).getBankStatement();
    }

    public void setDateFactory(DateFactory dateFactory) {
        this.dateFactory = dateFactory;
    }
}
