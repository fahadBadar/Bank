import java.util.Date;

public class Transaction {
    private String date;
    private int amount;

    public Transaction(String date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public String toString() {
        return date + "||" + amount + "||";
    }

    public int getAmount() {
        return this.amount;
    }
}
