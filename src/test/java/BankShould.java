import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BankShould {
    private Account account;
    private Printer mockPrinter;
    private DateFactory dateFactory;
    private TransactionHistory transactionHistory = new TransactionHistory();

    @BeforeEach
    public void setUpStreams() {
        mockPrinter = mock(Printer.class);
        account = new Account(mockPrinter);
        dateFactory = mock(DateFactory.class);
        transactionHistory.setDateFactory(dateFactory);
        account.setTransactionHistory(transactionHistory);
    }

    @Test
    public void AccountDesiredBehaviour(){
    when(dateFactory.getDate()).thenReturn("10/01/2012","13/01/2012","14/01/2012");

        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        account.printStatement();

        verify(mockPrinter).printBankStatement("Date||Amount||Balance\n" +
                "14/01/2012||-500||2500\n" +
                "13/01/2012||2000||3000\n" +
                "10/01/2012||1000||1000");

    }
}
