// EmailNotifier.java
public class EmailNotifier implements Notifier {
    @Override
    public void notify(String recipient, String message) {
        EmailClient.sendStatic(recipient, message);
    }
}