package froms;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Artista extends JFrame {

	static JPanel panel1 = new JPanel();

	public Artista() {
		panel1.setLayout(null);
//imagen
		JLabel lbl0 = new JLabel();
		lbl0.setIcon(new ImageIcon("src/froms/img.png"));
		lbl0.setBounds(10, 10, 450, 500);
		panel1.add(lbl0);
//Titulo		
		Font fuente = new Font("Arial", 0, 20);
		JLabel lblT = new JLabel("SECCIÓN DE ARTISTAS ");
		lblT.setFont(fuente);
		lblT.setBounds(250, 30, 348, 20);
		panel1.add(lblT);
// una etiqueta en el panel de la pestaña 1
		JLabel lbl1 = new JLabel("Nombre: ");
		lbl1.setBounds(250, 100, 348, 20);
		panel1.add(lbl1);

		JTextField tf1 = new JTextField("");
		tf1.setBounds(380, 100, 150, 22);
		panel1.add(tf1);

		JLabel lbl2 = new JLabel("Apellidos:");
		lbl2.setBounds(250, 130, 348, 20);
		panel1.add(lbl2);

		JTextField tf2 = new JTextField("");
		tf2.setBounds(380, 130, 150, 22);
		panel1.add(tf2);

		JLabel lbl3 = new JLabel("Nombre artistico: ");
		lbl3.setBounds(250, 160, 348, 20);
		panel1.add(lbl3);

		JTextField tf3 = new JTextField("");
		tf3.setBounds(380, 160, 150, 22);
		panel1.add(tf3);

		JLabel lbl4 = new JLabel("Fecha de nacimiento: ");
		lbl4.setBounds(250, 190, 348, 20);
		panel1.add(lbl4);

		JTextField tf4 = new JTextField("");
		tf4.setBounds(380, 190, 150, 22);
		panel1.add(tf4);

		JLabel lbl5 = new JLabel("Nacionalidad: ");
		lbl5.setBounds(250, 220, 348, 20);
		panel1.add(lbl5);

		JComboBox combo = new JComboBox();
		combo.addItem("Seleccionar");
		combo.addItem("uno");
		combo.addItem("dos");
		combo.addItem("tres");
		combo.setBounds(380, 220, 150, 22);
		panel1.add(combo);

		JButton btn1 = new JButton("Registrar");
		btn1.setBounds(550, 130, 100, 22);
		panel1.add(btn1);

		JButton btn2 = new JButton("Editar");
		btn2.setBounds(550, 160, 100, 22);
		panel1.add(btn2);

		JButton btn3 = new JButton("Consultar");
		btn3.setBounds(550, 190, 100, 22);
		panel1.add(btn3);

		JButton btn4 = new JButton("Eliminar");
		btn4.setBounds(550, 220, 100, 22);
		panel1.add(btn4);

	}
}
