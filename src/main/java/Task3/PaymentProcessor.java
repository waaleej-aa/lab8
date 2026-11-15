package Task3;


public class PaymentProcessor {

    public void charge(String txId, double amount) {
        System.out.println("[TraceID: " + txId + "] Processing payment...");  // context set
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Invalid amount: " + amount);
            }
            System.out.println("[TraceID: " + txId + "] Charged " + amount);
        } finally {
            System.out.println("[TraceID: " + txId + "] Context Cleared");     // always runs
        }
    }
}