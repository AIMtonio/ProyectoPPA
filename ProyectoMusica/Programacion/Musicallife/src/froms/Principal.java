package froms;

/**
 *Frame Pincipal, que contiene todos los paneles
 *
 *@author Liz Jimenez & Antonio Alonso
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

	protected JPanel contentPane;

	/**
	 * Constructor que inicializa el Frame, lo abre y contiene los paneles
	 */
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

//Agregamos panel Artista a Frame
		PanelArtista artista = new PanelArtista();
		panelDePestanas.addTab("Artistas", null, PanelArtista.panel1, null);
// Agregamos panel disquera a Frame
		PanelDisquera disq = new PanelDisquera();
		panelDePestanas.addTab("Disqueras", null, PanelDisquera.panel2, null);
// Agregamos panel Album a Frame
		PanelAlbum obj1 = new PanelAlbum();
		panelDePestanas.addTab("Álbums", null, PanelAlbum.panel3, null);
// Agregamos panel Reportes a Frame
		PanelReportes obj = new PanelReportes();
		panelDePestanas.addTab("Reportes", null, PanelReportes.panel4, null);

	}
	
	public static void main(String[] args) {

	    try {
	     // creando el frame y lo muestra
	     Principal frame = new Principal();
	     frame.setVisible(true);
	    } catch (Exception e) {
	     e.printStackTrace();
	    
	   }
	  }
}
