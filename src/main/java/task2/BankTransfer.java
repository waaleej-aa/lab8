package task2;


import java.math.BigDecimal;
import java.util.Objects;

public record BankTransfer(String fromAccount, String toAccount, BigDecimal amount) {

    public BankTransfer {  // compact constructor: runs before fields are assigned
        Objects.requireNonNull(fromAccount, "fromAccount must not be null");
        Objects.requireNonNull(toAccount, "toAccount must not be null");
        Objects.requireNonNull(amount, "amount must not be null");

        if (amount.signum() <= 0) {
            throw new IllegalArgumentException(
                "amount must be strictly positive, got: " + amount);
        }
    }
}