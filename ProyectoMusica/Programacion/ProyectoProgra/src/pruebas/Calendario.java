/**
* jcalendar.jar
 */
 
package pruebas;
 
import java.awt.FlowLayout;
import javax.swing.JFrame;
 
/**
 *
 * @author beastieux
 */
public class Calendario extends JFrame {
    public Calendario()
    {
      JCalendar calEjemplo1=new  JCalendar();
      JCalendarCombo calEjemplo2=new  JCalendarCombo();
 
      this.add(calEjemplo1);
      this.add(calEjemplo2);
      this.setLayout(new FlowLayout());
      this.setSize(400, 300);
 
      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
 
    public static void main(String args[]) {
        Calendario obj = new Calendario();
        obj.setVisible(true);
    }
}