package froms;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Album;
import conexion.ConexionPostgres;

public class PanelAlbum{
	static JPanel panel3 = new JPanel();
	
	//Componentes
	JTextField tfNombreAlbum = new JTextField("");
	JComboBox artistas = new JComboBox();
	JComboBox disq = new JComboBox();
	JTextField tfGenero = new JTextField("");
	JTextField tfDuracion = new JTextField("");
	
	//Variables
	int id_album, id_art, id_dis;
	String genero;
	Float duracion;
	String fecha_lanza;
	String nombre_album, nombre_artista, nombre_disquera;
	
	public PanelAlbum(){
		Font fuente = new Font("Arial", 0, 20);
		
		panel3.setLayout(null);

		// imagen
		JLabel lbl12 = new JLabel();
		lbl12.setIcon(new ImageIcon("src/img/img.png"));
		lbl12.setBounds(10, 10, 450, 500);
		panel3.add(lbl12);

		// Titulo
		JLabel lblT3 = new JLabel("SECCIÓN DE ÁLBUMS ");
		lblT3.setFont(fuente);
		lblT3.setBounds(250, 30, 348, 20);
		panel3.add(lblT3);
		// una etiqueta en el panel de la pestaña 1
		
		//Album
		JLabel lbl13 = new JLabel("Nombre del álbum: ");
		lbl13.setBounds(250, 100, 348, 20);
		panel3.add(lbl13);
		tfNombreAlbum.setBounds(380, 100, 150, 22);
		panel3.add(tfNombreAlbum);

		//Artista
		JLabel lbl15 = new JLabel("Artista: ");
		lbl15.setBounds(250, 130, 348, 20);
		panel3.add(lbl15);
		artistas.addItem("Seleccionar");
		artistas.setBounds(380, 130, 100, 22);
		panel3.add(artistas);
		//Boton actualizar artistas
		JButton btnActualizarArtistas = new JButton("...");
		btnActualizarArtistas.setBounds(490, 130, 40, 20);
		panel3.add(btnActualizarArtistas);
		// Evento llenar artista combo
				ActionListener llenarArtista = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						artistas.removeAllItems();
						try{
				            ConexionPostgres objConexion=new ConexionPostgres();//Crea conexion
				            Statement st=objConexion.getCon().createStatement();
							String sql="select artista.nombre_artistico from artista;";
							ResultSet rs=st.executeQuery(sql);
							while (rs.next()){
								artistas.addItem("Seleccionar");
								artistas.addItem(rs.getString(1));
							}
				        }catch(Exception ex){
				            ex.printStackTrace();
				        }        
					}
				};
				// Activacion del evento registro
				btnActualizarArtistas.addActionListener(llenarArtista);

		//Disquera
		JLabel lbl16 = new JLabel("Disquera: ");
		lbl16.setBounds(250, 160, 348, 20);
		panel3.add(lbl16);
		disq.addItem("Seleccionar");
		disq.setBounds(380, 160, 100, 22);
		panel3.add(disq);
		//Boton actualizar disquera
		JButton btnActualizarDisquera = new JButton("...");
		btnActualizarDisquera.setBounds(490, 160, 40, 20);
		panel3.add(btnActualizarDisquera);
		// Evento llenar artista combo
		ActionListener llenardisquera = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				disq.removeAllItems();
				try{
		            ConexionPostgres objConexion=new ConexionPostgres();//Crea conexion
		            Statement st=objConexion.getCon().createStatement();
					String sql="select disquera.nombre from disquera;";
					ResultSet rs=st.executeQuery(sql);
					while (rs.next()){
						disq.addItem("Seleccionar");
						disq.addItem(rs.getString(1));
					}
		        }catch(Exception ex){
		            ex.printStackTrace();
		        }        
			}
		};
		// Activacion del evento registro
		btnActualizarDisquera.addActionListener(llenardisquera);
		
		//Genero
		JLabel lbl14 = new JLabel("Género: ");
		lbl14.setBounds(250, 190, 348, 20);
		panel3.add(lbl14);
		tfGenero.setBounds(380, 190, 150, 22);
		panel3.add(tfGenero);

		//Duracion
		JLabel lbl17 = new JLabel("Duracion: ");
		lbl17.setBounds(250, 220, 348, 20);
		panel3.add(lbl17);
		tfDuracion.setBounds(380, 220, 150, 22);
		panel3.add(tfDuracion);

		//Boton registrar
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(550, 100, 100, 22);
		panel3.add(btnRegistrar);
		// Evento registrar
				ActionListener registrar = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(tfNombreAlbum.getText().equalsIgnoreCase("") || 
						   tfGenero.getText().equalsIgnoreCase("") || 
						   tfDuracion.getText().equalsIgnoreCase("")) {
							JOptionPane.showMessageDialog(null, "Falta algun dato por ingresar");
						}else {
							nombre_artista = (String) artistas.getSelectedItem();
							nombre_disquera = (String) disq.getSelectedItem();
							Album buscarDatos=new Album(nombre_artista, nombre_disquera);
							buscarDatos.consultarIdArtista();
							buscarDatos.consultarIdDisquera();
							id_art = buscarDatos.getId_art();
							id_dis = buscarDatos.getId_dis();
							//Asigar datos
							nombre_album = tfNombreAlbum.getText();
							genero = tfGenero.getText();
							duracion=Float.parseFloat(tfDuracion.getText());
						Album registro=new Album(id_art, id_dis, genero, duracion, nombre_album);
						registro.registrarAlbum();
						limpiarCombos();
						limparDatos();
						}
					}
				};
				// Activacion del evento registro
				btnRegistrar.addActionListener(registrar);

		//Boton consultar
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(550, 130, 100, 22);
		panel3.add(btnConsultar);
		// Evento consultar
		ActionListener consultar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nombre_album = JOptionPane.showInputDialog("Ingresa el album a buscar");
				Album consultar=new Album(nombre_album);
				consultar.consultarIdAlbum();
				id_album=consultar.getId_album();
				if(id_album==0) {
					JOptionPane.showMessageDialog(null, "El album no existe");
				}else {
					consultar.consultarAlbum();
					nombre_album=consultar.getNombre_album();
					duracion = consultar.getDuracion();
					genero = consultar.getGenero();
					fecha_lanza = consultar.getFecha_lanza();
					
					//mostrar nombre artista y disquera
					id_art = consultar.getId_art();
					id_dis = consultar.getId_dis();
					consultar.consultarNombreArtista(id_art);
					consultar.consultarNombreDisquera(id_dis);
					nombre_artista = consultar.getNombre_artista();
					nombre_disquera = consultar.getNombre_disquera();
					
					tfNombreAlbum.setText(nombre_album);
					//tfDuracion.setText(Float.toString(duracion));
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

		//Boton eliminar
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(550, 160, 100, 22);
		panel3.add(btnEliminar);
		// Evento registrar
		ActionListener eliminar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfNombreAlbum.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Consulta para poder eliminar");
				}else {
					int v = JOptionPane.showConfirmDialog(null, "Deseas eliminar este album?");
					if (v == 0) {
						if (id_album == 0) {
							JOptionPane.showMessageDialog(null, "El artista no existe");
						} else {
							nombre_album = tfNombreAlbum.getText();
							Album eliminar = new Album(nombre_album);
							eliminar.consultarIdAlbum();
							id_album = eliminar.getId_album();
							eliminar.eliminarAlbum();
							limparDatos();
						}
					} else {
					}
				}
			}
		};
		// Activacion del evento registro
		btnEliminar.addActionListener(eliminar);
	}
	
	public void limpiarCombos() {
		artistas.removeAllItems();
		disq.removeAllItems();
		artistas.addItem("Seleccionar");
		disq.addItem("Seleccionar");
	}
	
	public void limparDatos() {
		tfNombreAlbum.setText("");
		tfGenero.setText("");
		tfDuracion.setText("");
	}
	
}
