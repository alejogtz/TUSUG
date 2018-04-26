
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
public class Control_Asistencia {
    Conexion c;
    
    public Control_Asistencia(Conexion con){
        c = con;
        }
    
    public void registrarAsistencia(Date fecha,int rfc,String h_entrada, String h_salida, String observacion){
        try { 
            PreparedStatement pstm = c.getConexion().prepareStatement("insert into " +
                    "sistemaTusug.control_asistencia(fecha,rfc,hora_entrada,hora_salida,observacion) " +
                    " values(?,?,?,?,?)");
            pstm.setDate(1, fecha);
            pstm.setInt(2, rfc);
            pstm.setString(3, h_entrada);
            pstm.setString(4, h_salida);
            pstm.setString(5, observacion);
            pstm.execute();
            pstm.close(); 
        } catch(SQLException e){
         System.out.println(e);
      }
            
    }
    
    
    public Object [][] getDatosAsistencia(){
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = c.getConexion().prepareStatement("SELECT count(rfc) as total FROM sistemaTusug.control_asistencia ");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }    
       
      Object[][] data = new String[registros][5];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = c.getConexion().prepareStatement("SELECT * " +
            " FROM sistemaTusug.control_asistencia " +
            "ORDER BY rfc ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String fecha = new SimpleDateFormat("yyyy-MM-dd").format(res.getDate("fecha"));
            int rfc = res.getInt("rfc");
            String h_entrada = res.getString("hora_entrada");
            String h_salida = res.getString("hora_salida");
            String observacion = res.getString("observacion");
            
            data[i][0] = fecha;          
            data[i][1] = Integer.toString(rfc);            
            data[i][2] = h_entrada;
            data[i][3] = h_salida;            
            data[i][4] = observacion;                       
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }
    
    
    public void borrarAsistencia(int rfc){  
            try {                
                PreparedStatement pstm = c.getConexion().prepareStatement("delete from sistemaTusug.control_asistencia where rfc = ?");            
                pstm.setInt(1, rfc);               
                pstm.execute();
                pstm.close();            
            }catch(SQLException e){
            System.out.println(e);
            }            
   }
    
    
    public void actualizarAsistencia(Date fecha,int rfc,String h_entrada, String h_salida, String observacion){
       try {            
            PreparedStatement pstm = c.getConexion().prepareStatement("UPDATE sistemaTusug.control_asistencia SET " +
            "fecha = ? ," +
            "rfc = ? ," +
            "hora_entrada = ? ," +  
            "hora_salida = ? ," +  
            "observacion = ? " + 
            "WHERE rfc = ? ");            
            pstm.setDate(1,fecha);
            pstm.setInt(2, rfc);
            pstm.setString(3, h_entrada);
            pstm.setString(4, h_salida);
            pstm.setString(5,observacion);
            pstm.setInt(6, rfc);
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
    }
    
    public void consultarAsistencia(){
        Object[][] datos = getDatosAsistencia();
        for(int i = 0; i<datos.length;i++){
                System.out.println(datos[i][0].toString()+ " " + datos[i][1].toString() + " " + datos[i][2].toString() + " " + datos[i][3].toString() + " " + datos[i][4].toString());
        }
}

}