package froms;

/**
 * Frame de reportes
 * 
 * @author Liz Jimenez & Antonio Alonso
 */
import java.awt.Font;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Reportes extends Frame {
	static JPanel panel4 = new JPanel();

	/**
	 * Constructor que inicializa el frame con sus atributos
	 */
	public Reportes() {
		Font fuente = new Font("Arial", 0, 20);
		panel4.setLayout(null);

		// imagen
		JLabel lbl19 = new JLabel();
		lbl19.setIcon(new ImageIcon("src/froms/img.png"));
		lbl19.setBounds(10, 10, 450, 500);
		panel4.add(lbl19);

		// Titulo
		JLabel lblT4 = new JLabel("SECCIÓN DE REPORTES ");
		lblT4.setFont(fuente);
		lblT4.setBounds(250, 30, 348, 20);
		panel4.add(lblT4);

		// una etiqueta en el panel de la pestaña 1
		JLabel lbl20 = new JLabel("Selecciona el tipo de reporte : ");
		lbl20.setBounds(250, 100, 348, 20);
		panel4.add(lbl20);

		JComboBox rep = new JComboBox();
		rep.addItem("Seleccionar");
		rep.addItem("Fecha de creación");
		rep.addItem("Artista");
		rep.addItem("Disquera");
		rep.setBounds(380, 130, 150, 22);
		panel4.add(rep);

		JLabel lbl21 = new JLabel("Nombre de busqueda: ");
		lbl21.setBounds(250, 180, 348, 20);
		panel4.add(lbl21);

		JTextField tf21 = new JTextField("");
		tf21.setBounds(380, 180, 150, 22);
		panel4.add(tf21);

		JButton btn13 = new JButton("Generar");
		btn13.setBounds(380, 230, 100, 22);
		panel4.add(btn13);
	}
}
