package clases;

import java.io.FileOutputStream;
import java.security.Key;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import conexion.ConexionPostgresSingleton;

public class ReporteDos extends Thread {

	Connection conn = ConexionPostgresSingleton.getConnection();
	String nombrea;
	int a,b;
	Font fuente= new Font();
	Font fuente1= new Font();
	boolean security;
	
	public ReporteDos(String x, boolean sec) {
		this.nombrea = x;
		this.security = sec;
	}
	
	public void run() {
		
		if(security == true) {
			//PDF
			fuente.setSize(20);
			fuente1.setColor(0,255,0);
	        try{
	        Document documento=new Document(PageSize.LETTER);//Crea un objeto
	            PdfWriter.getInstance(documento, new FileOutputStream("src\\pdfs\\RetorteFecha.pdf"));
	            //Crea el Pdf
	            documento.open();
	           
	            Image imgTre=Image.getInstance("src\\img\\Nueva.png");
	            imgTre.scalePercent(68);
	            imgTre.setAbsolutePosition(32,680);//Posición
	            documento.add(          imgTre);//Agrega otra imagen
	            documento.add(new Paragraph(" "));//Almaceno informacion
	            documento.add(new Paragraph(" "));//Almaceno informacion
	            documento.add(new Paragraph(" "));//Almaceno informacion
	            documento.add(new Paragraph(" "));//Almaceno informacion
	              documento.add(new Paragraph("		            Consulta de los albums creados en la fecha : "+nombrea,fuente));//Almaceno informacion
	              documento.add(new Paragraph(" "));//Almaceno informacion
	              documento.add(new Paragraph(" "));//Almaceno informacion
	              documento.add(new Paragraph("A contunuacion se muestran los albums con su descripciòn de la fecha  "
	              		+ nombrea+", que previamente se ha seleccionado. "));//Almaceno informacion
	              documento.add(new Paragraph("       "));
	              documento.add(new Paragraph("       "));
	              PdfPTable tabla=new PdfPTable(6);//Crea tablas y por medio del construcctor le mando el numero de columnas que va tener mi tabla
	              PdfPCell celda=new PdfPCell(new Phrase("NO.",fuente1));//Crear celdas
	              celda.setHorizontalAlignment(Element.ALIGN_CENTER);//Centra el titulo o encabezados.
	              celda.setColspan(1);
	              tabla.addCell(celda);
	              
	              PdfPCell celda2=new PdfPCell(new Phrase("NOMBRE",fuente1));//Crear celdas
	              celda2.setHorizontalAlignment(Element.ALIGN_CENTER);//Centra el titulo o encabezados.
	              celda2.setColspan(1);
	              tabla.addCell(celda2);
	              
	              PdfPCell celda3=new PdfPCell(new Phrase("ARTISTA",fuente1));//Crear celdas
	              celda3.setHorizontalAlignment(Element.ALIGN_CENTER);//Centra el titulo o encabezados.
	              celda3.setColspan(1);
	              tabla.addCell(celda3);
	              
	              PdfPCell celda6=new PdfPCell(new Phrase("DISQUERA",fuente1));//Crear celdas
	              celda6.setHorizontalAlignment(Element.ALIGN_CENTER);//Centra el titulo o encabezados.
	              celda6.setColspan(1);
	              tabla.addCell(celda6);
	              
	              PdfPCell celda4=new PdfPCell(new Phrase("GÈNERO",fuente1));//Crear celdas
	              celda4.setHorizontalAlignment(Element.ALIGN_CENTER);//Centra el titulo o encabezados.
	              celda4.setColspan(1);
	              tabla.addCell(celda4);
	              
	              PdfPCell celda5=new PdfPCell(new Phrase("DURACIÒN",fuente1));//Crear celdas
	              celda5.setHorizontalAlignment(Element.ALIGN_CENTER);//Centra el titulo o encabezados.
	              celda5.setColspan(1);
	              tabla.addCell(celda5);
	              
	              //Conexion 
	              Statement st = conn.createStatement();
	  			String sql = "Select * from album where fecha_lanzamiento='"+nombrea+"'"  ;
	  			ResultSet rs = st.executeQuery(sql);
	  			int contador=1;
	              while(rs.next()) {
	            	  tabla.addCell("    "+contador);//Recibir una cadena de texto, deben completarse la cantidad de celdas como tantas cantidad de columnas, si no no se agrega
	                  tabla.addCell("    "+rs.getString(2));
	                  a= rs.getInt(3);
	                  tabla.addCell("    "+consultarArtista());
	  	  			  b= rs.getInt(4);
	  	  			  tabla.addCell("    "+consultarDisquera());
	                  tabla.addCell("    "+rs.getString(5));
	                  tabla.addCell("    "+rs.getString(6));
	                  contador++;
	              }
	              documento.add(tabla);//Agrego la tabla ya construida al documento
	              documento.add(new Paragraph("       "));
	              documento.add(new Paragraph("       "));
	              documento.add(new Paragraph("					Cualquier duda o aclaraciòn favor de marcar al numero "
	              		+ "5537015892 o bien 5510727166 y enseguida se le atenderà."));
	              Image imgTres=Image.getInstance("src\\img\\abajo.png");
	              imgTres.scalePercent(68);
	              imgTres.setAbsolutePosition(10,1);//Posición
	              documento.add(          imgTres);//Agrega otra imagen
	            documento.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }//End PDF
	        
	        
	        
		}else {
			
			//variables de seguridad
			String idAlbumEncriptado = null;
			String nombreAlbumEncriptado = null;
			String artistaAlbumEncriptado = null;
			String disqueraAlbumEncriptado = null;
			String generoAlbumEncriptado = null;
			String duracionAlbumEncriptado = null;
			byte[] encriptadoi; //idAlbum
		    byte[] encriptadon; //nombreAlbum
		    byte[] encriptadoa; //artistaAlbum
		    byte[] encriptadodi; //disqueraAlbum
		    byte[] encriptadog; //generoAlbum  
		    byte[] encriptadodu; //duracionAlbum  
			
			
			//PDF
			fuente.setSize(20);
			fuente1.setColor(0,255,0);
	        try{
	        Document documento=new Document(PageSize.LETTER);//Crea un objeto
	            PdfWriter.getInstance(documento, new FileOutputStream("src\\pdfs\\RetorteFecha.pdf"));
	            //Crea el Pdf
	            documento.open();
	           
	            Image imgTre=Image.getInstance("src\\img\\Nueva.png");
	            imgTre.scalePercent(68);
	            imgTre.setAbsolutePosition(32,680);//Posición
	            documento.add(          imgTre);//Agrega otra imagen
	            documento.add(new Paragraph(" "));//Almaceno informacion
	            documento.add(new Paragraph(" "));//Almaceno informacion
	              documento.add(new Paragraph("		            Autentificación Incorrecta."));//Almaceno informacion
	              documento.add(new Paragraph(" "));//Almaceno informacion
	              documento.add(new Paragraph(" "));//Almaceno informacion
	              documento.add(new Paragraph("A contunuacion se muestran los albums con su descripciòn de la fecha  "
	              		+ nombrea+", que previamente se ha seleccionado. "));//Almaceno informacion
	              documento.add(new Paragraph("       "));
	              documento.add(new Paragraph("       "));
	              PdfPTable tabla=new PdfPTable(6);//Crea tablas y por medio del construcctor le mando el numero de columnas que va tener mi tabla
	              PdfPCell celda=new PdfPCell(new Phrase("NO.",fuente1));//Crear celdas
	              celda.setHorizontalAlignment(Element.ALIGN_CENTER);//Centra el titulo o encabezados.
	              celda.setColspan(1);
	              tabla.addCell(celda);
	              
	              PdfPCell celda2=new PdfPCell(new Phrase("NOMBRE",fuente1));//Crear celdas
	              celda2.setHorizontalAlignment(Element.ALIGN_CENTER);//Centra el titulo o encabezados.
	              celda2.setColspan(1);
	              tabla.addCell(celda2);
	              
	              PdfPCell celda3=new PdfPCell(new Phrase("ARTISTA",fuente1));//Crear celdas
	              celda3.setHorizontalAlignment(Element.ALIGN_CENTER);//Centra el titulo o encabezados.
	              celda3.setColspan(1);
	              tabla.addCell(celda3);
	              
	              PdfPCell celda6=new PdfPCell(new Phrase("DISQUERA",fuente1));//Crear celdas
	              celda6.setHorizontalAlignment(Element.ALIGN_CENTER);//Centra el titulo o encabezados.
	              celda6.setColspan(1);
	              tabla.addCell(celda6);
	              
	              PdfPCell celda4=new PdfPCell(new Phrase("GÈNERO",fuente1));//Crear celdas
	              celda4.setHorizontalAlignment(Element.ALIGN_CENTER);//Centra el titulo o encabezados.
	              celda4.setColspan(1);
	              tabla.addCell(celda4);
	              
	              PdfPCell celda5=new PdfPCell(new Phrase("DURACIÒN",fuente1));//Crear celdas
	              celda5.setHorizontalAlignment(Element.ALIGN_CENTER);//Centra el titulo o encabezados.
	              celda5.setColspan(1);
	              tabla.addCell(celda5);
	              
	              //Conexion 
	              Statement st = conn.createStatement();
	  			String sql = "Select * from album where fecha_lanzamiento='"+nombrea+"'"  ;
	  			ResultSet rs = st.executeQuery(sql);
	  			int contador=1;
	              while(rs.next()) {
	            	  idAlbumEncriptado = rs.getString(1);
	                  nombreAlbumEncriptado = rs.getString(2);
	                  artistaAlbumEncriptado = rs.getString(3);
	                  disqueraAlbumEncriptado = rs.getString(4);
	                  generoAlbumEncriptado = rs.getString(5);
	                  duracionAlbumEncriptado = rs.getString(6);
	                  
	                  try {
					      KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
					      keyGenerator.init(128);
					      Key key = keyGenerator.generateKey();

					      key = new SecretKeySpec("una clave de 16 bytes".getBytes(),  0, 16, "AES");   
					   
					      Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
					      
					      aes.init(Cipher.ENCRYPT_MODE, key);
					      //byte[] encriptado = aes.doFinal(texto.getBytes());
					      
					      encriptadoi = aes.doFinal(idAlbumEncriptado.getBytes());
					      encriptadon = aes.doFinal(nombreAlbumEncriptado.getBytes());
					      encriptadoa = aes.doFinal(artistaAlbumEncriptado.getBytes());
					      encriptadodi = aes.doFinal(disqueraAlbumEncriptado.getBytes());
					      encriptadog = aes.doFinal(generoAlbumEncriptado.getBytes());
					      encriptadodu = aes.doFinal(duracionAlbumEncriptado.getBytes());

					      //fin seguridad
					
					tabla.addCell("    " + encriptadoi);
					tabla.addCell("    " + encriptadon);
					tabla.addCell("    " + encriptadoa);
					tabla.addCell("    " + encriptadodi);
					tabla.addCell("    " + encriptadog);
					tabla.addCell("    " + encriptadodu);
					contador++;
					} catch (Exception e) {
						e.printStackTrace();
					} // Catch
					contador ++ ;
				}
	              
	              documento.add(tabla);//Agrego la tabla ya construida al documento
	              documento.add(new Paragraph("       "));
	              documento.add(new Paragraph("  Contraseña de disquera incorrecta no puedes visualizar reportes oficiales sin porporcionar la contraseña correcta           "));
	              documento.add(new Paragraph("       "));
	              documento.add(new Paragraph("					Cualquier duda o aclaraciòn favor de marcar al numero "
	              		+ "5537015892 o bien 5510727166 y enseguida se le atenderà."));
	              Image imgTres=Image.getInstance("src\\img\\abajo.png");
	              imgTres.scalePercent(68);
	              imgTres.setAbsolutePosition(10,1);//Posición
	              documento.add(          imgTres);//Agrega otra imagen
	            documento.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }//End PDF
			
		}
		
		
        
        
        
    }// Main

public String consultarDisquera() {
	String dato = "";
	try {
		Statement st = conn.createStatement();
		String sql3 = "Select nombre from disquera where id_disquera="+b ;
			ResultSet rs3 = st.executeQuery(sql3);
				while(rs3.next()) {
					dato =rs3.getString(1);
				}return dato;
	} catch (Exception e) {
		e.printStackTrace();
	} // Catch
	return dato;
}

public String consultarArtista() {
	String dato = "";
	try {
		Statement st = conn.createStatement();
		String sql2 = "Select nombre from artista where id_artista=" + a;
		ResultSet rs2 = st.executeQuery(sql2);
		while (rs2.next()) {
			dato = rs2.getString(1);
		}
		return dato;
	} catch (Exception e) {
		e.printStackTrace();
	} // Catch
	return dato;
}
	
}

