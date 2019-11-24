package froms;

import java.awt.Color;
/**
 * PanelDisquera, que se integra al Frame Principal
 * 
 * @author Liz Jimenez & Antonio Alonso
 */
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import clases.Disquera;

public class PanelDisquera {
	static JPanel panel2 = new JPanel();

	// Componentes
	/**
	 * Componentes que integran el panel Para la manipulacion del usuario
	 */
	JTextField tfNombre = new JTextField("");
	JTextField tfDireccion = new JTextField("");
	JTextField tfTelefono = new JTextField("");
	JTextField tfCorreo = new JTextField("");
	JDateChooser calendario = new JDateChooser();
	PanelAlbum llenar = new PanelAlbum();

	// Variables
	int id_disquera;
	String nombre_d, direccion, correo;
	String fecha_creacion;
	long telefono;

	public PanelDisquera() {

		// Colores Panel
		Color c = new Color(253, 231, 120);
		panel2.setBackground(c);

		Font fuente = new Font("Arial", 0, 20);
		panel2.setLayout(null);

		// imagen
		JLabel lbl6 = new JLabel();
		lbl6.setIcon(new ImageIcon("src/img/disquera.png"));
		lbl6.setBounds(10, 10, 450, 500);
		panel2.add(lbl6);

		// Titulo
		JLabel lblSeccionDisquera = new JLabel();
		lblSeccionDisquera.setFont(fuente);
		lblSeccionDisquera.setBounds(150, 30, 648, 50);
		lblSeccionDisquera.setIcon(new ImageIcon("src/img/secciondedisqueras.png"));
		panel2.add(lblSeccionDisquera);
		// una etiqueta en el panel de la pestaña 1

		// Nombre
		JLabel lbl7 = new JLabel("Nombre Disquera: ");
		lbl7.setBounds(250, 100, 348, 20);
		panel2.add(lbl7);
		tfNombre.setBounds(380, 100, 150, 22);
		panel2.add(tfNombre);

		// Direccion
		JLabel lbl8 = new JLabel("Dirección: ");
		lbl8.setBounds(250, 130, 348, 20);
		panel2.add(lbl8);
		tfDireccion.setBounds(380, 130, 150, 22);
		panel2.add(tfDireccion);

		JLabel lbl9 = new JLabel("Teléfono: ");
		lbl9.setBounds(250, 160, 348, 20);
		panel2.add(lbl9);
		tfTelefono.setBounds(380, 160, 150, 22);
		panel2.add(tfTelefono);

		// Correo
		JLabel lbl10 = new JLabel("Correo: ");
		lbl10.setBounds(250, 190, 348, 20);
		panel2.add(lbl10);
		tfCorreo.setBounds(380, 190, 150, 22);
		panel2.add(tfCorreo);

		// Fecha
		JLabel fecha = new JLabel("Fecha creación: ");
		fecha.setBounds(250, 230, 348, 20);
		panel2.add(fecha);
		
		// Ubicar y agregar al panel
		calendario.setBounds(380, 230, 150, 20);
		panel2.add(calendario);

		JButton btnRegistrar = new JButton();
		btnRegistrar.setBounds(250, 330, 50, 50);
		ImageIcon iconRegistro = new ImageIcon("src/img/add.png");
		btnRegistrar.setIcon(iconRegistro);
		panel2.add(btnRegistrar);

		// Evento Registrar
		ActionListener registrar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Validacion de campos vacios
				if (tfNombre.getText().equalsIgnoreCase("") || tfDireccion.getText().equalsIgnoreCase("")
						|| tfTelefono.getText().equalsIgnoreCase("") || tfCorreo.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Falta algun campo por llenar");
				} else {
					// Proceso de registro
					nombre_d = tfNombre.getText();
					direccion = tfDireccion.getText();
					telefono = Long.parseLong(tfTelefono.getText());
					correo = tfCorreo.getText();
					Disquera validar = new Disquera(nombre_d);
					validar.consultarIdDisquera();
					id_disquera = validar.getId_disquera();
					if (id_disquera == 0) {
						Disquera registro = new Disquera(nombre_d, direccion, correo, formatoFecha(), telefono);
						registro.registro();
						limpiarDatos();
						llenar.llenarDisquera();
					} else {
						JOptionPane.showMessageDialog(null, "El nombre de la disquera ya existe");
					}
				}
			}
		};
		// Activacion del evento registro
		btnRegistrar.addActionListener(registrar);

		JButton btnEditar = new JButton();
		btnEditar.setBounds(330, 330, 50, 50);
		ImageIcon iconEdit = new ImageIcon("src/img/edit.png");
		btnEditar.setIcon(iconEdit);
		panel2.add(btnEditar);

		// Evento modificar
		ActionListener modificar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// setVisible(false);
				if (tfNombre.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Consulta disquera para modificar");
				} else {
					nombre_d = tfNombre.getText();
					direccion = tfDireccion.getText();
					correo = tfCorreo.getText();
					telefono = Long.parseLong(tfTelefono.getText());
					Disquera editar = new Disquera(nombre_d, direccion, correo, telefono);
					editar.consultarIdDisquera();
					id_disquera = editar.getId_disquera();
					editar.modifica();
					limpiarDatos();
					llenar.llenarDisquera();
				}
			}
		};
		// Activacion del evento modificar
		btnEditar.addActionListener(modificar);

		JButton btnConsultar = new JButton();
		btnConsultar.setBounds(410, 330, 50, 50);
		ImageIcon iconConsulta = new ImageIcon("src/img/consulta.png");
		btnConsultar.setIcon(iconConsulta);
		panel2.add(btnConsultar);
		// Evento consultar
		ActionListener consultar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nombre_d = JOptionPane.showInputDialog("Ingresa el nombre de la disquera");
				Disquera consulta = new Disquera(nombre_d);
				consulta.consultarIdDisquera();
				id_disquera = consulta.getId_disquera();
				if (id_disquera == 0) {
					JOptionPane.showMessageDialog(null, "Disquera no encontrada");
				} else {
					consulta.consultarDisquera();
					tfNombre.setText(consulta.getNombre_d());
					tfDireccion.setText(consulta.getDireccion());
					telefono = consulta.getTelefono();
					String aux = String.valueOf(telefono);
					tfTelefono.setText(aux);
					tfCorreo.setText(consulta.getCorreo());

					fecha_creacion = consulta.getFecha_creacion();
					 try {
						 SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
					      Date fechaDate = formato.parse(fecha_creacion);
					      calendario.setDate(fechaDate);
					      } catch (ParseException ex) {
					        System.out.println(ex);
					      }//end catch   
				}//end else
			}
		};
		// Activacion del evento modificar
		btnConsultar.addActionListener(consultar);

		JButton btnEliminar = new JButton();
		btnEliminar.setBounds(490, 330, 50, 50);
		ImageIcon iconEliminar = new ImageIcon("src/img/eliminar.png");
		btnEliminar.setIcon(iconEliminar);
		panel2.add(btnEliminar);
		// Evento eliminar
		ActionListener eliminar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tfNombre.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Consulta disquera para poder eliminar");
				} else {
					nombre_d = tfNombre.getText();
					Disquera eliminar = new Disquera(nombre_d);
					eliminar.consultarIdDisquera();
					id_disquera = eliminar.getId_disquera();
					if (id_disquera == 0) {
						JOptionPane.showMessageDialog(null, "No existe la disquera");
					} else {
						int v = JOptionPane.showConfirmDialog(null, "Deseas eliminar la disquera?");
						if (v == 0) {
							eliminar.elimina();
							limpiarDatos();
							llenar.llenarDisquera();
						}

					}

				}
			}
		};
		// Activacion del evento eliminar
		btnEliminar.addActionListener(eliminar);

		JButton btnLimpiar = new JButton();
		btnLimpiar.setBounds(570, 330, 50, 50);
		ImageIcon iconLimpiar = new ImageIcon("src/img/limpiar.png");
		btnLimpiar.setIcon(iconLimpiar);
		panel2.add(btnLimpiar);
		// Evento limpiar
		ActionListener limpiar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarDatos();
			}
		};
		// Activacion del evento eliminar
		btnLimpiar.addActionListener(limpiar);
	}

	/**
	 * Metodo para limpiar el panel
	 */
	public void limpiarDatos() {
		tfNombre.setText("");
		tfDireccion.setText("");
		tfTelefono.setText("");
		tfCorreo.setText("");
		calendario.setDate(null);
	}

	public String formatoFecha() {
		String hola;
		int mes = 0;
		mes = calendario.getCalendar().get(Calendar.MONTH) + 1;
		hola = Integer.toString(calendario.getCalendar().get(Calendar.YEAR)) + "-" + Integer.toString(mes) + "-"
				+ Integer.toString(calendario.getCalendar().get(Calendar.DAY_OF_MONTH));
		return hola;
	}

}
