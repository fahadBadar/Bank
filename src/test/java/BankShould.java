import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BankShould {
    private Account account;
    private Printer mockPrinter;

    @BeforeEach
    public void setUpStreams() {
        mockPrinter = mock(Printer.class);
        account = new Account(mockPrinter);
    }

    @Test
    public void AccountDesiredBehaviour(){

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
