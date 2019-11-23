
package test;
import froms.*;
import sockets.*;


public class Prueba {
    
    public static void main(String[] args) {
//        Docentes doc=new Docentes();
//         doc.setVisible(true);
//        Alumnos al=new Alumnos();
//        al.setVisible(true);
    chat_client cl=new chat_client();
    cl.setVisible(true);
    chat_server sv=new chat_server();
    sv.setVisible(true);
    }
    
}
