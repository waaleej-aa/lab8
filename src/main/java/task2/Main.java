package task2;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // Valid transfer, works fine
        BankTransfer ok = new BankTransfer("ACC-1", "ACC-2", new BigDecimal("100.00"));
        System.out.println("Created: " + ok);

        // Run ONE of these at a time, so the exception is uncaught and
        // Java prints the full stack trace for your screenshot:

        new BankTransfer("ACC-1", "ACC-2", new BigDecimal("-50"));   // negative amount
        // new BankTransfer(null, "ACC-2", new BigDecimal("50"));    // null account
        // new BankTransfer("ACC-1", "ACC-2", BigDecimal.ZERO);      // zero amount
    }
}