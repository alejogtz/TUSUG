
package Modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio Javier Garcia Garcia
 */
public class Chofer {
    Conexion c;
    
    public Chofer(Conexion con){
        c = con;
        }
    
    public void registrarChofer(int rfc, int numLicencia, int h_trab, int experiencia){
        try { 
            PreparedStatement pstm = c.getConexion().prepareStatement("insert into " +
                    "sistemaTusug.chofer(rfc,no_licencia,horas_trabajadas,experiencia) " +
                    " values(?,?,?,?)");
            pstm.setInt(1, rfc);
            pstm.setInt(2, numLicencia);
            pstm.setInt(3, h_trab);
            pstm.setInt(4,experiencia);
           
            pstm.execute();
            pstm.close(); 
        } catch(SQLException e){
         System.out.println(e);
      }
            
    }
    
    
    public Object [][] getDatosChofer(){
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = c.getConexion().prepareStatement("SELECT count(rfc) as total FROM sistemaTusug.chofer ");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }    
       
      Object[][] data = new String[registros][4];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = c.getConexion().prepareStatement("SELECT * " +
            " FROM sistemaTusug.chofer " +
            "ORDER BY rfc ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            int rfc = res.getInt("rfc");
            int numLicencia = res.getInt("no_licencia");
            int h_trab = res.getInt("horas_trabajadas");
            int experiencia = res.getInt("experiencia");
            data[i][0] = Integer.toString(rfc);            
            data[i][1] = Integer.toString(numLicencia);            
            data[i][2] = Integer.toString(h_trab);
            data[i][3] = Integer.toString(experiencia);            
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }
    
    
    public void borrarChofer(int rfc){  
            try {                
                PreparedStatement pstm = c.getConexion().prepareStatement("delete from sistemaTusug.chofer where rfc = ?");            
                pstm.setInt(1, rfc);               
                pstm.execute();
                pstm.close();            
            }catch(SQLException e){
            System.out.println(e);
            }            
   }
    
    
    public void actualizarChofer(int rfc, int numLicencia, int h_trab, int experiencia){
       try {            
            PreparedStatement pstm = c.getConexion().prepareStatement("UPDATE sistemaTusug.chofer SET " +
            "no_licencia = ? ," +
            "horas_trabajadas = ? ," +
            "experiencia = ? " +  
            "where rfc = ? " 
            );            
            pstm.setInt(1, numLicencia);
            pstm.setInt(2, h_trab);
            pstm.setInt(3, experiencia);
            pstm.setInt(4, rfc);
            
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
    }
    
    public void consultarChofer(){
        Object[][] datos = getDatosChofer();
        for(int i = 0; i<datos.length;i++){
                System.out.println(datos[i][0].toString()+ " " + datos[i][1].toString() + " " + datos[i][2].toString() + " " + datos[i][3].toString());
        }
}

}