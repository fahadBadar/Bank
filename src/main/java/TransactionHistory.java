import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TransactionHistory {
    ArrayList<Transaction> transactions = new ArrayList<>();

    public void addDeposit(int amount) {
        String date = formatDate();
        Transaction transaction = new Transaction(date, amount);
        transactions.add(transaction);
    }

    public void addWithdrawal(int amount) {
        String date = formatDate();
        Transaction transaction = new Transaction(date, -amount);
        transactions.add(transaction);
    }

    public String generateBankStatement() {
        String bankStatement = "Date||Amount||Balance\n";
        int balance = 0;
        for (Transaction transaction: transactions) {
            balance += transaction.getAmount();
            bankStatement += transaction.toString();
            bankStatement += balance + "\n";
        }
        return bankStatement;
    }

    public String formatDate() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(dateFormat);
    }
}
