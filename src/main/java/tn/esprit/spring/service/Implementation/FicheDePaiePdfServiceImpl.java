package tn.esprit.spring.service.Implementation;
import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import tn.esprit.spring.entity.EmployeeSalary;
public class FicheDePaiePdfServiceImpl {
	
	private List<EmployeeSalary> listEmployeeSalaries;
	
	  public FicheDePaiePdfServiceImpl(List<EmployeeSalary> listEmployeeSalaries) {
		  
	        this.listEmployeeSalaries = listEmployeeSalaries;
	    }
	 
	    private void writeTableHeader(PdfPTable table) {
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.RED);
	        cell.setPadding(9);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	         
	        cell.setPhrase(new Phrase("Salary ID", font));
	        table.addCell(cell);
	        
	        cell.setPhrase(new Phrase("User CIN", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("First name", font));
	        table.addCell(cell);
	        
	        cell.setPhrase(new Phrase("Last name", font));
	        table.addCell(cell);
	        
	        cell.setPhrase(new Phrase("Year", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Month", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Work hours", font));
	        table.addCell(cell);
	        
	        cell.setPhrase(new Phrase("Extra hours", font));
	        table.addCell(cell);
	        
	        cell.setPhrase(new Phrase("Salary", font));
	        table.addCell(cell);
	        
	        
	    }
	     
	    private void writeTableData(PdfPTable table) {
	        for (EmployeeSalary employeeSalary : listEmployeeSalaries) {
	            table.addCell(String.valueOf(employeeSalary.getSalaryId()));
	            table.addCell((String.valueOf(employeeSalary.getUser().getCin())));
	            table.addCell((String.valueOf(employeeSalary.getUser().getFirstname())));
	            table.addCell((String.valueOf(employeeSalary.getUser().getLastname())));
	            table.addCell((String.valueOf(employeeSalary.getYear())));
	            table.addCell((String.valueOf(employeeSalary.getMonth())));
	            table.addCell((String.valueOf(employeeSalary.getWorkHours())));
	            table.addCell((String.valueOf(employeeSalary.getExtraHours())));
	            table.addCell((String.valueOf(employeeSalary.getSalary())));
	        }
	    }
	     
	    public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.RED);
	         
	        Paragraph p = new Paragraph("Fiche de paie", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(9);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {1.5f, 2f, 2f, 2f, 2f, 2f, 2f, 2f, 2f});
	        table.setSpacingBefore(10);
	         
	        writeTableHeader(table);
	        writeTableData(table);
	         
	        document.add(table);
	         
	        document.close();
	         
	    }
}

