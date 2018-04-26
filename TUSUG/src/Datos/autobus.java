package PROYECTOINTEGRADOR;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import libray.conexion2;
public class autobus 
{
    conexion2 c2= new conexion2();
  Connection cn=c2.connectDatabase();
    
    public autobus()
    {
    conexion2 c2= new conexion2();
    Connection cn=c2.connectDatabase();
    }
    
    public void cargar()
    {
        try
        {
          
        String [] registros= new String[4];
        String cons="select * from sistemaTusug.autobus" ;
        
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
                registros[3]=rs.getString(4);
                System.out.print(registros[3]);              
            }
            
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


   
    
    public void insert(int codigo_autobus,String marca, int numerico_economico, String matricula_autobus)
    { 
    String sql="insert into sistemaTusug.autobus (codigo_autobus,marca,numerico_economico,matricula_autobus) values (?,?,?,?)";
    try
    {
         PreparedStatement pst  = null;
     
         pst  = cn.prepareStatement(sql);
         pst.setInt(1, codigo_autobus);
         pst.setString(2, marca);
         pst.setInt(3, numerico_economico);
         pst.setString(4, matricula_autobus);
         
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
        sql="delete * from sistemaTusug.autobus";
        st.executeUpdate(sql);

    }catch(Exception e){
    }
}
  //update
public  void update (int codigo_autobus,String marca, int numerico_economico, String matricula_autobus)
throws SQLException
{
  try
  {
      
    // create our java preparedstatement using a sql update query
    PreparedStatement ps =null;
    ps=cn.prepareStatement(
      "UPDATE sistemaTusug.autobus SET marca = ?, numerico_economico = ?,matricula_autobus = ? WHERE codigo_autobus= ?");

    // set the preparedstatement parameters
    ps.setString(1,marca);
    ps.setInt(2,numerico_economico);
    ps.setString(3,matricula_autobus);
    ps.setInt(4,codigo_autobus);
  

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
