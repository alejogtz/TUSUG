
package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Datos.conexion2;

public class refaccion {
    conexion2 c2= new conexion2();
    Connection cn=c2.connectDatabase();
    
    public refaccion(){

    }
    
     public void cargar(){
     try{
          String [] registros= new String[3];

        String cons="select * from sistemaTusug.refaccion" ;
        
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while(rs.next()){
                registros[0]=rs.getString(1);
                System.out.print(registros[0]);
                registros[1]=rs.getString(2);
                System.out.print(registros[1]);
                registros[2]=rs.getString(3);
                System.out.print(registros[2]);
                registros[3]=rs.getString(4);
                System.out.print(registros[3]);
                
                
            }
            
     }catch(Exception e){
                System.out.println(e.getMessage());
                 }
 }


   
    
    public void insert(int codigo_producto,String descripcion_producto, int cantidad_producto ){
     
    String sql="insert into sistemaTusug.refaccion (codigo_producto, descripcion_producto, cantidad_producto) values (?,?,?)";
    try{
         PreparedStatement pst  = null;
     
         pst  = cn.prepareStatement(sql);
         pst.setInt(1, codigo_producto);
         pst.setString(2, descripcion_producto);
         pst.setInt(3, cantidad_producto);
         
        
         
         int n=pst.executeUpdate();
         if(n>0){
         JOptionPane.showMessageDialog(null, "Registro Guardado con Exito");
           
            }
        
    }catch (SQLException ex) {
            Logger.getLogger(Access.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public void borrar(int x){
    try
{
 Statement st= cn.createStatement();
String sql;
sql="delete * from sistemaTusug.refaccion";
st.executeUpdate(sql);

}
catch(Exception e){}

}
  //update
public  void update (int cantidad_producto, String descripcion_producto,int codigo_producto)
throws SQLException
{
  try
  {
      
    // create our java preparedstatement using a sql update query
    PreparedStatement ps =null;
    ps=cn.prepareStatement(
      "UPDATE sistemaTusug.refaccion SET descripcion_producto = ?, cantidad_producto = ? WHERE codigo_producto = ?");

    // set the preparedstatement parameters
    ps.setInt(1,cantidad_producto);
    ps.setString(2, descripcion_producto);
    ps.setInt(3,codigo_producto);
   
  

    // call executeUpdate to execute our sql update statement
    ps.executeUpdate();
    ps.close();
  }
  catch (SQLException se)
  {
    // log the exception
    throw se;
  }
 } 
}
