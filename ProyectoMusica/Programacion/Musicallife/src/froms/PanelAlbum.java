package froms;

/**
 * PanelAlbum que se ejecuta en la clase facade 
 * 
 * @author Liz Jimenez & Antonio Alonso 
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Album;
import clases.ClienteObservador;
import clases.ObservadorBase;
import conexion.ConexionPostgresSingleton;
import interfaces.Observador;
import interfaces.SujetoObservable;

public class PanelAlbum {
	static JPanel panel3 = new JPanel();

	/**
	 * Componentes que incluye el panel
	 */
	JTextField tfNombreAlbum = new JTextField("");
	JComboBox artistas = new JComboBox();
	JComboBox disq = new JComboBox();
	JTextField tfGenero = new JTextField("");
	JTextField tfDuracion = new JTextField("");
	Connection conn = ConexionPostgresSingleton.getConnection();

	// Variables
	int id_album, id_art, id_dis;
	String genero;
	Float duracion;
	String fecha_lanza;
	String nombre_album, nombre_artista, nombre_disquera;

	/**
	 * Constructor que inicaliza los elementos
	 */
	public PanelAlbum() {

		Font fuente = new Font("Arial", 0, 20);
		// Color de BG del Jpanel
		Color c = new Color(183, 248, 109);
		panel3.setBackground(c);

		llenarArtista();
		llenarDisquera();

		panel3.setLayout(null);

		// imagen
		JLabel lbl12 = new JLabel();
		lbl12.setIcon(new ImageIcon("src/img/album.png"));
		lbl12.setBounds(10, 10, 450, 500);
		panel3.add(lbl12);

		// Titulo
		JLabel lblSeccionAlbum = new JLabel();
		lblSeccionAlbum.setIcon(new ImageIcon("src/img/secciondealbums.png"));
		lblSeccionAlbum.setBounds(150, 30, 648, 50);
		panel3.add(lblSeccionAlbum);
		// una etiqueta en el panel de la pesta�a 1

		// Album
		JLabel lbl13 = new JLabel("Nombre del �lbum: ");
		lbl13.setBounds(250, 100, 348, 20);
		panel3.add(lbl13);
		tfNombreAlbum.setBounds(380, 100, 150, 22);
		panel3.add(tfNombreAlbum);

		// Artista
		JLabel lbl15 = new JLabel("Artista: ");
		lbl15.setBounds(250, 130, 348, 20);
		panel3.add(lbl15);
		// artistas.addItem("Seleccionar");
		artistas.setBounds(380, 130, 100, 22);
		panel3.add(artistas);

		// Disquera
		JLabel lbl16 = new JLabel("Disquera: ");
		lbl16.setBounds(250, 160, 348, 20);
		panel3.add(lbl16);
		// disq.addItem("Seleccionar");
		disq.setBounds(380, 160, 100, 22);
		panel3.add(disq);

		// Genero
		JLabel lbl14 = new JLabel("G�nero: ");
		lbl14.setBounds(250, 190, 348, 20);
		panel3.add(lbl14);
		tfGenero.setBounds(380, 190, 150, 22);
		panel3.add(tfGenero);

		// Duracion
		JLabel lbl17 = new JLabel("Duracion: ");
		lbl17.setBounds(250, 220, 348, 20);
		panel3.add(lbl17);
		tfDuracion.setBounds(380, 220, 150, 22);
		panel3.add(tfDuracion);

		// Boton registrar
		JButton btnRegistrar = new JButton();
		btnRegistrar.setBounds(250, 330, 50, 50);
		ImageIcon iconRegistro = new ImageIcon("src/img/add.png");
		btnRegistrar.setIcon(iconRegistro);
		panel3.add(btnRegistrar);
		// Evento registrar
		ActionListener registrar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tfNombreAlbum.getText().equalsIgnoreCase("") || tfGenero.getText().equalsIgnoreCase("")
						|| tfDuracion.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Falta algun dato por ingresar");
				} else {
					nombre_artista = (String) artistas.getSelectedItem();
					nombre_disquera = (String) disq.getSelectedItem();
					Album buscarDatos = new Album(nombre_artista, nombre_disquera);
					buscarDatos.consultarIdArtista();
					buscarDatos.consultarIdDisquera();
					id_art = buscarDatos.getId_art();
					id_dis = buscarDatos.getId_dis();
					// Asigar datos
					nombre_album = tfNombreAlbum.getText();
					genero = tfGenero.getText();
					duracion = Float.parseFloat(tfDuracion.getText());
					Album registro = new Album(id_art, id_dis, genero, duracion, nombre_album);
					registro.registro();
					limpiarCombos();
					limparDatos();

					java.util.Date fecha = new Date();

					ObservadorBase patron = new ObservadorBase();

					ClienteObservador x = new ClienteObservador("Registro album", fecha.toString());

					x.enlazarObservador(patron);

					x.despertador();

					llenarArtista();
					llenarDisquera();
				}
			}
		};
		// Activacion del evento registro
		btnRegistrar.addActionListener(registrar);

		// Boton consultar
		JButton btnConsultar = new JButton();
		btnConsultar.setBounds(330, 330, 50, 50);
		ImageIcon iconConsulta = new ImageIcon("src/img/consulta.png");
		btnConsultar.setIcon(iconConsulta);
		panel3.add(btnConsultar);
		// Evento consultar
		ActionListener consultar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nombre_album = JOptionPane.showInputDialog("Ingresa el album a buscar");
				Album consultar = new Album(nombre_album);
				consultar.consultarIdAlbum();
				id_album = consultar.getId_album();
				if (id_album == 0) {
					JOptionPane.showMessageDialog(null, "El album no existe");
				} else {
					consultar.consultarAlbum();
					nombre_album = consultar.getNombre_album();
					duracion = consultar.getDuracion();
					genero = consultar.getGenero();
					fecha_lanza = consultar.getFecha_lanza();

					// mostrar nombre artista y disquera
					id_art = consultar.getId_art();
					id_dis = consultar.getId_dis();
					consultar.consulta(id_art);
					consultar.consultarNombreDisquera(id_dis);
					nombre_artista = consultar.getNombre_artista();
					nombre_disquera = consultar.getNombre_disquera();

					tfNombreAlbum.setText(nombre_album);
					// tfDuracion.setText(Float.toString(duracion));
					tfGenero.setText(genero);
					artistas.removeAllItems();
					disq.removeAllItems();
					artistas.addItem(nombre_artista);
					disq.addItem(nombre_disquera);
					JOptionPane.showMessageDialog(null, "La fecha de creacion de este album es : " + fecha_lanza);
				}
			}
		};
		// Activacion del evento consultar
		btnConsultar.addActionListener(consultar);

		// Boton eliminar
		JButton btnEliminar = new JButton();
		btnEliminar.setBounds(410, 330, 50, 50);
		ImageIcon iconEliminar = new ImageIcon("src/img/eliminar.png");
		btnEliminar.setIcon(iconEliminar);
		panel3.add(btnEliminar);
		// Evento registrar
		ActionListener eliminar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tfNombreAlbum.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Consulta para poder eliminar");
				} else {
					int v = JOptionPane.showConfirmDialog(null, "Deseas eliminar este album?");
					if (v == 0) {
						if (id_album == 0) {
							JOptionPane.showMessageDialog(null, "El artista no existe");
						} else {
							nombre_album = tfNombreAlbum.getText();
							Album eliminar = new Album(nombre_album);
							eliminar.consultarIdAlbum();
							id_album = eliminar.getId_album();
							eliminar.elimina();
							limparDatos();
						}
					} else {
					}
				}
			}
		};
		// Activacion del evento registro
		btnEliminar.addActionListener(eliminar);

		// Boton modificar
		JButton btnEditar = new JButton();
		btnEditar.setBounds(490, 330, 50, 50);
		ImageIcon iconEditar = new ImageIcon("src/img/edit.png");
		btnEditar.setIcon(iconEditar);
		panel3.add(btnEditar);

		// Evento modificar
		ActionListener edit = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "No aplica porque un album no se puede modificar una vez creado");
			}
		};
		// Activacion del evento edit
		btnEditar.addActionListener(edit);

		KeyAdapter objeto = new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				char car = evt.getKeyChar();
				if (Character.isDigit(car)) {
					evt.consume();
					ImageIcon icon = new ImageIcon("src/img/letras.png");
					JOptionPane.showMessageDialog(null, "Solo se permite ingresar letras", "Advertencia",
							JOptionPane.PLAIN_MESSAGE, icon);
				}
			}
		};
		tfNombreAlbum.addKeyListener(objeto);
		tfGenero.addKeyListener(objeto);

		KeyAdapter objeto2 = new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				char car = evt.getKeyChar();
				if (Character.isLetter(car)) {
					// getToolkit().beep();;
					evt.consume();
					ImageIcon icon = new ImageIcon("src/img/numeros.png");
					JOptionPane.showMessageDialog(null, "Solo se permite ingresar numeros", "Advertencia",
							JOptionPane.PLAIN_MESSAGE, icon);
				}
			}
		};
		tfDuracion.addKeyListener(objeto2);
	}

	/**
	 * Metodo para limpiar los combos
	 */
	public void limpiarCombos() {
		artistas.removeAllItems();
		disq.removeAllItems();
		artistas.addItem("Seleccionar");
		disq.addItem("Seleccionar");
	}

	/**
	 * Metodo para limpiar el Panel
	 */
	public void limparDatos() {
		tfNombreAlbum.setText("");
		tfGenero.setText("");
		tfDuracion.setText("");
	}

	/**
	 * Metodo para llenar el artista
	 */
	public void llenarArtista() {
		artistas.removeAllItems();
		artistas.addItem("Seleccionar");
		try {
			Statement st = conn.createStatement();
			String sql = "select artista.nombre_artistico from artista;";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				artistas.addItem(rs.getString(1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Metodo para llenar el combo disquera
	 */
	public void llenarDisquera() {
		disq.removeAllItems();
		disq.addItem("Seleccionar");
		try {
			Statement st = conn.createStatement();
			String sql = "select disquera.nombre from disquera;";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				disq.addItem(rs.getString(1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
