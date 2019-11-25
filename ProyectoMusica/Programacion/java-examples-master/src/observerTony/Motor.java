package observerTony;

import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Motor implements Observador{
	
	public Motor() {
		
	}
	
	
	public void update(int tam) {
		//Inicio creacion PDF
		try {
			//System.out.println("Entro");
			Document documento = new Document(PageSize.LETTER);// Crea un objeto
			PdfWriter.getInstance(documento,
					new FileOutputStream("src\\observerTony\\script.pdf"));
			// Crea el Pdf
			documento.open();
			for(int i=0; i<=tam; i++) {
				documento.add(new Paragraph("Texto"));// Almaceno informacion
			}
			
			documento.close();
			System.out.println(tam);
		} catch (Exception e) {
			e.printStackTrace();
		} // Catch
	}

}
