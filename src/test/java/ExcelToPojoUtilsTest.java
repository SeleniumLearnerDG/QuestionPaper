import com.bean.Pojo;
import com.bean.QuestionPaper;
import com.controller.PdfController;
import com.itextpdf.text.DocumentException;
import com.util.ExcelUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ExcelToPojoUtilsTest {
    @Test
    public void testToPojo() throws IOException, DocumentException {
        InputStream is = new FileInputStream(new File("/Users/dikshagupta/Desktop/Excel1.xlsx"));
        List<QuestionPaper> questionPaperList = ExcelUtil.toPojo(QuestionPaper.class, is);
        new PdfController().createPdfFile("/Users/dikshagupta/Desktop", "Set2.pdf",questionPaperList, "Question paper set 2");
    }
}
