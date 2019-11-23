/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dataBase.Conexion;
import java.io.FileOutputStream;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Alumno
 */
public class ClaseCalificaciones {

    String grupo;
    String alumno;
    String calificacion;

    public ClaseCalificaciones(String grupo, String alumno, String calificacion) {
        this.grupo = grupo;
        this.alumno = alumno;
        this.calificacion = calificacion;
    }
    
    
    public void agregarPrimer(){
        contultarIdGrupo();
        ConsultarIdAlumno();
        try{
            Conexion objConexion = new Conexion();//Crea la conexion
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="insert into CaliPrimer values(null,"+id_Grupo+","+idAlumno+",'Programacion','"+calificacion+"')";//Inserta datos, Intruccion sql
            sentencia.execute(sql);//returna el valor
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    int id_Grupo;
    public void contultarIdGrupo(){
        try{
            Conexion objConexion = new Conexion();
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="select id_grupo from grupos where nombregrupo = '"+grupo+"'";//Intruccion sql
            ResultSet registro=sentencia.executeQuery(sql);//Almaceno el resultado de la consulta
            while(registro.next()){
                id_Grupo=registro.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    int idAlumno;
    public void ConsultarIdAlumno(){
        try{
            Conexion objConexion = new Conexion();
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="select id_alumno from alumnos where concat(nombre,' ',apellidos) = '"+alumno+"'";//Intruccion sql
            ResultSet registro=sentencia.executeQuery(sql);//Almaceno el resultado de la consulta
            while(registro.next()){
                idAlumno=registro.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void agregarSegundo(){
        contultarIdGrupo();
        ConsultarIdAlumno();
        try{
            Conexion objConexion = new Conexion();//Crea la conexion
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="insert into CaliSegundo values(null,"+id_Grupo+","+idAlumno+",'Programacion','"+calificacion+"')";//Inserta datos, Intruccion sql
            sentencia.execute(sql);//returna el valor
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void agregarTercero(){
        contultarIdGrupo();
        ConsultarIdAlumno();
        try{
            Conexion objConexion = new Conexion();//Crea la conexion
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="insert into CaliTercer values(null,"+id_Grupo+","+idAlumno+",'Programacion','"+calificacion+"')";//Inserta datos, Intruccion sql
            sentencia.execute(sql);//returna el valor
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    public void agregarPrimerBase(){
        contultarIdGrupo();
        ConsultarIdAlumno();
        try{
            Conexion objConexion = new Conexion();//Crea la conexion
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="insert into CaliPrimerBase values(null,"+id_Grupo+","+idAlumno+",'Base de Datos','"+calificacion+"')";//Inserta datos, Intruccion sql
            sentencia.execute(sql);//returna el valor
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void agregarSegundoBase(){
        contultarIdGrupo();
        ConsultarIdAlumno();
        try{
            Conexion objConexion = new Conexion();//Crea la conexion
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="insert into CaliSegundoBase values(null,"+id_Grupo+","+idAlumno+",'Base de Datos','"+calificacion+"')";//Inserta datos, Intruccion sql
            sentencia.execute(sql);//returna el valor
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void agregarTerceroBase(){
        contultarIdGrupo();
        ConsultarIdAlumno();
        try{
            Conexion objConexion = new Conexion();//Crea la conexion
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="insert into CaliTercerBase values(null,"+id_Grupo+","+idAlumno+",'Base de Datos','"+calificacion+"')";//Inserta datos, Intruccion sql
            sentencia.execute(sql);//returna el valor
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
     public void agregarPrimerSistemas(){
        contultarIdGrupo();
        ConsultarIdAlumno();
        try{
            Conexion objConexion = new Conexion();//Crea la conexion
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="insert into CaliPrimerSistemas values(null,"+id_Grupo+","+idAlumno+",'Sistemas Operativos','"+calificacion+"')";//Inserta datos, Intruccion sql
            sentencia.execute(sql);//returna el valor
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void agregarSegundoSistemas(){
        contultarIdGrupo();
        ConsultarIdAlumno();
        try{
            Conexion objConexion = new Conexion();//Crea la conexion
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="insert into CaliSegundoSistemas values(null,"+id_Grupo+","+idAlumno+",'Sistemas Operativos','"+calificacion+"')";//Inserta datos, Intruccion sql
            sentencia.execute(sql);//returna el valor
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void agregarTerceroSistemas(){
        contultarIdGrupo();
        ConsultarIdAlumno();
        try{
            Conexion objConexion = new Conexion();//Crea la conexion
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="insert into CaliTercerSistemas values(null,"+id_Grupo+","+idAlumno+",'Sistemas Operativos','"+calificacion+"')";//Inserta datos, Intruccion sql
            sentencia.execute(sql);//returna el valor
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
