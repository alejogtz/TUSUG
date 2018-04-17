
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
public class Trabajador {
    Conexion c;
    
    public Trabajador(Conexion con){
        c = con;
        }
    
    public void registrarTrabajador(int rfc, String nss, String nombre, String apellidos, String domicilio, String curp, Date f_nac,Date f_cont,Date f_ter, String estado, String urlImage){
        try { 
            PreparedStatement pstm = c.getConexion().prepareStatement("insert into " +
                    "sistemaTusug.trabajador(rfc,nss,nombre,apellido,domicilio,curp,fecha_nacimiento,fecha_contratacion,fecha_terminacion,estado,url_img) " +
                    " values(?,?,?,?,?,?,?,?,?,?,?)");
            pstm.setInt(1, rfc);
            pstm.setString(2, nss);
            pstm.setString(3, nombre);
            pstm.setString(4, apellidos);
            pstm.setString(5, domicilio);
            pstm.setString(6,curp);
            pstm.setDate(7, f_nac);
            pstm.setDate(8, f_cont);
            pstm.setDate(9, f_ter);
            pstm.setString(10, estado);
            pstm.setString(11, urlImage);
            pstm.execute();
            pstm.close(); 
        } catch(SQLException e){
         System.out.println(e);
      }
            
    }
    
    
    public Object [][] getDatosTrabajador(){
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = c.getConexion().prepareStatement("SELECT count(rfc) as total FROM sistemaTusug.trabajador ");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }    
       
      Object[][] data = new String[registros][11];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = c.getConexion().prepareStatement("SELECT * " +
            " FROM sistemaTusug.trabajador " +
            "ORDER BY rfc ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            int rfc = res.getInt("rfc");
            String nss = res.getString("nss");
            String nombre = res.getString("nombre");
            String apellido = res.getString("apellido");
            String domicilio = res.getString("domicilio");
            String curp = res.getString("curp");
            String f_nac = new SimpleDateFormat("yyyy-MM-dd").format(res.getDate("fecha_nacimiento"));
            String f_cont = new SimpleDateFormat("yyyy-MM-dd").format(res.getDate("fecha_contratacion"));
            String f_ter = new SimpleDateFormat("yyyy-MM-dd").format(res.getDate("fecha_terminacion"));
            String estado = res.getString("estado");
            String urlImg = res.getString("url_img");
            data[i][0] = Integer.toString(rfc);            
            data[i][1] = nss;            
            data[i][2] = nombre;
            data[i][3] = apellido;            
            data[i][4] = domicilio;            
            data[i][5] = curp;
            data[i][6] = f_nac;            
            data[i][7] = f_cont;            
            data[i][8] = f_ter;
            data[i][9] = estado;            
            data[i][10] = urlImg;            
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }
    
    
    public void borrarTrabajador(int rfc){  
            try {                
                PreparedStatement pstm = c.getConexion().prepareStatement("delete from sistemaTusug.trabajador where rfc = ?");            
                pstm.setInt(1, rfc);               
                pstm.execute();
                pstm.close();            
            }catch(SQLException e){
            System.out.println(e);
            }            
   }
    
    
    public void actualizarTrabajador(int rfc, String nss, String nombre, String apellidos, String domicilio, String curp, Date f_nac,Date f_cont,Date f_ter, String estado, String urlImg){
       try {            
            PreparedStatement pstm = c.getConexion().prepareStatement("UPDATE sistemaTusug.trabajador SET " +
            "nss = ? ," +
            "nombre = ? ," +
            "apellido = ? ," +  
            "domicilio = ? ," +  
            "curp = ? ," +
            "fecha_nacimiento = ? ," + 
            "fecha_contratacion = ? ," +
            "fecha_terminacion = ? ," +
            "estado = ? ," +
            "url_img = ? " + 
            "WHERE rfc = ? ");            
            pstm.setString(1, nss);
            pstm.setString(2, nombre);
            pstm.setString(3, apellidos);
            pstm.setString(4, domicilio);
            pstm.setString(5,curp);
            pstm.setDate(6, f_nac);
            pstm.setDate(7, f_cont);
            pstm.setDate(8, f_ter);
            pstm.setString(9, estado);
            pstm.setString(10, urlImg);
            pstm.setInt(11, rfc);
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
    }
    
    public void consultarTrabajadores(){
        Object[][] datos = getDatosTrabajador();
        for(int i = 0; i<datos.length;i++){
                System.out.println(datos[i][0].toString()+ " " + datos[i][1].toString() + " " + datos[i][2].toString() + " " + datos[i][3].toString() + " " + datos[i][4].toString() + " " + datos[i][5].toString() + " " + datos[i][6].toString());
        }
}

}