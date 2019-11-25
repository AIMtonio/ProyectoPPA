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

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import conexion.ConexionPostgresSingleton;

/**
 * Class Reportes Para la manipulacion del from Reportes
 * 
 * @author Liz Jimenez & Antonio Alonso
 */

public class Reportes extends Thread {
	// Variables de clase

	Connection conn = ConexionPostgresSingleton.getConnection();
	String nombrea;
	int a, b;
	boolean security;
	int id_art;

	Font fuente = new Font();
	Font fuente1 = new Font();

	/**
	 * Constructor para inicializar las variables
	 * 
	 * @param nombre
	 * @param sec
	 */
	public Reportes(String nombre, boolean sec) {
		this.nombrea = nombre;
		this.security = sec;
	}

	/**
	 * Metodo que ejecuta el hilo
	 */
	public void run() {

		if (security == true) {
			// Inicio creacion PDF
			fuente.setSize(20);
			fuente1.setColor(0, 255, 0);
			try {
				// System.out.println("Entro");
				Document documento = new Document(PageSize.LETTER);// Crea un objeto
				PdfWriter.getInstance(documento, new FileOutputStream("src\\pdfs\\ConsultaArtista.pdf"));
				// Crea el Pdf
				documento.open();

				Image imgTre = Image.getInstance("src\\img\\Nueva.png");
				imgTre.scalePercent(68);
				imgTre.setAbsolutePosition(32, 680);// Posición
				documento.add(imgTre);// Agrega otra imagen
				documento.add(new Paragraph(" "));// Almaceno informacion
				documento.add(new Paragraph(" "));// Almaceno informacion
				documento.add(new Paragraph(" "));// Almaceno informacion
				documento.add(new Paragraph(" "));// Almaceno informacion
				documento.add(
						new Paragraph("		            Consulta de los albums del artista: " + nombrea, fuente));// Almaceno
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
					tabla.addCell("    " + contador);// Recibir una cadena de texto, deben completarse la cantidad de
														// celdas
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
				Image imgTres = Image.getInstance("src\\img\\abajo.png");
				imgTres.scalePercent(68);
				imgTres.setAbsolutePosition(10, 1);// Posición
				documento.add(imgTres);// Agrega otra imagen
				documento.close();

			} catch (Exception e) {
				e.printStackTrace();
			} // Catch
		} else {
			String nombreAlbumEncriptado = null;
			String generoAlbumEncriptado = null;
			String duracionAlbumEncriptado = null;
			String idAlbumEncriptado = null;
			byte[] encriptadon; // nombreAlbum
			byte[] encriptadog; // generoAlbum
			byte[] encriptadod; // duracionAlbum
			byte[] encriptadoc; // idAlbum
			// Inicio creacion PDF
			fuente.setSize(20);
			fuente1.setColor(0, 255, 0);
			try {
				// System.out.println("Entro");
				Document documento = new Document(PageSize.LETTER);// Crea un objeto
				PdfWriter.getInstance(documento, new FileOutputStream("src\\pdfs\\ConsultaArtista.pdf"));
				// Crea el Pdf
				documento.open();

				Image imgTre = Image.getInstance("src\\img\\Nueva.png");
				imgTre.scalePercent(68);
				imgTre.setAbsolutePosition(32, 680);// Posición
				documento.add(imgTre);// Agrega otra imagen
				documento.add(new Paragraph(" "));// Almaceno informacion
				documento.add(new Paragraph(" "));// Almaceno informacion
				documento.add(new Paragraph("Autentificación Incorrecta."));// Almaceno informacion
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
					idAlbumEncriptado = rs.getString(1);
					nombreAlbumEncriptado = rs.getString(2);
					generoAlbumEncriptado = rs.getString(5);
					duracionAlbumEncriptado = rs.getString(6);
					// Guarda lo obtenido de la base
					try {
						KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
						keyGenerator.init(128);
						Key key = keyGenerator.generateKey();

						key = new SecretKeySpec("una clave de 16 bytes".getBytes(), 0, 16, "AES");

						Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");

						aes.init(Cipher.ENCRYPT_MODE, key);
						// byte[] encriptado = aes.doFinal(texto.getBytes());

						encriptadon = aes.doFinal(nombreAlbumEncriptado.getBytes());
						encriptadog = aes.doFinal(generoAlbumEncriptado.getBytes());
						encriptadod = aes.doFinal(duracionAlbumEncriptado.getBytes());
						encriptadoc = aes.doFinal(idAlbumEncriptado.getBytes());

						// fin seguridad

						tabla.addCell("    " + encriptadoc);
						tabla.addCell("    " + encriptadon);
						tabla.addCell("    " + encriptadog);
						tabla.addCell("    " + encriptadod);
						contador++;
					} catch (Exception e) {
						e.printStackTrace();
					} // Catch
					contador++;
				}
				documento.add(tabla);// Agrego la tabla ya construida al documento
				documento.add(new Paragraph(" "));// Almaceno informacion
				documento.add(new Paragraph("Contraseña de disquera incorrecta no puedes visualizar reportes oficiales"
						+ " sin porporcionar la contraseña correcta       "));
				documento.add(new Paragraph(" "));// Almaceno informacion
				documento.add(new Paragraph("					Cualquier duda o aclaraciòn favor de marcar al numero "
						+ "5537015892 o bien 5510727166 y enseguida se le atenderà."));
				Image imgTres = Image.getInstance("src\\img\\abajo.png");
				imgTres.scalePercent(68);
				imgTres.setAbsolutePosition(10, 1);// Posición
				documento.add(imgTres);// Agrega otra imagen
				documento.close();

			} catch (Exception e) {
				e.printStackTrace();
			} // Catch

		}

	}

	/**
	 * Metodo para Consultar Id artista
	 */
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
	}// end metodo consultarIdArtista

}
