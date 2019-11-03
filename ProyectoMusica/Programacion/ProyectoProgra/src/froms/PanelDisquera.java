package froms;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Artista;
import clases.Disquera;

public class PanelDisquera {
	static JPanel panel2 = new JPanel();
	
	//Componentes
	JTextField tfNombre = new JTextField("");
	JTextField tfDireccion = new JTextField("");
	JTextField tfTelefono = new JTextField("");
	JTextField tfCorreo = new JTextField("");
	JComboBox dia = new JComboBox();
	JComboBox mes = new JComboBox();
	JComboBox anio = new JComboBox();
	
	//Variables
	int id_disquera;
	String nombre_d, direccion, correo;
	String fecha_creacion;
	long telefono;
	
	public PanelDisquera() {
		Font fuente = new Font("Arial", 0, 20);
		panel2.setLayout(null);

		// imagen
		JLabel lbl6 = new JLabel();
		lbl6.setIcon(new ImageIcon("src/img/img.png"));
		lbl6.setBounds(10, 10, 450, 500);
		panel2.add(lbl6);
		
		// Titulo
		JLabel lblT2 = new JLabel("SECCIÓN DE DISQUERAS ");
		lblT2.setFont(fuente);
		lblT2.setBounds(250, 30, 348, 20);
		panel2.add(lblT2);
		// una etiqueta en el panel de la pestaña 1
		
		//Nombre
		JLabel lbl7 = new JLabel("Nombre Disquera: ");
		lbl7.setBounds(250, 100, 348, 20);
		panel2.add(lbl7);
		tfNombre.setBounds(380, 100, 150, 22);
		panel2.add(tfNombre);

		//Direccion
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

		//Correo
		JLabel lbl10 = new JLabel("Correo: ");
		lbl10.setBounds(250, 190, 348, 20);
		panel2.add(lbl10);
		tfCorreo.setBounds(380, 190, 150, 22);
		panel2.add(tfCorreo);
		
		//Fecha
		JLabel lbl11 = new JLabel("Fecha de creación: ");
		lbl11.setBounds(250, 220, 348, 20);
		panel2.add(lbl11);
		JLabel lbld = new JLabel("Día: ");
		lbld.setBounds(250, 250, 348, 20);
		panel2.add(lbld);

		
		dia.addItem("Seleccionar");
		dia.addItem("1");
		dia.addItem("2");
		dia.addItem("3");
		dia.setBounds(250, 270, 100, 22);
		panel2.add(dia);

		JLabel lblm = new JLabel("Mes: ");
		lblm.setBounds(400, 250, 348, 20);
		panel2.add(lblm);
		
		mes.addItem("Seleccionar");
		mes.addItem("01");
		mes.addItem("02");
		mes.addItem("03");
		mes.setBounds(400, 270, 100, 22);
		panel2.add(mes);

		JLabel lbla = new JLabel("Año: ");
		lbla.setBounds(550, 250, 348, 20);
		panel2.add(lbla);

		
		anio.addItem("Seleccionar");
		anio.addItem("2019");
		anio.addItem("2020");
		anio.addItem("2021");
		anio.setBounds(550, 270, 100, 22);
		panel2.add(anio);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(550, 100, 100, 22);
		panel2.add(btnRegistrar);
		
		// Evento Registrar
				ActionListener registrar = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						nombre_d = tfNombre.getText();
						direccion = tfDireccion.getText();
						telefono = Long.parseLong(tfTelefono.getText());
						correo = tfCorreo.getText();
						fecha_creacion =(String)
								anio.getSelectedItem() + "-" +
								mes.getSelectedItem() + "-" +
								dia.getSelectedItem();
						
				Disquera validar=new Disquera(nombre_d);
				validar.consultarIdDisquera();
				id_disquera = validar.getId_disquera();
				if(id_disquera==0) {
					Disquera registro=new Disquera(nombre_d, direccion, correo, fecha_creacion, telefono);
					registro.registrarDisquera();
					limpiarDatos();
				}else {
					JOptionPane.showMessageDialog(null, "El nombre de la disquera ya existe");
				}	
			}
				};
				// Activacion del evento registro
				btnRegistrar.addActionListener(registrar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(550, 130, 100, 22);
		panel2.add(btnEditar);
		
		// Evento modificar
		ActionListener modificar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		// Activacion del evento modificar
		btnEditar.addActionListener(modificar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(550, 160, 100, 22);
		panel2.add(btnConsultar);
		// Evento consultar
				ActionListener consultar = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					nombre_d = JOptionPane.showInputDialog("Ingresa el nombre de la disquera");
					Disquera consulta=new Disquera(nombre_d);
					consulta.consultarIdDisquera();
					id_disquera = consulta.getId_disquera();
					if(id_disquera==0) {
						JOptionPane.showMessageDialog(null, "Disquera no encontrada");
					}else {
						consulta.consultarDisquera();
						tfNombre.setText(consulta.getNombre_d());
						tfDireccion.setText(consulta.getDireccion());
						telefono = consulta.getTelefono();
						String aux = String.valueOf(telefono);
						tfTelefono.setText(aux);
						tfCorreo.setText(consulta.getCorreo());
						//Agregar fecha
					}
					}
				};
				// Activacion del evento modificar
				btnConsultar.addActionListener(consultar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(550, 190, 100, 22);
		panel2.add(btnEliminar);
		// Evento eliminar
				ActionListener eliminar = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				};
				// Activacion del evento eliminar
				btnEliminar.addActionListener(eliminar);

	}
	
	public void limpiarDatos() {
		tfNombre.setText("");
		tfDireccion.setText("");
		tfTelefono.setText("");
		tfCorreo.setText("");
	}
	
}
