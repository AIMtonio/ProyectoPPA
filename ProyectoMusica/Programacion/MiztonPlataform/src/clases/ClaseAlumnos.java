
package clases;

import dataBase.Conexion;
import java.sql.CallableStatement;

public class ClaseAlumnos {
    
    int id_alumno;
    String nombreA,apellidosA,curpA,nombreUsuarioA,contraseñaA;
    int id_grupo;
    String tipo;

    public ClaseAlumnos(int id_alumno, String nombreA, String apellidosA, String curpA, String nombreUsuarioA, String contraseñaA, int id_grupo, String tipo) {
        this.id_alumno = id_alumno;
        this.nombreA = nombreA;
        this.apellidosA = apellidosA;
        this.curpA = curpA;
        this.nombreUsuarioA = nombreUsuarioA;
        this.contraseñaA = contraseñaA;
        this.id_grupo = id_grupo;
        this.tipo = tipo;
    }

    public ClaseAlumnos() {
    }

    public ClaseAlumnos(String nombreA, String apellidosA, String curpA, String nombreUsuarioA, String contraseñaA, int id_grupo, String tipo) {
        this.nombreA = nombreA;
        this.apellidosA = apellidosA;
        this.curpA = curpA;
        this.nombreUsuarioA = nombreUsuarioA;
        this.contraseñaA = contraseñaA;
        this.id_grupo = id_grupo;
        this.tipo = tipo;
    }
    
    
       public void insertarAlmunos(){
       try{
            final String sql= "{call seleccionar(?,?,?,?,?,?,?,?)}";//Sintaxis
            Conexion objConexion=new Conexion();//Crea conexion
            CallableStatement cs= objConexion.getCon().prepareCall(sql);//Accede al procedimiento
            cs.setString(1,nombreA);
            cs.setString(2,apellidosA);
            cs.setString(3,curpA);
            cs.setString(4,nombreUsuarioA);
            cs.setString(5,contraseñaA);
            cs.setInt(6,id_grupo);
            cs.setString(7,null);
            cs.setString(8,tipo);
            cs.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }        
    }
    

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }

    public String getApellidosA() {
        return apellidosA;
    }

    public void setApellidosA(String apellidosA) {
        this.apellidosA = apellidosA;
    }

    public String getCurpA() {
        return curpA;
    }

    public void setCurpA(String curpA) {
        this.curpA = curpA;
    }

    public String getNombreUsuarioA() {
        return nombreUsuarioA;
    }

    public void setNombreUsuarioA(String nombreUsuarioA) {
        this.nombreUsuarioA = nombreUsuarioA;
    }

    public String getContraseñaA() {
        return contraseñaA;
    }

    public void setContraseñaA(String contraseñaA) {
        this.contraseñaA = contraseñaA;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
}
