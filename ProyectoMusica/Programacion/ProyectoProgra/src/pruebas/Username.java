package pruebas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Username extends JFrame{
    JPanel panel= new JPanel();
    JLabel label1 = new JLabel("Ingresar Usuario ");
    JTextField texto = new JTextField(10);
    JLabel label2 = new JLabel("Ingresar Password");
    JTextField texto2 = new JTextField(10);
    JButton miboton = new JButton("Aceptar");
    String user = texto.getText();
    String password = texto2.getText();    
    String a;
    public void mypanel(){
        //panel.add(panel);
        panel.add(label1);
        panel.add(texto);
        panel.add(label2);
        panel.add(texto2);
        panel.add(miboton);
        add(panel);
        super.setTitle("USUARIO");
        super.setVisible(true);
        super.setSize(300, 140);
        ActionListener listener = new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                
                validarUsuario();
            }
            
        };
        //miboton = new JButton();
        miboton.addActionListener(listener); 
        texto.setText("login");
        //user=texto.getText();
        texto2.setText("password");
        //user=texto.getText();
    }
    
    
    public static void main(String[] args) {
        Username obj=new Username();
        obj.mypanel();
            
    
    }
    
    
    
    public void validarUsuario(){
        if (texto.getText().equals("admin")&& texto2.getText().equals("1234")){
            JOptionPane.showMessageDialog(null, "OK");}
        else{
            JOptionPane.showMessageDialog(null, "El username o password no es correcto");
        }
        
    }

}