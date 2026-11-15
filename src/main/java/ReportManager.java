// ReportManager.java
import java.util.List;
import java.util.Objects;

public class ReportManager {
    private static final String ADMIN_EMAIL = "admin@company.com";

    private final ReportFormatter formatter;
    private final Notifier notifier;

    public ReportManager(ReportFormatter formatter, Notifier notifier) {
        this.formatter = Objects.requireNonNull(formatter, "formatter must not be null");
        this.notifier = Objects.requireNonNull(notifier, "notifier must not be null");
    }

    public void generate(List<String> data, boolean sendEmail) {
        String output = String.join(",", data);          // Smell 1

        System.out.println(formatter.format(output));    // Smells 2 & 3

        if (sendEmail) {
            notifier.notify(ADMIN_EMAIL, output);        // Smell 4
        }
    }
    // Usage

}