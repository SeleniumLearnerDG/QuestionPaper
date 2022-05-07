import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.*;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileOutputStream;

public class demo {
    public static final String FONT = "src/test/resources/krishna-font/KrishnaCondensed-v03A.ttf";
    private static String RESULT = "MarathiPdf.pdf";

    public static void main(String[] args) throws  Exception{

        Document document = new Document();
        PdfWriter writer =
                PdfWriter.getInstance(document, new FileOutputStream(RESULT));
        document.open();

        Font font = FontFactory.getFont(FONT, BaseFont.IDENTITY_H,true);

        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        PdfPCell customerLblCell = new PdfPCell(new Phrase("जन्मतिथि ",
                font));

        table.addCell(customerLblCell);
        document.add(table);

        document.close();
    }
}
