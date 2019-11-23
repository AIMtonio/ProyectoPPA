
package dataBase;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private Connection con;
    
    private String usuario;
    private String password;
    private String url;
    private String nombreBD;

    public Conexion() {
        url="jdbc:mysql://localhost/miztonp";
        usuario="root";
        password="";
    }

    public Conexion(String usuario, String password, String url, String nombreBD) {
        this.usuario = usuario;
        this.password = password;
        this.url = url;
        this.nombreBD = nombreBD;
        
    }

    public Connection getCon() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,usuario,password);
            return con;
        }catch(Exception e){
            //Imprime una traza de error, Nos dice donde esta el error, Pero ya esta descontinuado
            e.printStackTrace();
        }
        return con;   
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombreBD() {
        return nombreBD;
    }

    public void setNombreBD(String nombreBD) {
        this.nombreBD = nombreBD;
    }
    
}

