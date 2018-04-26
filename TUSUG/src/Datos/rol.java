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
public class rol {
     conexion2 c2= new conexion2();
    Connection cn=c2.connectDatabase();
    
    public rol(){

    }
    
     public void cargar(){
     try{
          String [] registros= new String[3];

        String cons="select * from sistemaTusug.rol" ;
        
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


   
    
    public void insert(int id_rol,String descripcion, String nivel){
     
    String sql="insert into sistemaTusug.rol (codigo_producto, descripcion_producto, cantidad_producto) values (?,?,?)";
    try{
         PreparedStatement pst  = null;
     
         pst  = cn.prepareStatement(sql);
         pst.setInt(1, id_rol);
         pst.setString(2, descripcion);
         pst.setString(3, nivel);
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
sql="delete * from sistemaTusug.rol";
st.executeUpdate(sql);

}
catch(Exception e){}

}
  //update
public  void update (String nivel, String descripcion,int id_rol)
throws SQLException
{
  try
  {
      
    // create our java preparedstatement using a sql update query
    PreparedStatement ps =null;
    ps=cn.prepareStatement(
      "UPDATE sistemaTusug.rol SET descripcion = ?, nivel = ? WHERE id_rol = ?");

    // set the preparedstatement parameters
    ps.setString(1,descripcion);
    ps.setString(2, nivel);
    ps.setInt(3,id_rol);
   
  

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
