
package Datos;

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
public class Chofer_autobus {
    Conexion c;
    
    public Chofer_autobus(Conexion con){
        c = con;
        }
    
    public void registrarChoferAutobus(int rfc,int codigo_autobus){
        try { 
            PreparedStatement pstm = c.getConexion().prepareStatement("insert into " +
                    "sistemaTusug.chofer_autobus(rfc,codigo_autobus) " +
                    " values(?,?)");
            pstm.setInt(1, rfc);
            pstm.setInt(2, codigo_autobus);
            pstm.execute();
            pstm.close(); 
        } catch(SQLException e){
         System.out.println(e);
      }
            
    }
    
    
    public Object [][] getDatosChoferAutobus(){
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = c.getConexion().prepareStatement("SELECT count(rfc) as total FROM sistemaTusug.chofer_autobus ");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }    
       
      Object[][] data = new String[registros][2];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = c.getConexion().prepareStatement("SELECT * " +
            " FROM sistemaTusug.chofer_autobus " +
            "ORDER BY rfc ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            int rfc = res.getInt("rfc");
            int codigo_autobus = res.getInt("codigo_autobus");
            
            data[i][0] = Integer.toString(rfc);          
            data[i][1] = Integer.toString(codigo_autobus);                                  
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }
    
    
    public void borrarRelacionChoferAutobus(int rfc){  
            try {                
                PreparedStatement pstm = c.getConexion().prepareStatement("delete from sistemaTusug.chofer_autobus where rfc = ?");            
                pstm.setInt(1, rfc);               
                pstm.execute();
                pstm.close();            
            }catch(SQLException e){
            System.out.println(e);
            }            
   }
    
    
    public void actualizarRelacionChoferAutobus(int rfc,int codigo_autobus){
       try {            
            PreparedStatement pstm = c.getConexion().prepareStatement("UPDATE sistemaTusug.chofer_autobus SET " +
            "rfc = ? ," +
            "codigo_autobus = ? " +  
            "WHERE rfc = ? ");            
            pstm.setInt(1,rfc);
            pstm.setInt(2,codigo_autobus);
            pstm.setInt(3,rfc);
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
    }
    
    public void consultarRelacionChoferAutobus(){
        Object[][] datos = getDatosChoferAutobus();
        for(int i = 0; i<datos.length;i++){
                System.out.println(datos[i][0].toString()+ " " + datos[i][1].toString());
        }
}

}