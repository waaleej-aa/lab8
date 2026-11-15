// PdfFormatter.java
public class PdfFormatter implements ReportFormatter {
    @Override
    public String format(String data) {
        return "Writing PDF: " + data;
    }
}