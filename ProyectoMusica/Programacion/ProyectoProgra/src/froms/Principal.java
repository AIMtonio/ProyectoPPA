package froms;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

	protected JPanel contentPane;

	public Principal() {

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

// se crea el panel de pestañas
		JTabbedPane panelDePestanas = new JTabbedPane(SwingConstants.TOP);
// se posiciona en el panel
		panelDePestanas.setBounds(10, 11, 679, 464);
		contentPane.add(panelDePestanas);
		
//Agregamos paneles a Frame
		PanelArtista artista = new PanelArtista();
		panelDePestanas.addTab("Artistas", null, PanelArtista.panel1, null);

		PanelDisquera disq = new PanelDisquera();
		panelDePestanas.addTab("Disqueras", null, PanelDisquera.panel2, null);

		PanelAlbum obj1 = new PanelAlbum();
		panelDePestanas.addTab("Álbums", null, PanelAlbum.panel3, null);

		Reportes obj = new Reportes();
		panelDePestanas.addTab("Reportes", null, Reportes.panel4, null);

	}
}
