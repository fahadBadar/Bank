public class Transaction {
    private String date;
    private int amount;

    public Transaction(DateFactory dateFactory,int amount) {
        this.date = dateFactory.getDate();
        this.amount = amount;
    }

    public String toString() {
        return date + "||" + amount + "||";
    }

    public int getAmount() {
        return this.amount;
    }
}
