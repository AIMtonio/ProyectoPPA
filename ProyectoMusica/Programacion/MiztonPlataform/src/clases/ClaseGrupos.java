
package clases;
import dataBase.Conexion;
import java.sql.CallableStatement;
import java.sql.ResultSet;

public class ClaseGrupos {
    
    int id_grupo;
    String nombreG,materia1,materia2,materia3;

    public ClaseGrupos(int id_grupo, String nombreG, String materia1, String materia2, String materia3) {
        this.id_grupo = id_grupo;
        this.nombreG = nombreG;
        this.materia1 = materia1;
        this.materia2 = materia2;
        this.materia3 = materia3;
    }

    public ClaseGrupos() {
    }

    public ClaseGrupos(String nombreG, String materia1, String materia2, String materia3) {
        this.nombreG = nombreG;
        this.materia1 = materia1;
        this.materia2 = materia2;
        this.materia3 = materia3;
    }
    
   public void insertarGrupos(){
       try{
            final String sql= "{call insertarGrupos(?,?,?,?)}";//Sintaxis
            Conexion objConexion=new Conexion();//Crea conexion
            CallableStatement cs= objConexion.getCon().prepareCall(sql);//Accede al procedimiento
            //Envia valores
            //cs.setInt(1,empleadosId);
            cs.setString(1,nombreG);
            cs.setString(2,materia1);
            cs.setString(3,materia2);
            cs.setString(4,materia3);
            cs.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }        
    }
   
   public String verGrupos(){//Método de busca mediante procedimientos almacenados
        String grupos="";//Para Almacenar valores, para que a la hora de imprimir, muestre todos
        try{
            final String sql= "{call verGrupos()}";//Sintaxis
            Conexion objConexion=new Conexion();//crea conexion
            CallableStatement cs= objConexion.getCon().prepareCall(sql);//Accede al procedimiento
            cs.executeUpdate();
            ResultSet registro= cs.executeQuery();//Almacena resutado de la consulta
            while(registro.next()){
                //Almacena los datos
                 grupos=grupos+"ID: "+registro.getInt(1)+
                        "     Nombre: "+registro.getString(2)+
                        "\n\n";
            }
        }catch(Exception e){
            e.printStackTrace();
        } 
        return grupos;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getNombreG() {
        return nombreG;
    }

    public void setNombreG(String nombreG) {
        this.nombreG = nombreG;
    }

    public String getMateria1() {
        return materia1;
    }

    public void setMateria1(String materia1) {
        this.materia1 = materia1;
    }

    public String getMateria2() {
        return materia2;
    }

    public void setMateria2(String materia2) {
        this.materia2 = materia2;
    }

    public String getMateria3() {
        return materia3;
    }

    public void setMateria3(String materia3) {
        this.materia3 = materia3;
    }
    
    
    
    
    
}
