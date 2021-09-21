public class Account implements AccountService{

        TransactionHistory transactionHistory = new TransactionHistory();
        private Printer printer;

        public Account(Printer printer) {
                this.printer = printer;
        }

        public void deposit(int amount) {
                transactionHistory.addTransaction(amount);
        }

        public void withdraw(int amount) {
                transactionHistory.addTransaction(-amount);
        }

        public void printStatement() {
                String bankStatement = transactionHistory.generateBankStatement();
                printer.printBankStatement(bankStatement.replaceAll("^\\S\\r\\n", ""));
        }

        public void setTransactionHistory(TransactionHistory transactionHistory) {
                this.transactionHistory = transactionHistory;
        }
}
