public class Account implements AccountService{

        TransactionHistory transactionHistory = new TransactionHistory();
        private Printer printer;

        public Account(Printer printer) {
                this.printer = printer;
        }

        public void deposit(int amount) {
                transactionHistory.addDeposit(amount);
        }
        public void withdraw(int amount) {
                transactionHistory.addWithdrawal(amount);
        }
        public void printStatement() {
                String bankStatement = transactionHistory.generateBankStatement();
                printer.printBankStatement(bankStatement.replaceAll("^\\S\\r\\n", ""));
//                printer.printBankStatement("Date       || Amount || Balance\n" +
//                        "14/01/2012 || -500   || 2500\n" +
//                        "13/01/2012 || 2000   || 3000\n" +
//                        "10/01/2012 || 1000   || 1000");
        }
}
