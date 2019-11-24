package clases;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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

/**
 * Class Reportes Para la manipulacion del from Reportes
 * 
 * @author Liz Jimenez & Antonio Alonso
 */
public class Reportes extends Thread{
	Connection conn = ConexionPostgresSingleton.getConnection();
	String nombrea;
	int a, b;

	Font fuente = new Font();
	Font fuente1 = new Font();

	public Reportes(String nombre) {
		this.nombrea = nombre;
	}

	// Reporte de los albunes de un artista

	public void run() {
		fuente.setSize(20);
		fuente1.setColor(0, 255, 0);
		try {
			System.out.println("Entro");
			Document documento = new Document(PageSize.LETTER);// Crea un objeto
			PdfWriter.getInstance(documento,
					new FileOutputStream("C:\\Users\\Liz Jimenez\\Desktop\\ConsultaArtista.pdf"));
			// Crea el Pdf
			documento.open();

			Image imgTre = Image
					.getInstance("C:\\Users\\Liz Jimenez\\Downloads\\PracticaA7\\PracticaA7\\src\\froms\\Nueva.png");
			imgTre.scalePercent(68);
			imgTre.setAbsolutePosition(32, 680);// Posición
			documento.add(imgTre);// Agrega otra imagen
			documento.add(new Paragraph(" "));// Almaceno informacion
			documento.add(new Paragraph(" "));// Almaceno informacion
			documento.add(new Paragraph(" "));// Almaceno informacion
			documento.add(new Paragraph(" "));// Almaceno informacion
			documento.add(new Paragraph("		            Consulta de los albums del artista: " + nombrea, fuente));// Almaceno
																														// informacion
			documento.add(new Paragraph(" "));// Almaceno informacion
			documento.add(new Paragraph(" "));// Almaceno informacion
			documento.add(new Paragraph("A contunuacion se muestran los albums con su descripciòn que el artista "
					+ nombrea + " ha lanzado a lo largo de su trayectoria. "));// Almaceno informacion
			documento.add(new Paragraph("       "));
			documento.add(new Paragraph("       "));
			PdfPTable tabla = new PdfPTable(4);// Crea tablas y por medio del construcctor le mando el numero de
												// columnas que va tener mi tabla
			PdfPCell celda = new PdfPCell(new Phrase("NO.", fuente1));// Crear celdas
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);// Centra el titulo o encabezados.
			celda.setColspan(1);
			tabla.addCell(celda);

			PdfPCell celda2 = new PdfPCell(new Phrase("NOMBRE", fuente1));// Crear celdas
			celda2.setHorizontalAlignment(Element.ALIGN_CENTER);// Centra el titulo o encabezados.
			celda2.setColspan(1);
			tabla.addCell(celda2);

			PdfPCell celda4 = new PdfPCell(new Phrase("GÈNERO", fuente1));// Crear celdas
			celda4.setHorizontalAlignment(Element.ALIGN_CENTER);// Centra el titulo o encabezados.
			celda4.setColspan(1);
			tabla.addCell(celda4);

			PdfPCell celda5 = new PdfPCell(new Phrase("DURACIÒN", fuente1));// Crear celdas
			celda5.setHorizontalAlignment(Element.ALIGN_CENTER);// Centra el titulo o encabezados.
			celda5.setColspan(1);
			tabla.addCell(celda5);
			// Consulto IDArtista
			consultarIdArtista();
			// Conexion
			Statement st = conn.createStatement();
			String sql = "Select * from album where artista=" + id_art;
			ResultSet rs = st.executeQuery(sql);
			int contador = 1;
			while (rs.next()) {
				tabla.addCell("    " + contador);// Recibir una cadena de texto, deben completarse la cantidad de celdas
													// como tantas cantidad de columnas, si no no se agrega
				tabla.addCell("    " + rs.getString(2));
				tabla.addCell("    " + rs.getString(5));
				tabla.addCell("    " + rs.getString(6));
				contador++;
			}
			documento.add(tabla);// Agrego la tabla ya construida al documento
			documento.add(new Paragraph("       "));
			documento.add(new Paragraph("       "));
			documento.add(new Paragraph("					Cualquier duda o aclaraciòn favor de marcar al numero "
					+ "5537015892 o bien 5510727166 y enseguida se le atenderà."));
			Image imgTres = Image
					.getInstance("C:\\Users\\Liz Jimenez\\Downloads\\PracticaA7\\PracticaA7\\src\\froms\\abajo.png");
			imgTres.scalePercent(68);
			imgTres.setAbsolutePosition(10, 1);// Posición
			documento.add(imgTres);// Agrega otra imagen
			documento.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} // Catch
	}// Main

	// Consultar Id artista
	int id_art;

	public void consultarIdArtista() {
		try {
			Statement st = conn.createStatement();
			String sql = "Select id_artista from artista where nombre_artistico='" + nombrea + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				id_art = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
