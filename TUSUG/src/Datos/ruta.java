
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


public class ruta 
{
    conexion2 c2= new conexion2();
  Connection cn=c2.connectDatabase();
    
    public ruta()
    {
    conexion2 c2= new conexion2();
    Connection cn=c2.connectDatabase();
    }
    
    public void cargar()
    {
        try
        {
          
        String [] registros= new String[3];
        String cons="select * from sistemaTusug.ruta" ;
        
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while(rs.next())
            {
                registros[0]=rs.getString(1);
                System.out.print(registros[0]);
                registros[1]=rs.getString(2);
                System.out.print(registros[1]);
                registros[2]=rs.getString(3);
                System.out.print(registros[2]);             
            }
            
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


   
    
    public void insert(int codigo_ruta,String nombre_ruta, String color_ruta)
    { 
    String sql="insert into sistemaTusug.ruta (codigo_ruta,nombre_ruta,color_ruta) values (?,?,?)";
    try
    {
         PreparedStatement pst  = null;
     
         pst  = cn.prepareStatement(sql);
         pst.setInt(1, codigo_ruta);
         pst.setString(2, nombre_ruta);
         pst.setString(3, color_ruta);
         
         int n=pst.executeUpdate();
         if(n>0)
         {
         JOptionPane.showMessageDialog(null, "Registro Guardado con Exito");
           
         }
        
    }catch (SQLException ex) {
            Logger.getLogger(autobus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrar(int x){
    try
    {
        Statement st= cn.createStatement();
        String sql;
        sql="delete * from sistemaTusug.ruta";
        st.executeUpdate(sql);

    }catch(Exception e){
    }
}
  //update
public  void update (int codigo_ruta,String nombre_ruta, String color_ruta)
throws SQLException
{
  try
  {
      
    // create our java preparedstatement using a sql update query
    PreparedStatement ps =null;
    ps=cn.prepareStatement(
      "UPDATE sistemaTusug.autobus SET color_ruta = ?, nombre_ruta = ? WHERE codigo_ruta= ?");

    // set the preparedstatement parameters
    ps.setString(1,color_ruta);
    ps.setString(2,nombre_ruta);
    ps.setInt(3,codigo_ruta);
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
