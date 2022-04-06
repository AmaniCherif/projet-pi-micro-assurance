package tn.esprit.spring.service.Interface;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;
 
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import tn.esprit.spring.entity.Transaction;

 
 
public class PaymentPdf {
    private List<Transaction> listPayments;
     
    public PaymentPdf(List<Transaction> listPayments) {
        this.listPayments = listPayments;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(6);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Transaction Id", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Transaction type", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Transaction date", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Transaction Amount", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Contract Id", font));
        table.addCell(cell);
    }
     
    private void writeTableData(PdfPTable table) {
        for (Transaction payment : listPayments) {
            table.addCell(String.valueOf(payment.getTransactionid()));
            table.addCell((String.valueOf(payment.getTypeTransaction())));
            table.addCell((String.valueOf(payment.getTransactionDate())));
            table.addCell((String.valueOf(payment.getTransactionAmount())));
            table.addCell((String.valueOf(payment.getContract().getId())));

        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(20);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("List of Transaction", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {3.5f, 3.5f, 3.5f, 4.5f,2.5f});
        table.setSpacingBefore(5);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}