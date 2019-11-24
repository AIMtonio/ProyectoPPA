package froms;

import java.awt.Color;
/**
 * Frame de reportes
 * 
 * @author Liz Jimenez & Antonio Alonso
 */
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import clases.Album;
import clases.Artista;
import clases.ReporteDos;
import clases.Reportes;

public class PanelReportes extends Frame {
	static JPanel panel4 = new JPanel();

	JDateChooser calendario=new JDateChooser();
	/**
	 * Constructor que inicializa el frame con sus atributos
	 */
	public PanelReportes() {
		//Color de BG del Jpanel
		Color c=new Color(255, 203, 70);
		panel4.setBackground(c);
		
		
		Font fuente = new Font("Arial", 0, 20);
		panel4.setLayout(null);
		//Contraseña de disquera
		String password = "musicallife";

		// imagen
		JLabel lbl19 = new JLabel();
		lbl19.setIcon(new ImageIcon("src/img/reportes.png"));
		lbl19.setBounds(10, 10, 450, 500);
		panel4.add(lbl19);

		// Titulo
		JLabel lblT4 = new JLabel();
		lblT4.setIcon(new ImageIcon("src/img/secciondereportes.png"));
		lblT4.setBounds(150, 30, 648, 50);
		panel4.add(lblT4);

		// una etiqueta en el panel de la pestaña 1
		JLabel lbl20 = new JLabel("Selecciona el tipo de reporte : ");
		lbl20.setBounds(250, 100, 348, 20);
		panel4.add(lbl20);

		JComboBox rep = new JComboBox();
		rep.addItem("Seleccionar");
		rep.addItem("Fecha de creación");
		rep.addItem("Albums del Artista");
		rep.setBounds(380, 130, 150, 22);
		panel4.add(rep);
		
		JLabel labelartista = new JLabel("Nombre de artista a buscar: ");
		labelartista.setBounds(250, 180, 348, 20);
		panel4.add(labelartista);

		JTextField textoartista = new JTextField("");
		textoartista.setBounds(380, 210, 150, 22);
		panel4.add(textoartista);
		
		JLabel labelcreacion = new JLabel("Fecha de creación del album: ");
		labelcreacion.setBounds(250, 180, 348, 20);
		panel4.add(labelcreacion);

		JTextField textocreacion = new JTextField("");
		textocreacion.setBounds(380, 210, 150, 22);
		panel4.add(textocreacion);
		
		JButton botoncreacion = new JButton("Generar");
		botoncreacion.setBounds(380, 260, 100, 22);
		panel4.add(botoncreacion);
		
		JButton botonartista = new JButton("Generar PDF");
		botonartista.setBounds(380, 260, 100, 22);
		panel4.add(botonartista);
		
		labelartista.setVisible(false);
		labelcreacion.setVisible(false);
		textoartista.setVisible(false);
		textocreacion.setVisible(false);
		botoncreacion.setVisible(false);
		botonartista.setVisible(false);
		
		ActionListener mostrar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rep.getSelectedItem().equals("Albums del Artista")) {
					labelartista.setVisible(true);
					labelcreacion.setVisible(false);
					textoartista.setVisible(true);
					textocreacion.setVisible(false);
					botonartista.setVisible(true);
					botoncreacion.setVisible(false);
					calendario.setVisible(false);
					
				}else if(rep.getSelectedItem()=="Fecha de creación") {
					labelartista.setVisible(false);
					labelcreacion.setVisible(true);
					textoartista.setVisible(false);
					textocreacion.setVisible(false);
					botonartista.setVisible(false);
					botoncreacion.setVisible(true);
					// Ubicar y agregar al panel
					calendario.setBounds(380, 210, 150, 20);
					panel4.add(calendario);
					calendario.setVisible(true);
					
				}else if(rep.getSelectedItem()=="Seleccionar") {
					labelartista.setVisible(false);
					labelcreacion.setVisible(false);
					textoartista.setVisible(false);
					textocreacion.setVisible(false);
					botoncreacion.setVisible(false);
					botonartista.setVisible(false);
					calendario.setVisible(false);
				}
		}
		};
	
		// Activacion del evento registro
		rep.addActionListener(mostrar);
		
		ActionListener pdfalbumartista = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombreArtista=textoartista.getText();
				
				Artista artista=new Artista(nombreArtista);
				artista.consultarIdArtista();
				int idArtista = artista.getId_artista();
				
				if(textoartista.getText().equalsIgnoreCase("")){
					JOptionPane.showMessageDialog(null, "Ingresa nombre artistico.");
				}else if(idArtista!=0) {
					//Obtener Clave
					boolean security;
					String op = JOptionPane.showInputDialog("Ingresa contraseña de la disquera para poder crear el reporte: ");
					if(op.equalsIgnoreCase("musicallife")) {
						security = true;
					}else {
						security = false;
						JOptionPane.showMessageDialog(null, "Falla de autenficiación. Revisa el Reporte.");
					}//end if
					Reportes objeto=new Reportes(nombreArtista, security);
					objeto.start();
					JOptionPane.showMessageDialog(null, "Se genero correctamente el reporte en PDF");
					
				}else {
					JOptionPane.showMessageDialog(null, "El artista no existe");
				}
		}
		};
	
		// Activacion del evento creacion pdf
		botonartista.addActionListener(pdfalbumartista);
			
		
		ActionListener pdffecha = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Album album=new Album();
				album.consultaFecha(formatoFecha());
				int idAlbum = album.getId_album();
				
				 if(idAlbum!=0) {
					
					boolean security;
					String op = JOptionPane.showInputDialog("Ingresa contraseña de la disquera para poder crear el reporte: ");
					if(op.equalsIgnoreCase("musicallife")) {
						security = true;
					}else {
						security = false;
						JOptionPane.showMessageDialog(null, "Falla de autenficiación. Revisa el Reporte.");
					}//end if
					ReporteDos objeto=new ReporteDos(formatoFecha(), security);
					objeto.start();
					JOptionPane.showMessageDialog(null, "Se genero correctamente el reporte en PDF");
				}else {
					JOptionPane.showMessageDialog(null, "No existen albums con esa fecha.");
				}
		}
		};
	
		// Activacion del evento registro
		botoncreacion.addActionListener(pdffecha);
			
		
	}
	
	public String formatoFecha() {
		String hola;
		int mes=0;
		mes=calendario.getCalendar().get(Calendar.MONTH)+1;
		hola = Integer.toString(calendario.getCalendar().get(Calendar.YEAR))
		+ "-" + Integer.toString(mes)
		+ "-" + Integer.toString(calendario.getCalendar().get(Calendar.DAY_OF_MONTH));
		return hola;
	}//end formatoFecha metodo
	
}
