package froms;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
		
		JLabel lbl13 = new JLabel();
		lbl13.setIcon(new ImageIcon("src/img/msg.png"));
		lbl13.setBounds(50, 10, 648, 60);
		contentPane.add(lbl13);

		JLabel lbl1 = new JLabel();
		lbl1.setIcon(new ImageIcon("src/img/logo1.png"));
		lbl1.setBounds(10, 300, 348, 220);
		contentPane.add(lbl1);

		JButton btnRegistrar = new JButton();
		btnRegistrar.setBounds(270, 180, 180, 50);
		ImageIcon iconRegistro=new ImageIcon("src/img/iniciar.png");
		btnRegistrar.setIcon(iconRegistro);
		contentPane.add(btnRegistrar);
		
		JLabel bg = new JLabel();
		bg.setIcon(new ImageIcon("src/img/BG.png"));
		bg.setBounds(0, 0, 706, 495);
		contentPane.add(bg);

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
	  }//end Main
	
	
	 
	 
	  
	
}
