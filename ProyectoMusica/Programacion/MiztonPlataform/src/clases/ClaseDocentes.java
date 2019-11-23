
package clases;
import dataBase.Conexion;
import java.sql.CallableStatement;

public class ClaseDocentes {
    
    int id_docentes;
    String nombreD,apellidosD,curpD,usuarioD,contraseñaD,materia,tipo;

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
    
    

    public ClaseDocentes(int id_docentes, String nombreD, String apellidosD, String curpD, String usuarioD, String contraseñaD,String materia, String tipo) {
        this.id_docentes = id_docentes;
        this.nombreD = nombreD;
        this.apellidosD = apellidosD;
        this.curpD = curpD;
        this.usuarioD = usuarioD;
        this.contraseñaD = contraseñaD;
        this.materia=materia;
        this.tipo = tipo;
    }

    public ClaseDocentes(String nombreD, String apellidosD, String curpD, String usuarioD, String contraseñaD,String materia, String tipo) {
        this.nombreD = nombreD;
        this.apellidosD = apellidosD;
        this.curpD = curpD;
        this.usuarioD = usuarioD;
        this.contraseñaD = contraseñaD;
        this.contraseñaD = contraseñaD;
        this.tipo = tipo;
    }

    public ClaseDocentes() {
    }
    
     public void insertarDocentes(){
       try{
            final String sql= "{call seleccionar(?,?,?,?,?,?,?,?)}";//Sintaxis
            Conexion objConexion=new Conexion();//Crea conexion
            CallableStatement cs= objConexion.getCon().prepareCall(sql);//Accede al procedimiento
            //Envia valores
            //cs.setInt(1,empleadosId);
            cs.setString(1,nombreD);
            cs.setString(2,apellidosD);
            cs.setString(3,curpD);
            cs.setString(4,usuarioD);
            cs.setString(5,contraseñaD);
            cs.setString(6,null);
            cs.setString(7,materia);
            cs.setString(8,tipo);
            cs.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }        
    }
     
  
    public int getId_docentes() {
        return id_docentes;
    }

    public void setId_docentes(int id_docentes) {
        this.id_docentes = id_docentes;
    }

    public String getNombreD() {
        return nombreD;
    }

    public void setNombreD(String nombreD) {
        this.nombreD = nombreD;
    }

    public String getApellidosD() {
        return apellidosD;
    }

    public void setApellidosD(String apellidosD) {
        this.apellidosD = apellidosD;
    }

    public String getCurpD() {
        return curpD;
    }

    public void setCurpD(String curpD) {
        this.curpD = curpD;
    }

    public String getUsuarioD() {
        return usuarioD;
    }

    public void setUsuarioD(String usuarioD) {
        this.usuarioD = usuarioD;
    }

    public String getContraseñaD() {
        return contraseñaD;
    }

    public void setContraseñaD(String contraseñaD) {
        this.contraseñaD = contraseñaD;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
