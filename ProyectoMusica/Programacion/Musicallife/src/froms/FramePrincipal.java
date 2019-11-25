package froms;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FramePrincipal extends JFrame{
	protected JPanel contentPane;
	Font fuente = new Font("Arial", 0, 20);
	Facade objeto= new Facade();
	
	public FramePrincipal() {
		// título de la ventana
		setTitle("MusicalLife");
// operación al cerra la ventana 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// coordenadas de las esquinas del frame en el escritorio
		setBounds(300, 100, 719, 534);

// el panel que contiene todo se crea y se pone en el frame
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
// distribución nula para poder posicionar los elementos
// en las coordenadas que queramos
		contentPane.setLayout(null);

		JLabel lbl13 = new JLabel("Bienvenidos a MusicaLife");
		lbl13.setBounds(270, 100, 348, 20);
		contentPane.add(lbl13);

		JLabel lbl1 = new JLabel("Da click en el boton para poder hacer diferentes funciones");
		lbl1.setBounds(170, 140, 348, 20);
		contentPane.add(lbl1);

		JButton btnRegistrar = new JButton("Iniciar");
		btnRegistrar.setBounds(270, 180, 100, 50);
		contentPane.add(btnRegistrar);

		ActionListener edit = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				objeto.setVisible(true);
				frame.setVisible(false);
			}
		};
		// Activacion del evento edit
		btnRegistrar.addActionListener(edit);

	}
	static FramePrincipal frame = new FramePrincipal();
	public static void main(String[] args) {

	    try {
	     // creando el frame y lo muestra
	    	
	     frame.setVisible(true);
	    } catch (Exception e) {
	     e.printStackTrace();
	    
	   }
	  }
	
}
