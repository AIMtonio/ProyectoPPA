package clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import interfaces.*;

public class ObservadorBase implements Observador{
	
	public ObservadorBase() {
		
	}
	
	public void update(int tam, String accion, String fecha) {
		BufferedWriter bw=null;
		FileWriter fw = null;
				try {
				
				File file = new File("src\\pdfs\\Script.txt");
				if(!file.exists()) {
					file.createNewFile();
				}
				fw = new FileWriter(file.getAbsoluteFile(), true);
				bw = new BufferedWriter(fw);
				for(int i = 1; i<=tam; i++) {
					bw.write("Registro: " + i + "\n");
					bw.write("Accion: " + accion + "\n");
					bw.write("Fecha: " + fecha + "\n");
					bw.write("" + "\n");	
				}
				}catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally {
					try {
						if(bw != null) 
							bw.close();
						if(fw !=null)
							fw.close();
					} catch (IOException ex) {
						// TODO: handle exception
						ex.printStackTrace();
					}
				}
					
					
	}
	
	
	

}
