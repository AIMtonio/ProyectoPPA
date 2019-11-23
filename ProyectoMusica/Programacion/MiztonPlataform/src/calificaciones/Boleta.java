/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calificaciones;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dataBase.Conexion;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Alumno
 */
public class Boleta extends Thread{
    String grupo;
    String alumno;

    public Boleta(String grupo, String alumno) {
        this.grupo = grupo;
        this.alumno = alumno;
    }

    public Boleta() {
    }
    
    
    public void run(){
        try{//Atrapar las posibles excepciones
            Document doc=new Document(PageSize.LETTER);//Crea un objeto de la clase document(Contenedor Temporal)
            PdfWriter.getInstance(doc, new FileOutputStream("Boleta.pdf"));//Crea el flujo de datos de salida del PDF
            doc.open();//Para utilizar el documento(Una bandera), Para evitar que dos aplicaciones usen este archivo y se corrompa
            doc.add(new Paragraph("       "));
             Image imgUno=Image.getInstance("cabezera.png");
            imgUno.scalePercent(50);
//            imgUno.setAbsolutePosition(20, 84);
            doc.add(imgUno);
            doc.add(new Paragraph("                                                   BOLETA DE CALIFICACIONES"));//Almaceno informacion
            doc.add(new Paragraph("                                                                                                                     C.C.T 15ECT006C"));
            doc.add(new Paragraph("     Plantel:    "));
            doc.add(new Paragraph("                                 CBT JOSE ANTONIO ALZATE, TEMASCALAPA        "));
            doc.add(new Paragraph("       "));
            doc.add(new Paragraph("     Hace constar que segun registros que obran en el archivo de este plantel: "));
            doc.add(new Paragraph("                                                     "+alumno));
            doc.add(new Paragraph("     Es alumna del Primer semestre de la carrera de Tecnico en Informatica  "));
            doc.add(new Paragraph("     En el grupo:  "+grupo+" Sustentan las evaluaciones parciales que a continuacion se presentan:"));
            
            doc.add(new Paragraph("       "));
            PdfPTable tabla=new PdfPTable(5);//Crea tablas y por medio del construcctor le mando el numero de columnas que va tener mi tabla
            PdfPCell celda=new PdfPCell(new Phrase("MATERIA"));//Crear celdas
            celda.setHorizontalAlignment(Element.ALIGN_CENTER);//Centra el titulo o encabezados.
            celda.setColspan(1);
            tabla.addCell(celda);
            
            PdfPCell celda2=new PdfPCell(new Phrase("PARCIAL 1"));//Crear celdas
            celda2.setHorizontalAlignment(Element.ALIGN_CENTER);//Centra el titulo o encabezados.
            celda2.setColspan(1);
            tabla.addCell(celda2);
            
            PdfPCell celda3=new PdfPCell(new Phrase("PARCIAL 2"));//Crear celdas
            celda3.setHorizontalAlignment(Element.ALIGN_CENTER);//Centra el titulo o encabezados.
            celda3.setColspan(1);
            tabla.addCell(celda3);
            
            PdfPCell celda4=new PdfPCell(new Phrase("PARCIAL 3"));//Crear celdas
            celda4.setHorizontalAlignment(Element.ALIGN_CENTER);//Centra el titulo o encabezados.
            celda4.setColspan(1);
            tabla.addCell(celda4);
            
            PdfPCell celda5=new PdfPCell(new Phrase("FINAL"));//Crear celdas
            celda5.setHorizontalAlignment(Element.ALIGN_CENTER);//Centra el titulo o encabezados.
            celda5.setColspan(1);
            tabla.addCell(celda5);
            
            consultarMaterias();
            tabla.addCell("       "+mat1);//Recibir una cadena de texto, deben completarse la cantidad de celdas como tantas cantidad de columnas, si no no se agrega
            obtenerCalificaciones();
            tabla.addCell("       "+cal1);
            tabla.addCell("       "+cal2);
            tabla.addCell("       "+cal3);
            promedio();
            tabla.addCell("       "+prom);
            tabla.addCell("       "+mat2);//Recibir una cadena de texto, deben completarse la cantidad de celdas como tantas cantidad de columnas, si no no se agrega
            obtenerCalificacionesBase();
            tabla.addCell("       "+cal1b);
            tabla.addCell("       "+cal2b);
            tabla.addCell("       "+cal3b);
            promediob();
            tabla.addCell("       "+promb);
            tabla.addCell("       "+mat3);//Recibir una cadena de texto, deben completarse la cantidad de celdas como tantas cantidad de columnas, si no no se agrega
            obtenerCalificacionesSistemas();
            tabla.addCell("       "+cal1s);
            tabla.addCell("       "+cal2s);
            tabla.addCell("       "+cal3s);
            promedios();
            tabla.addCell("       "+proms);
            doc.add(tabla);//Agrego la tabla ya construida al documento
            
            doc.add(new Paragraph("       "));
            doc.add(new Paragraph("                         La calificación minima aprobatoria es de 6(Seis) puntos       "));
            doc.add(new Paragraph("                         Esta Boleta no es valida se presenta borraduras o alteraciones  "));
            doc.add(new Paragraph("                         Temascalapa Mexico, a los 15 dias del mes de Diciembre del 2017  "));
             Image imgDos=Image.getInstance("FIRMA.PNG");
            imgDos.scalePercent(80);
//            imgUno.setAbsolutePosition(20, 84);
            doc.add(imgDos);
            doc.close();//Termino de ocupar el documento
        }catch(Exception e){
            //Atrapar una posible excepción
            e.printStackTrace();
        }
    }
    float prom=0;
    
