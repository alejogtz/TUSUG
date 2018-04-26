
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio Javier Garcia Garcia
 */
public class Expediente_Per {
    Conexion c;
    
    public Expediente_Per(Conexion con){
        c = con;
    }
    
    public void registrarExpedienteP(int rfc, int faltas, int actasAdmin){
        try { 
            PreparedStatement pstm = c.getConexion().prepareStatement("insert into " +
                    "sistemaTusug.expediente_permanente(rfc,n_faltas,n_actasadministrativas) " +
                    " values(?,?,?)");
            pstm.setInt(1, rfc);
            pstm.setInt(2, faltas);
            pstm.setInt(3, actasAdmin);
            pstm.execute();
            pstm.close(); 
        } catch(SQLException e){
         System.out.println(e);
      }
            
    }
    
    
    public Object [][] getDatosExpediente(){
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = c.getConexion().prepareStatement("SELECT count(rfc) as total FROM sistemaTusug.expediente_permanente ");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }    
       
      Object[][] data = new Integer[registros][3];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = c.getConexion().prepareStatement("SELECT " +
            " rfc,n_faltas,n_actasadministrativas" +
            " FROM sistemaTusug.expediente_permanente " +
            "ORDER BY rfc ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            int rfc = res.getInt("rfc");
            int faltas = res.getInt("n_faltas");
            int actasadmin = res.getInt("n_actasadministrativas");
            data[i][0] = rfc;            
            data[i][1] = faltas;            
            data[i][2] = actasadmin;                               
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }
    
    
    public void borrarExpediente(int rfc){  
            try {                
                PreparedStatement pstm = c.getConexion().prepareStatement("delete from sistemaTusug.expediente_permanente where rfc = ?");            
                pstm.setInt(1, rfc);               
                pstm.execute();
                pstm.close();            
            }catch(SQLException e){
            System.out.println(e);
            }            
   }
    
    
    public void actualizarExpediente(int rfc, int faltas, int actasadmin){
       try {            
            PreparedStatement pstm = c.getConexion().prepareStatement("UPDATE sistemaTusug.expediente_permanente SET " +
            "n_faltas = ? ," +
            "n_actasadministrativas = ? " +                    
            "WHERE rfc = ? ");            
            pstm.setInt(1, faltas);                   
            pstm.setInt(2, actasadmin);
            pstm.setInt(3, rfc); 
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
   }

    public void consultarExpediente(){
        Object[][] datos = getDatosExpediente();
        for(int i = 0; i<datos.length;i++){
                System.out.println(datos[i][0].toString()+ " " + datos[i][1].toString() + " " + datos[i][2].toString());
        }
}

}