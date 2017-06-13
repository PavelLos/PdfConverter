import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.ServletOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class CreatePdfDocument {

    public void createDocument(FormValues values, ServletOutputStream outputStream) throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);
        BaseFont bf = null;
        try {
            bf = BaseFont.createFont("c:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Font font = new Font(bf);
        document.open();
        document.add(createParagraphWithTab(font, "Название события: ", values.getEventName()));
        document.add(createParagraphWithTab(font, "Дата события: ", values.getDateOfEvent()));
        document.add(createParagraphWithTab(font, "Название компании: ", values.getCompanyName()));
        document.add(createParagraphWithTab(font, "Имя: ", values.getNameOfPerson()));
        document.add(createParagraphWithTab(font, "Фамилия: ", values.getSurnameOfPerson()));
        document.add(createParagraphWithTab(font, "Страна: ", values.getCountryName()));
        document.add(createParagraphWithTab(font, "Город: ", values.getCityName()));
        document.add(createParagraphWithTab(font, "Адрес: ", values.getAddress()));
        document.add(createParagraphWithTab(font, "Email: ", values.getEmail()));
        document.add(createParagraphWithTab(font, "Номер телефона: ", values.getTelephoneNumber1()));
        if (values.getTelephoneNumber2().length() != 0) {
            document.add(createParagraphWithTab(font, "Номер телефона: ", values.getTelephoneNumber2()));
        }
        document.close();
    }

    public static Paragraph createParagraphWithTab(Font font, String key, String value) {
        Paragraph p = new Paragraph();
        p.setTabSettings(new TabSettings(200f));
        p.setFont(font);
        p.add(key);
        p.add(value);
        p.add(Chunk.TABBING);
        return p;
    }


}
