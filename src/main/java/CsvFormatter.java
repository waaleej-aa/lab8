// CsvFormatter.java
public class CsvFormatter implements ReportFormatter {
    @Override
    public String format(String data) {
        return "Writing CSV: " + data;
    }
}