import com.itextpdf.text.DocumentException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.GregorianCalendar;


@WebServlet("/pdf_document")
public class PdfDocumentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/pdf");
        CreatePdfDocument createPdfDocument = new CreatePdfDocument();
        try {
            createPdfDocument.createDocument(getValues(req), resp.getOutputStream());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private FormValues getValues(HttpServletRequest request) {
        String[] datesString = request.getParameter("date").split("-");
        int[] dates = new int[datesString.length];
        for (int i = 0; i < datesString.length; i++) {
            dates[i] = Integer.parseInt(datesString[i]);
        }
        FormValues values = new FormValues(request.getParameter("event"),
                new GregorianCalendar(dates[0], dates[1], dates[2]).getTime(),
                request.getParameter("company"),
                request.getParameter("name"),
                request.getParameter("surname"),
                request.getParameter("country"),
                request.getParameter("city"),
                request.getParameter("address"),
                request.getParameter("email"),
                request.getParameter("telephone_number1"),
                request.getParameter("telephone_number2"));
        return values;
    }
}
