package froms;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Disquera {
	static JPanel panel2 = new JPanel();
	public Disquera() {
		Font fuente = new Font("Arial", 0, 20);
		panel2.setLayout(null);

		// imagen
		JLabel lbl6 = new JLabel();
		lbl6.setIcon(new ImageIcon("src/froms/img.png"));
		lbl6.setBounds(10, 10, 450, 500);
		panel2.add(lbl6);
		// Titulo
		JLabel lblT2 = new JLabel("SECCIÓN DE DISQUERAS ");
		lblT2.setFont(fuente);
		lblT2.setBounds(250, 30, 348, 20);
		panel2.add(lblT2);
		// una etiqueta en el panel de la pestaña 1
		JLabel lbl7 = new JLabel("Nombre Disquera: ");
		lbl7.setBounds(250, 100, 348, 20);
		panel2.add(lbl7);

		JTextField tf7 = new JTextField("");
		tf7.setBounds(380, 100, 150, 22);
		panel2.add(tf7);

		JLabel lbl8 = new JLabel("Dirección: ");
		lbl8.setBounds(250, 130, 348, 20);
		panel2.add(lbl8);

		JTextField tf8 = new JTextField("");
		tf8.setBounds(380, 130, 150, 22);
		panel2.add(tf8);

		JLabel lbl9 = new JLabel("Teléfono: ");
		lbl9.setBounds(250, 160, 348, 20);
		panel2.add(lbl9);

		JTextField tf9 = new JTextField("");
		tf9.setBounds(380, 160, 150, 22);
		panel2.add(tf9);

		JLabel lbl10 = new JLabel("Correo: ");
		lbl10.setBounds(250, 190, 348, 20);
		panel2.add(lbl10);

		JTextField tf10 = new JTextField("");
		tf10.setBounds(380, 190, 150, 22);
		panel2.add(tf10);

		JLabel lbl11 = new JLabel("Fecha de creación: ");
		lbl11.setBounds(250, 220, 348, 20);
		panel2.add(lbl11);

		JLabel lbld = new JLabel("Día: ");
		lbld.setBounds(250, 250, 348, 20);
		panel2.add(lbld);

		JComboBox dia = new JComboBox();
		dia.addItem("Seleccionar");
		dia.addItem("1");
		dia.addItem("2");
		dia.addItem("3");
		dia.setBounds(250, 270, 100, 22);
		panel2.add(dia);

		JLabel lblm = new JLabel("Mes: ");
		lblm.setBounds(400, 250, 348, 20);
		panel2.add(lblm);

		JComboBox mes = new JComboBox();
		mes.addItem("Seleccionar");
		mes.addItem("01");
		mes.addItem("02");
		mes.addItem("03");
		mes.setBounds(400, 270, 100, 22);
		panel2.add(mes);

		JLabel lbla = new JLabel("Año: ");
		lbla.setBounds(550, 250, 348, 20);
		panel2.add(lbla);

		JComboBox anio = new JComboBox();
		anio.addItem("Seleccionar");
		anio.addItem("2019");
		anio.addItem("2020");
		anio.addItem("2021");
		anio.setBounds(550, 270, 100, 22);
		panel2.add(anio);

		JButton btn5 = new JButton("Registrar");
		btn5.setBounds(550, 100, 100, 22);
		panel2.add(btn5);

		JButton btn6 = new JButton("Editar");
		btn6.setBounds(550, 130, 100, 22);
		panel2.add(btn6);

		JButton btn7 = new JButton("Consultar");
		btn7.setBounds(550, 160, 100, 22);
		panel2.add(btn7);

		JButton btn8 = new JButton("Eliminar");
		btn8.setBounds(550, 190, 100, 22);
		panel2.add(btn8);

	}
}
