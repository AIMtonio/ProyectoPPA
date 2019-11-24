package froms;

/**
 * Frame de reportes
 * 
 * @author Liz Jimenez & Antonio Alonso
 */
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Album;
import clases.ReporteDos;
import clases.Reportes;

public class PanelReportes extends Frame {
	static JPanel panel4 = new JPanel();

	/**
	 * Constructor que inicializa el frame con sus atributos
	 */
	public PanelReportes() {
		Font fuente = new Font("Arial", 0, 20);
		panel4.setLayout(null);

		// imagen
		JLabel lbl19 = new JLabel();
		lbl19.setIcon(new ImageIcon("src/froms/img.png"));
		lbl19.setBounds(10, 10, 450, 500);
		panel4.add(lbl19);

		// Titulo
		JLabel lblT4 = new JLabel("SECCIÓN DE REPORTES ");
		lblT4.setFont(fuente);
		lblT4.setBounds(250, 30, 348, 20);
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
					
				}else if(rep.getSelectedItem()=="Fecha de creación") {
					labelartista.setVisible(false);
					labelcreacion.setVisible(true);
					textoartista.setVisible(false);
					textocreacion.setVisible(true);
					botonartista.setVisible(false);
					botoncreacion.setVisible(true);
					
				}else if(rep.getSelectedItem()=="Seleccionar") {
					labelartista.setVisible(false);
					labelcreacion.setVisible(false);
					textoartista.setVisible(false);
					textocreacion.setVisible(false);
					botoncreacion.setVisible(false);
					botonartista.setVisible(false);
				}
		}
		};
	
		// Activacion del evento registro
		rep.addActionListener(mostrar);
		
		
		ActionListener pdfalbumartista = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String contenido=textoartista.getText();
				if(contenido!=null) {
					Reportes objeto=new Reportes(contenido);
					System.out.println(contenido);
					objeto.start();
					JOptionPane.showMessageDialog(null, "Se genero el PDF, revisa en el Escritorio de la lap");
				}else {
					JOptionPane.showMessageDialog(null, "El artista no existe");
				}
		}
		};
	
		// Activacion del evento registro
		botonartista.addActionListener(pdfalbumartista);
			
		
		ActionListener pdffecha = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String contenido=textocreacion.getText();
				if(contenido!=null) {
					Reportes objeto=new Reportes(contenido);
					System.out.println(contenido);
					objeto.start();
					JOptionPane.showMessageDialog(null, "Se genero el PDF, revisa en el Escritorio de la lap");
				}else {
					JOptionPane.showMessageDialog(null, "El artista no existe");
				}
		}
		};
	
		// Activacion del evento registro
		botoncreacion.addActionListener(pdffecha);
			
		
	}
}
