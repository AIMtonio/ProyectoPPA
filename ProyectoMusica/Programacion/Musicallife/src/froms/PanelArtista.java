package froms;

import java.awt.Color;
/**
 * PanelArtista, que se integra al Frame Principal
 * 
 * @author Liz Jimenez & Antonio Alonso
 */
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;


import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import clases.Artista;

import java.awt.event.*;
import java.awt.geom.Area;
import java.security.KeyRep;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PanelArtista extends JFrame {
//Variables de clase
	int id_artista;
	String nombreArtista;
	String apellidosArtista;
	String nombreArtistico;
	String sexo;
	String fecha_nacimiento;
	String nacionalidad;
	/**
	 * Componentes que integran el panel Para la manipulacion del usuario
	 */
	JComboBox combo = new JComboBox();
	JTextField tfArtista = new JTextField();
	JTextField tfApellidos = new JTextField("");
	JTextField tfNartistico = new JTextField("");
	// Definir Radio buttons
	JRadioButton rbtn1 = new JRadioButton("Masculino", false);
	JRadioButton rbtn2 = new JRadioButton("Femenino", false);
	JDateChooser calendario=new JDateChooser();
	PanelAlbum llenar=new PanelAlbum();
	

	static JPanel panel1 = new JPanel();

	public PanelArtista() {
		//Color de BG del Jpanel
		Color c=new Color(31, 254, 156);
		panel1.setBackground(c);
		
		panel1.setLayout(null);
		// imagen
		JLabel lbl0 = new JLabel();
		lbl0.setIcon(new ImageIcon("src/img/artista.png"));
		lbl0.setBounds(10, 10, 450, 500);
		panel1.add(lbl0);

		// Titulo
		Font fuente = new Font("Arial", 0, 20);
		//JLabel lblT = new JLabel("SECCIÓN DE ARTISTAS ");
		JLabel lblSeccionArtistas = new JLabel();
		lblSeccionArtistas.setIcon(new ImageIcon("src/img/secciondeartistas.png"));
		lblSeccionArtistas.setBounds(150, 30, 648, 50);
		panel1.add(lblSeccionArtistas);
		// una etiqueta en el panel de la pestaña 1

		// Nombre
		JLabel lbl1 = new JLabel("Nombre: ");
		lbl1.setBounds(250, 100, 348, 20);
		panel1.add(lbl1);
		tfArtista.setBounds(380, 100, 150, 22);
		panel1.add(tfArtista);

		// Apellidos
		JLabel lbl2 = new JLabel("Apellidos:");
		lbl2.setBounds(250, 130, 348, 20);
		panel1.add(lbl2);
		tfApellidos.setBounds(380, 130, 150, 22);
		panel1.add(tfApellidos);

		// Nombre artistico
		JLabel lbl3 = new JLabel("Nombre artistico: ");
		lbl3.setBounds(250, 160, 348, 20);
		panel1.add(lbl3);
		tfNartistico.setBounds(380, 160, 150, 22);
		panel1.add(tfNartistico);

		// Sexo
		JLabel lbl6 = new JLabel("Sexo: ");
		lbl6.setBounds(250, 190, 348, 20);
		panel1.add(lbl6);
		// Agrupar radio Buttons
		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(rbtn1);
		grupo1.add(rbtn2);
		// Definir posicion RB
		rbtn1.setBounds(410, 190, 100, 20);
		rbtn2.setBounds(410, 210, 100, 20);
		// Mostrar RB
		panel1.add(rbtn1);
		panel1.add(rbtn2);

		// Nacionalidad
		JLabel lbl5 = new JLabel("Nacionalidad: ");
		lbl5.setBounds(250, 240, 348, 20);
		panel1.add(lbl5);
		// Combo box
		// Item default
		combo.addItem("Selecciona");
		ActionListener radioH = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarCombo();
				combo.addItem("afgano");
				combo.addItem("alemán");
				combo.addItem("árabe");
				combo.addItem("argentino");
				combo.addItem("australiano");
				combo.addItem("belga");
				combo.addItem("boliviano");
				combo.addItem("brasileño");
				combo.addItem("camboyano");
				combo.addItem("canadiense");
				combo.addItem("chileno");
				combo.addItem("chino");
				combo.addItem("colombiano");
				combo.addItem("coreano");
				combo.addItem("costarricense");
				combo.addItem("cubano");
				combo.addItem("danés");
				combo.addItem("ecuatoriano");
				combo.addItem("egipcio");
				combo.addItem("salvadoreño");
				combo.addItem("escocés");
				combo.addItem("español");
				combo.addItem("estadounidense");
				combo.addItem("estonio");
				combo.addItem("etiope");
				combo.addItem("filipino");
				combo.addItem("finlandés");
				combo.addItem("francés");
				combo.addItem("galés");
				combo.addItem("griego");
				combo.addItem("guatemalteco");
				combo.addItem("haitiano");
				combo.addItem("holandés");
				combo.addItem("hondureño");
				combo.addItem("indonés");
				combo.addItem("inglés");
				combo.addItem("iraquí");
				combo.addItem("iraní");
				combo.addItem("irlandés");
				combo.addItem("israelí");
				combo.addItem("italiano");
				combo.addItem("japonés");
				combo.addItem("jordano");
				combo.addItem("laosiano");
				combo.addItem("letón");
				combo.addItem("letonés");
				combo.addItem("malayo");
				combo.addItem("marroquí");
				combo.addItem("mexicano");
				combo.addItem("nicaragüense");
				combo.addItem("noruego");
				combo.addItem("neozelandés");
				combo.addItem("panameño");
				combo.addItem("paraguayo");
				combo.addItem("peruano");
				combo.addItem("polaco");
				combo.addItem("portugués");
				combo.addItem("puertorriqueño");
				combo.addItem("dominicano");
				combo.addItem("rumano");
				combo.addItem("ruso");
				combo.addItem("sueco");
				combo.addItem("suizo");
				combo.addItem("tailandés");
				combo.addItem("taiwanes");
				combo.addItem("turco");
				combo.addItem("ucraniano");
				combo.addItem("uruguayo");
				combo.addItem("venezolano");
				combo.addItem("vietnamita");
			}
		};
		// Activacion del evento de radio Hombre
		rbtn1.addActionListener(radioH);

		ActionListener radioM = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarCombo();
				combo.addItem("afgana");
				combo.addItem("alemana");
				combo.addItem("árabe");
				combo.addItem("argentina");
				combo.addItem("australiana");
				combo.addItem("belga");
				combo.addItem("boliviana");
				combo.addItem("brasileña");
				combo.addItem("camboyana");
				combo.addItem("canadiense");
				combo.addItem("chilena");
				combo.addItem("china");
				combo.addItem("colombiana");
				combo.addItem("coreana");
				combo.addItem("costarricense");
				combo.addItem("cubana");
				combo.addItem("danesa");
				combo.addItem("ecuatoriana");
				combo.addItem("egipcia");
				combo.addItem("salvadoreña");
				combo.addItem("escocesa");
				combo.addItem("española");
				combo.addItem("estadounidense");
				combo.addItem("estonia");
				combo.addItem("etiope");
				combo.addItem("filipina");
				combo.addItem("finlandesa");
				combo.addItem("francesa");
				combo.addItem("galesa");
				combo.addItem("griega");
				combo.addItem("guatemalteca");
				combo.addItem("haitiana");
				combo.addItem("holandesa");
				combo.addItem("hondureña");
				combo.addItem("indonesa");
				combo.addItem("inglesa");
				combo.addItem("iraquí");
				combo.addItem("iraní");
				combo.addItem("irlandesa");
				combo.addItem("israelí");
				combo.addItem("italiana");
				combo.addItem("japonesa");
				combo.addItem("jordana");
				combo.addItem("laosiana");
				combo.addItem("letona");
				combo.addItem("letonesa");
				combo.addItem("malaya");
				combo.addItem("marroquí");
				combo.addItem("mexicana");
				combo.addItem("nicaragüense");
				combo.addItem("noruega");
				combo.addItem("neozelandesa");
				combo.addItem("panameña");
				combo.addItem("paraguaya");
				combo.addItem("peruana");
				combo.addItem("polaca");
				combo.addItem("portuguesa");
				combo.addItem("puertorriqueña");
				combo.addItem("dominicana");
				combo.addItem("rumana");
				combo.addItem("rusa");
				combo.addItem("sueca");
				combo.addItem("suiza");
				combo.addItem("tailandesa");
				combo.addItem("taiwanesa");
				combo.addItem("turca");
				combo.addItem("ucraniana");
				combo.addItem("uruguaya");
				combo.addItem("venezolana");
				combo.addItem("vietnamita");
			}
		};
		// Activacion del evento de radio Mujer
		rbtn2.addActionListener(radioM);
		// Establecer posicion al combo
		combo.setBounds(380, 240, 150, 22);
		// añadir combo al panel
		panel1.add(combo);

		// Fecha nacimiento
		JLabel lbl4 = new JLabel("Fecha de nacimiento: ");
		lbl4.setBounds(250, 280, 348, 20);
		panel1.add(lbl4);

		// Ubicar y agregar al panel
		calendario.setBounds(380, 280, 150, 20);
		panel1.add(calendario);
		
		// Boton registrar
		//JButton btnRegistrar = new JButton("Registrar");
		JButton btnRegistrar = new JButton();
		//btnRegistrar.setBounds(250, 330, 100, 20);
		btnRegistrar.setBounds(250, 330, 50, 50);
		ImageIcon iconRegistro=new ImageIcon("src/img/add.png");
		btnRegistrar.setIcon(iconRegistro);
		panel1.add(btnRegistrar);

		// Evento registrar
		ActionListener registro = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tfArtista.getText().equalsIgnoreCase("")
						|| tfApellidos.getText().equalsIgnoreCase("")
						|| tfNartistico.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Algun campo esta vacio");
				} else {
					// Validar si existe
					nombreArtistico = tfNartistico.getText();
					Artista validar = new Artista(nombreArtistico);
					validar.consultarIdArtista();
					id_artista = validar.getId_artista();
					if (id_artista == 0) {
						nombreArtista = tfArtista.getText();
						apellidosArtista = tfApellidos.getText();
						nombreArtistico = tfNartistico.getText();
						if (rbtn1.isSelected()) {
							sexo = "M";
						} else if (rbtn2.isSelected()) {
							sexo = "F";
						}
						nacionalidad = (String) combo.getSelectedItem();
						//fecha_nacimiento = "1998-07-15";
						Artista registro = new Artista(nombreArtista, apellidosArtista, nombreArtistico, nacionalidad,
								sexo, formatoFecha());
						registro.registro();
						limpiarDatos();
						llenar.llenarArtista();
					} else {
						JOptionPane.showMessageDialog(null, "El nombre artistico ya existe");
					}
				}
			}
		};
		// Activacion del evento registro
		btnRegistrar.addActionListener(registro);

		// Boton modificar
		JButton btnEditar = new JButton();
		btnEditar.setBounds(330, 330, 50, 50);
		ImageIcon iconEdit=new ImageIcon("src/img/edit.png");
		btnEditar.setIcon(iconEdit);
		panel1.add(btnEditar);

		// Evento modificar
		ActionListener modificar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tfNartistico.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Consulta artista para poder modificar");
				} else {
					nombreArtista = tfArtista.getText();
					apellidosArtista = tfApellidos.getText();
					nombreArtistico = tfNartistico.getText();
					nacionalidad = (String) combo.getSelectedItem();
					Artista actualizacion = new Artista(id_artista, nombreArtista, apellidosArtista, nombreArtistico,
							nacionalidad);
					actualizacion.setN_artistico(nombreArtistico);
					JOptionPane.showMessageDialog(null, "n artistico: " + nombreArtistico);
					actualizacion.consultarIdArtista();
					id_artista = actualizacion.getId_artista();
					actualizacion.modifica();
					limpiarCombo();
					limpiarDatos();
					llenar.llenarArtista();
				}
			}
		};
		// Activacion del evento registro
		btnEditar.addActionListener(modificar);

		// Boton consulta
		JButton btnConsultar = new JButton();
		btnConsultar.setBounds(410, 330, 50, 50);
		ImageIcon iconConsulta=new ImageIcon("src/img/consulta.png");
		btnConsultar.setIcon(iconConsulta);
		panel1.add(btnConsultar);

		// Evento consultar
		ActionListener consultar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				combo.removeAllItems();
				nombreArtistico = JOptionPane.showInputDialog("Ingresa el nombre artistico: ");
				Artista consultar = new Artista(nombreArtistico);
				consultar.consultarIdArtista();
				id_artista = consultar.getId_artista();
				if (id_artista != 0) {
					consultar.consulta(id_artista);
					tfArtista.setText(consultar.getNombre());
					tfApellidos.setText(consultar.getApellido());
					tfNartistico.setText(consultar.getN_artistico());
					sexo = consultar.getSexo();
					if (sexo.equalsIgnoreCase("M")) {
						rbtn1.setSelected(true);
					} else if (sexo.equalsIgnoreCase("F")) {
						rbtn2.setSelected(true);
					} else {
						JOptionPane.showMessageDialog(null, "No se encontro sexo.");
					}
					combo.addItem(consultar.getNacionalidad());
					llenar.llenarArtista();
					
					fecha_nacimiento = consultar.getFecha_nac();
					
					 try {
						 SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
					      Date fechaDate = formato.parse(fecha_nacimiento);
					      calendario.setDate(fechaDate);
					      } catch (ParseException ex) {
					        System.out.println(ex);
					      }   
				} else {
					JOptionPane.showMessageDialog(null, "Artista no encontrado");
				}
			}
		};
		// Activacion del evento registro
		btnConsultar.addActionListener(consultar);

		// Boton eliminar
		JButton btnEliminar = new JButton();
		btnEliminar.setBounds(490, 330, 50, 50);
		ImageIcon iconEliminar=new ImageIcon("src/img/eliminar.png");
		btnEliminar.setIcon(iconEliminar);
		panel1.add(btnEliminar);

		// Evento eliminar
		ActionListener eliminar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tfNartistico.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Consulta artista para poder eliminar");
				} else {
					int v = JOptionPane.showConfirmDialog(null, "Deseas eliminar este registro?");
					// si 0
					// no 1
					// cancelar 2
					if (v == 0) {
						if (id_artista == 0) {
							JOptionPane.showMessageDialog(null, "El artista no existe");
						} else {
							nombreArtistico = tfNartistico.getText();
							Artista eliminar = new Artista(nombreArtistico);
							eliminar.consultarIdArtista();
							id_artista = eliminar.getId_artista();
							eliminar.elimina();
							limpiarDatos();
							llenar.llenarArtista();
						}
					} else {
					}
				}
			}
		};
		// Activacion del evento eliminar
		btnEliminar.addActionListener(eliminar);
		
		// Boton limpiar
				JButton btnLimpiar = new JButton();
				btnLimpiar.setBounds(570, 330, 50, 50);
				ImageIcon iconLimpiar=new ImageIcon("src/img/limpiar.png");
				btnLimpiar.setIcon(iconLimpiar);
				panel1.add(btnLimpiar);
				
				// Evento limpiar
				ActionListener limpiar = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						limpiarDatos();
					}
				};
				// Activacion del evento limpiar
				btnLimpiar.addActionListener(limpiar);
				
				
				KeyAdapter objeto= new  KeyAdapter(){
					public void keyTyped(KeyEvent evt) {
						char car = evt.getKeyChar();
				        if (Character.isDigit(car)) {
				            getToolkit().beep();
				            evt.consume();
				            ImageIcon icon=new ImageIcon("src/img/letras.png");
				            JOptionPane.showMessageDialog(null, "Solo se permite ingresar letras", "Advertencia", JOptionPane.PLAIN_MESSAGE, icon);
				        }
		            }
				};
				tfArtista.addKeyListener(objeto);
				tfApellidos.addKeyListener(objeto);
				tfNartistico.addKeyListener(objeto);
	}

	/**
	 * Metodo para limpiar los combos
	 */
	public void limpiarCombo() {
		combo.removeAllItems();
		combo.addItem("Selecciona");
	}

	/**
	 * Metodo para limpiar el panel
	 */
	public void limpiarDatos() {
		limpiarCombo();
		tfArtista.setText("");
		tfApellidos.setText("");
		tfNartistico.setText("");
		combo.addItem("Selecciona");
		rbtn1.setSelected(false);
		rbtn2.setSelected(false);
		calendario.setDate(null);
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
	
	 public static Date ParseFecha(String fecha){
	        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
	        Date fechaDate = null;
	        try {
	            fechaDate = formato.parse(fecha);
	        } catch (ParseException ex) {
	            System.out.println(ex);
	        }
	        return fechaDate;
	    }//End ParseFecha metedo

}
