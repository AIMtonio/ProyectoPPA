package froms;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Artista extends JFrame {

	protected JPanel contentPane;

// Constructor de la clase: se configura aquí toda 
// la ventana y los controles...
	public Artista() {

// título de la ventana
		setTitle("Proyecto A");
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

// se crea el panel de pestañas
		JTabbedPane panelDePestanas = new JTabbedPane(JTabbedPane.TOP);
// se posiciona en el panel
		panelDePestanas.setBounds(10, 11, 679, 464);
		contentPane.add(panelDePestanas);
		
//*************************************************************************
// éste es el primer panel
// que se añade como pestaña al 'tabbedPane'
		JPanel panel1 = new JPanel();
		panelDePestanas.addTab("Artista", null, panel1, null);
// al panel le pongo distribución nula para
// posicionar los elementos en las coordenadas que
// quiera
		panel1.setLayout(null);
//imagen
		JLabel lbl0 = new JLabel();
		lbl0.setIcon(new ImageIcon("src/froms/img.png"));
		lbl0.setBounds(10, 10, 450, 500);
		panel1.add(lbl0);
		
// una etiqueta en el panel de la pestaña 1
		JLabel lbl1 = new JLabel("Nombre: ");
		lbl1.setBounds(250, 41, 348, 20);
		panel1.add(lbl1);
		
		JTextField tf1=new JTextField("");
		tf1.setBounds(380, 41, 150, 22);
		panel1.add(tf1);
		
		JLabel lbl2 = new JLabel("Apellidos: ");
		lbl2.setBounds(250, 70, 348, 20);
		panel1.add(lbl2);
		
		JTextField tf2=new JTextField("");
		tf2.setBounds(380, 70, 150, 22);
		panel1.add(tf2);
		
		JLabel lbl3 = new JLabel("Nombre artistico: ");
		lbl3.setBounds(250, 100, 348, 20);
		panel1.add(lbl3);
		
		JTextField tf3=new JTextField("");
		tf3.setBounds(380, 100, 150, 22);
		panel1.add(tf3);
		
		JLabel lbl4 = new JLabel("Fecha de nacimiento: ");
		lbl4.setBounds(250, 130, 348, 20);
		panel1.add(lbl4);
		
		JTextField tf4=new JTextField("");
		tf4.setBounds(380, 130, 150, 22);
		panel1.add(tf4);
		
		JLabel lbl5 = new JLabel("Nacionalidad: ");
		lbl5.setBounds(250, 160, 348, 20);
		panel1.add(lbl5);
		
		JComboBox combo = new JComboBox();
		combo.addItem("Seleccionar");
		combo.addItem("uno");
		combo.addItem("dos");
		combo.addItem("tres");
		combo.setBounds(380, 160, 150, 22);
		panel1.add(combo);
		
		JButton btn1= new JButton("Registrar");
		btn1.setBounds(550, 70, 100, 22);
		panel1.add(btn1);
		
		JButton btn2= new JButton("Editar");
		btn2.setBounds(550, 100, 100, 22);
		panel1.add(btn2);
		
		JButton btn3= new JButton("Consultar");
		btn3.setBounds(550, 130, 100, 22);
		panel1.add(btn3);
		
		JButton btn4= new JButton("Eliminar");
		btn4.setBounds(550, 160, 100, 22);
		panel1.add(btn4);
		
//*************************************************************************
// otro panel de igual forma
		JPanel panel2 = new JPanel();
		panelDePestanas.addTab("Disquera", null, panel2, null);
		panel2.setLayout(null);

// otra etiqueta ésta vez en el segundo panel
		JLabel lbl = new JLabel("Nombre Disquera");
		lbl.setBounds(10, 11, 290, 14);
		panel2.add(lbl);
		
	}
}
