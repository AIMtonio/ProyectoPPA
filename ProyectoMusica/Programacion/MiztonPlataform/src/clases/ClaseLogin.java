
package clases;

import dataBase.Conexion;
import froms.Alumnos;
import java.sql.CallableStatement;
import java.sql.ResultSet;

public class ClaseLogin {
    
    String nombreUsuario,contraseña,tipo,materia;
    String nombre,grupo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
    
    

    public ClaseLogin(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public ClaseLogin() {
    }
    String nombrealumno;

    public String getNombrealumno() {
        return nombrealumno;
    }
    public void setNombrealumno(String nombrealumno) {
        this.nombrealumno = nombrealumno;
    }
    
    
      public String obtenerNombre(){//Método de busca mediante procedimientos almacenados
        try{
            final String sql= "{call obtenerNombre(?,?)}";//Sintaxis
            Conexion objConexion=new Conexion();//Creo conexion
            CallableStatement cs= objConexion.getCon().prepareCall(sql);//Accede al procedimiento
            cs.setString(1, nombreUsuario);//Envio de parametros, (indice, valor a enviar)
            cs.setString(2, contraseña);
            ResultSet registro= cs.executeQuery();//Almacena el resultado de la comsulta
            while(registro.next()){
                nombre=registro.getString(1);
             
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return nombre;
    }
      
       public String obtenerGrupo(){//Método de busca mediante procedimientos almacenados
        try{
            final String sql= "{call obtenerGrupo(?,?)}";//Sintaxis
            Conexion objConexion=new Conexion();//Creo conexion
            CallableStatement cs= objConexion.getCon().prepareCall(sql);//Accede al procedimiento
            cs.setString(1, nombreUsuario);//Envio de parametros, (indice, valor a enviar)
            cs.setString(2, contraseña);
            ResultSet registro= cs.executeQuery();//Almacena el resultado de la comsulta
            while(registro.next()){
                grupo=registro.getString(1);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return grupo;
    }
    
     public String iniciarSesionA(){//Método de busca mediante procedimientos almacenados
        try{
            final String sql= "{call iniciarSesionA(?,?)}";//Sintaxis
            Conexion objConexion=new Conexion();//Creo conexion
            CallableStatement cs= objConexion.getCon().prepareCall(sql);//Accede al procedimiento
            cs.setString(1, nombreUsuario);//Envio de parametros, (indice, valor a enviar)
            cs.setString(2, contraseña);
            ResultSet registro= cs.executeQuery();//Almacena el resultado de la comsulta
            while(registro.next()){
                tipo=registro.getString(1);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return tipo;
    }
     
      public String materiaDocente(){//Método de busca mediante procedimientos almacenados
        try{
            final String sql= "{call materiaDocente(?,?)}";//Sintaxis
            Conexion objConexion=new Conexion();//Creo conexion
            CallableStatement cs= objConexion.getCon().prepareCall(sql);//Accede al procedimiento
            cs.setString(1, nombreUsuario);//Envio de parametros, (indice, valor a enviar)
            cs.setString(2,contraseña);
            ResultSet registro= cs.executeQuery();//Almacena el resultado de la comsulta
            while(registro.next()){
                materia=registro.getString(1);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return materia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
}
