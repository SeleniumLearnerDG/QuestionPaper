package com.controller;

import com.bean.QuestionPaper;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PdfController1 {

    final static String hindiFont="src/test/resources/krishna-font/KrishnaWide-m7WP.ttf";
    public Document createPdfFile(String fileLocation, String fileName, String title) throws IOException, DocumentException {
        FileOutputStream fos = new FileOutputStream(fileLocation+ File.separator+ fileName,false);
        Document doc = new Document();
        PdfWriter writer = PdfWriter.getInstance(doc, fos);

        doc.open();
        addTitle(doc,title);
//        int count=1;
//        for(QuestionPaper questionPaper: questionPaperList)
//        {
//            addEmptyLine(doc,1);
//            createQuestion(doc,questionPaper.getQuestion(),count);
//            addOption(doc,questionPaper.getOptions1(),1);
//            addOption(doc,questionPaper.getOptions2(),2);
//            if(questionPaper.getOptions3()!=null)
//            addOption(doc,questionPaper.getOptions3(),3);
//            if(questionPaper.getOptions3()!=null)
//            addOption(doc,questionPaper.getOptions3(),4);
//            count++;
//        }
        doc.close();
        fos.close();
        return doc;

    }
    public static void main(String[] args) throws IOException, DocumentException {
//            List<QuestionPaper> questionPaperList= new ArrayList<>();
//            QuestionPaper q1= new QuestionPaper("What is ","PM","RG");
//           for(int i=0;i<20;i++)
//            questionPaperList.add(q1);

        new PdfController1().createPdfFile("/Users/dikshagupta/Desktop", "Set1.pdf", "ये हिंदी टेक्स्ट जावा आउटपुट करेगा अगर आउटपुट में एरर आता है तो हम ठीक करेंगे ");

    }

    public  void addTitle(Document doc,String title) throws DocumentException, IOException {
        Phrase ph = createBoldFontForTitle().process(title);
        Paragraph titleParagraph = new Paragraph(ph);
        titleParagraph.setAlignment(Element.ALIGN_CENTER);
        doc.add(titleParagraph);
    }

    public FontSelector createBoldFontForTitle() throws DocumentException, IOException {
      //  String FONT = "C:/dev/dejavu-fonts-ttf-2.33/ttf/DejaVuSans.ttf";
        FontSelector selector = new FontSelector();
        BaseFont base = BaseFont.createFont(hindiFont, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        selector.addFont(FontFactory.getFont(FontFactory.HELVETICA, 12));
        selector.addFont(new Font(base, 12));


        return selector;
    }

    public FontSelector createFontForQuestion()
    {
        FontSelector selector = new FontSelector();
        Font f1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16,Font.BOLD);
        f1.setColor(BaseColor.BLUE);
        selector.addFont(f1);
        return selector;
    }

    public FontSelector createFontForOption()
    {
        FontSelector selector = new FontSelector();
        Font f1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 9,Font.NORMAL);
        f1.setColor(BaseColor.BLACK);
        selector.addFont(f1);
        return selector;
    }


    public  void createQuestion(Document doc,String question, int count) throws DocumentException {
        Phrase ph = createFontForQuestion().process("Question "+count+". "+question+"?");
        Paragraph questionPh = new Paragraph(ph);
        doc.add(questionPh);
    }

    public void addEmptyLine(Document doc, int count) throws DocumentException {
        for (int i=0;i<count;i++)
        doc.add(new Paragraph("            "));
    }

    public void addOption(Document doc,String option, int count) throws DocumentException {
        String oprionCount="";
        switch (count) {
            case 1:
                oprionCount = "a).";
                break;
            case 2:
                oprionCount = "b).";
                break;
            case 3:
                oprionCount = "c).";
                break;
            case 4:
                oprionCount = "d).";
                break;
        }
        Phrase ph = createFontForOption().process("Option "+oprionCount+" "+option);
        Paragraph optionPh = new Paragraph(ph);
        doc.add(optionPh);
    }
}