    public void promedio(){
        float c1=Float.valueOf(cal1);
        float c2=Float.valueOf(cal2);
        float c3=Float.valueOf(cal3);
        prom=(c1+c2+c3)/3;
    }
    
     float promb=0;
    
    public void promediob(){
        float c1=Float.valueOf(cal1b);
        float c2=Float.valueOf(cal2b);
        float c3=Float.valueOf(cal3b);
        promb=(c1+c2+c3)/3;
    }
      float proms=0;
    
    public void promedios(){
        float c1=Float.valueOf(cal1s);
        float c2=Float.valueOf(cal2s);
        float c3=Float.valueOf(cal3s);
        proms=(c1+c2+c3)/3;
    }
    
    
    String mat1,mat2,mat3;
    public void consultarMaterias(){
        try{
            Conexion objConexion = new Conexion();
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="select materia1 from grupos where nombregrupo = '"+grupo+"'";//Intruccion sql
            ResultSet registro=sentencia.executeQuery(sql);//Almaceno el resultado de la consulta
            while(registro.next()){
                mat1=registro.getString(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
         try{
            Conexion objConexion = new Conexion();
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="select materia2 from grupos where nombregrupo = '"+grupo+"'";//Intruccion sql
            ResultSet registro=sentencia.executeQuery(sql);//Almaceno el resultado de la consulta
            while(registro.next()){
                mat2=registro.getString(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
         try{
            Conexion objConexion = new Conexion();
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="select materia3 from grupos where nombregrupo = '"+grupo+"'";//Intruccion sql
            ResultSet registro=sentencia.executeQuery(sql);//Almaceno el resultado de la consulta
            while(registro.next()){
                mat3=registro.getString(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        } 
    }
    String cal1,cal2,cal3;
    public void obtenerCalificaciones(){
        try{
            Conexion objConexion = new Conexion();
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="select calPrimer from caliPrimer where id_grupo = "
                    + "(select id_grupo from grupos where nombregrupo='"+grupo+"') and "
                    + "id_alumno=(select id_alumno from alumnos where concat(nombre,' ',apellidos)='"+alumno+"')";//Intruccion sql
            ResultSet registro=sentencia.executeQuery(sql);//Almaceno el resultado de la consulta
            while(registro.next()){
                cal1=registro.getString(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            Conexion objConexion = new Conexion();
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="select calSegundo from calisegundo where id_grupo = "
                    + "(select id_grupo from grupos where nombregrupo='"+grupo+"') and "
                    + "id_alumno=(select id_alumno from alumnos where concat(nombre,' ',apellidos)='"+alumno+"')";//Intruccion sql
            ResultSet registro=sentencia.executeQuery(sql);//Almaceno el resultado de la consulta
            while(registro.next()){
                cal2=registro.getString(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            Conexion objConexion = new Conexion();
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="select caltercer from caliTercer where id_grupo = "
                    + "(select id_grupo from grupos where nombregrupo='"+grupo+"') and "
                    + "id_alumno=(select id_alumno from alumnos where concat(nombre,' ',apellidos)='"+alumno+"')";//Intruccion sql
            ResultSet registro=sentencia.executeQuery(sql);//Almaceno el resultado de la consulta
            while(registro.next()){
                cal3=registro.getString(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    String cal1b,cal2b,cal3b;
    public void obtenerCalificacionesBase(){
        try{
            Conexion objConexion = new Conexion();
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="select calPrimer from caliPrimerBase where id_grupo = "
                    + "(select id_grupo from grupos where nombregrupo='"+grupo+"') and "
                    + "id_alumno=(select id_alumno from alumnos where concat(nombre,' ',apellidos)='"+alumno+"')";//Intruccion sql
            ResultSet registro=sentencia.executeQuery(sql);//Almaceno el resultado de la consulta
            while(registro.next()){
                cal1b=registro.getString(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            Conexion objConexion = new Conexion();
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="select calSegundo from calisegundobase where id_grupo = "
                    + "(select id_grupo from grupos where nombregrupo='"+grupo+"') and "
                    + "id_alumno=(select id_alumno from alumnos where concat(nombre,' ',apellidos)='"+alumno+"')";//Intruccion sql
            ResultSet registro=sentencia.executeQuery(sql);//Almaceno el resultado de la consulta
            while(registro.next()){
                cal2b=registro.getString(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            Conexion objConexion = new Conexion();
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="select caltercer from caliTercerbase where id_grupo = "
                    + "(select id_grupo from grupos where nombregrupo='"+grupo+"') and "
                    + "id_alumno=(select id_alumno from alumnos where concat(nombre,' ',apellidos)='"+alumno+"')";//Intruccion sql
            ResultSet registro=sentencia.executeQuery(sql);//Almaceno el resultado de la consulta
            while(registro.next()){
                cal3b=registro.getString(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    String cal1s,cal2s,cal3s;
    public void obtenerCalificacionesSistemas(){
        try{
            Conexion objConexion = new Conexion();
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="select calPrimer from caliPrimerSistemas where id_grupo = "
                    + "(select id_grupo from grupos where nombregrupo='"+grupo+"') and "
                    + "id_alumno=(select id_alumno from alumnos where concat(nombre,' ',apellidos)='"+alumno+"')";//Intruccion sql
            ResultSet registro=sentencia.executeQuery(sql);//Almaceno el resultado de la consulta
            while(registro.next()){
                cal1s=registro.getString(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            Conexion objConexion = new Conexion();
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="select calSegundo from calisegundoSistemas where id_grupo = "
                    + "(select id_grupo from grupos where nombregrupo='"+grupo+"') and "
                    + "id_alumno=(select id_alumno from alumnos where concat(nombre,' ',apellidos)='"+alumno+"')";//Intruccion sql
            ResultSet registro=sentencia.executeQuery(sql);//Almaceno el resultado de la consulta
            while(registro.next()){
                cal2s=registro.getString(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            Conexion objConexion = new Conexion();
            Statement sentencia=objConexion.getCon().createStatement();//Ejecuta la sentencia
            String sql="select caltercer from caliTercerSistemas where id_grupo = "
                    + "(select id_grupo from grupos where nombregrupo='"+grupo+"') and "
                    + "id_alumno=(select id_alumno from alumnos where concat(nombre,' ',apellidos)='"+alumno+"')";//Intruccion sql
            ResultSet registro=sentencia.executeQuery(sql);//Almaceno el resultado de la consulta
            while(registro.next()){
                cal3s=registro.getString(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
     public void prueba(){
        try{//Atrapar las posibles excepciones
            Document doc=new Document(PageSize.LETTER);//Crea un objeto de la clase document(Contenedor Temporal)
            PdfWriter.getInstance(doc, new FileOutputStream("prueba.pdf"));//Crea el flujo de datos de salida del PDF
            doc.open();//Para utilizar el documento(Una bandera), Para evitar que dos aplicaciones usen este archivo y se corrompa
            doc.add(new Paragraph("       "));
             Image imgUno=Image.getInstance("cabezera.png");
            imgUno.scalePercent(50);
//            imgUno.setAbsolutePosition(20, 84);
            doc.add(imgUno);
            doc.add(new Paragraph("                                                   BOLETA DE CALIFICACIONES"));//Almaceno informacion
            doc.add(new Paragraph("                                                                                                                     C.C.T 15ECT006C"));
            doc.add(new Paragraph("     Plantel:    "));
            doc.add(new Paragraph("                                 CBT JOSE ANTONIO ALZATE, TEMASCALAPA        "));
            doc.add(new Paragraph("       "));
            doc.add(new Paragraph("     Hace constar que segun registros que obran en el archivo de este plantel: "));
            doc.add(new Paragraph("                                                     "+alumno));
            doc.add(new Paragraph("     Es alumna del Primer semestre de la carrera de Tecnico en Informatica  "));
            doc.add(new Paragraph("     En el grupo:  "+grupo+" Sustentan las evaluaciones parciales que a continuacion se presentan:"));
            doc.add(new Paragraph("       "));
            doc.add(new Paragraph("                         La calificación minima aprobatoria es de 6(Seis) puntos       "));
            doc.add(new Paragraph("                         Esta Boleta no es valida se presenta borraduras o alteraciones  "));
            doc.add(new Paragraph("                         Temascalapa Mexico, a los 15 dias del mes de Diciembre del 2017  "));
             Image imgDos=Image.getInstance("FIRMA.PNG");
            imgDos.scalePercent(80);
//            imgUno.setAbsolutePosition(20, 84);
            doc.add(imgDos);
            doc.close();//Termino de ocupar el documento
        }catch(Exception e){
            //Atrapar una posible excepción
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Boleta c=new Boleta("4TIC1","Liz Jimenez");
        c.start();
//        Boleta b=new Boleta();
//        b.prueba();
    }
    
}
