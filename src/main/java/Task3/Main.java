package Task3;


public class Main {
    public static void main(String[] args) {
        PaymentProcessor p = new PaymentProcessor();
        p.charge("TX-1001", 250.0);   // success path
        p.charge("TX-1002", -5.0);    // failure path, "Context Cleared" still prints
    }
}