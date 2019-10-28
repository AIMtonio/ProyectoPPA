package froms;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Album {
	static JPanel panel3 = new JPanel();
	
	public Album() {
		Font fuente = new Font("Arial", 0, 20);
		
		panel3.setLayout(null);

		// imagen
		JLabel lbl12 = new JLabel();
		lbl12.setIcon(new ImageIcon("src/froms/img.png"));
		lbl12.setBounds(10, 10, 450, 500);
		panel3.add(lbl12);

		// Titulo
		JLabel lblT3 = new JLabel("SECCIÓN DE ÁLBUMS ");
		lblT3.setFont(fuente);
		lblT3.setBounds(250, 30, 348, 20);
		panel3.add(lblT3);

		// una etiqueta en el panel de la pestaña 1
		JLabel lbl13 = new JLabel("Nombre del álbum: ");
		lbl13.setBounds(250, 100, 348, 20);
		panel3.add(lbl13);

		JTextField tf13 = new JTextField("");
		tf13.setBounds(380, 100, 150, 22);
		panel3.add(tf13);

		JLabel lbl15 = new JLabel("Artista: ");
		lbl15.setBounds(250, 130, 348, 20);
		panel3.add(lbl15);

		JComboBox artistas = new JComboBox();
		artistas.addItem("Seleccionar");
		artistas.setBounds(380, 130, 100, 22);
		panel3.add(artistas);

		JLabel lbl16 = new JLabel("Disquera: ");
		lbl16.setBounds(250, 160, 348, 20);
		panel3.add(lbl16);

		JComboBox disq = new JComboBox();
		disq.addItem("Seleccionar");
		disq.setBounds(380, 160, 100, 22);
		panel3.add(disq);
		
		JLabel lbl14 = new JLabel("Género: ");
		lbl14.setBounds(250, 190, 348, 20);
		panel3.add(lbl14);

		JTextField tf14 = new JTextField("");
		tf14.setBounds(380, 190, 150, 22);
		panel3.add(tf14);

		JLabel lbl17 = new JLabel("Duracion: ");
		lbl17.setBounds(250, 220, 348, 20);
		panel3.add(lbl17);

		JTextField tf17 = new JTextField("");
		tf17.setBounds(380, 220, 150, 22);
		panel3.add(tf17);

		JButton btn9 = new JButton("Registrar");
		btn9.setBounds(550, 100, 100, 22);
		panel3.add(btn9);

		JButton btn11 = new JButton("Consultar");
		btn11.setBounds(550, 130, 100, 22);
		panel3.add(btn11);

		JButton btn12 = new JButton("Eliminar");
		btn12.setBounds(550, 160, 100, 22);
		panel3.add(btn12);
	}
}
