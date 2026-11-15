
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author waleeja
 */
public class Lab8 {

    public static void main(String[] args) {
        ReportManager manager = new ReportManager(new PdfFormatter(), new EmailNotifier());
manager.generate(List.of("a", "b", "c"), true);
    }
}
