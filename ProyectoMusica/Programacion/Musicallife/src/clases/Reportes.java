package clases;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Class Reportes
 * Para la manipulacion del from Reportes
 * 
 * @author Liz Jimenez & Antonio Alonso
 */
public class Reportes {
	//Variables de clase 
	String tipo, busqueda ;
	String nombrea;
	
	
	//Reporte de los albunes de un artista  
	
	public void albumartista(){    
        try{
        	System.out.println("Entro");
        Document documento=new Document(PageSize.LETTER);//Crea un objeto
            PdfWriter.getInstance(documento, new FileOutputStream("ConsultaArtista.pdf"));
            //Crea el Pdf
            documento.open();
           
           
            Image imgTres=Image.getInstance("Encabezado.jpg");
            imgTres.scalePercent(50);
           // imgTres.setAbsolutePosition(100, 2);//Posición
            documento.add(          imgTres);//Agrega otra imagen
              documento.add(new Paragraph("Hola Cliente !!!"));//Almaceno informacion
              documento.add(new Paragraph());//Almaceno informacion
              documento.add(new Paragraph("Nos depedimos deseandote un buen dia."));//Almaceno informacion
            documento.close();
        }catch(Exception e){
            e.printStackTrace();
        }//Catch
    }//Main
	
	/*public static void main(String[] args) {
		Reportes obj= new Reportes();
		obj.albumartista();
	}*/
}
