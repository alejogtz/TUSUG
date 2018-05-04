package Datos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class usuarios {

    Conexion c;
    public usuarios(Conexion con){
   c= con;
    }
    
     public void cargar(){
     try{
          
        String [] registros= new String[5];
        String cons="select * from sistemaTusug.usuario" ;
        
            Statement st= c.getConexion().createStatement();
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
                registros[4]=rs.getString(5);
                System.out.println(registros[4]);                
            }
            
     }catch(Exception e){
                System.out.println(e.getMessage());
                 }
 }
        public String getPassword(int rfc){
            String pass=null;
     try{
         
         String con ="select contrasenia from sistemaTusug.usuario where rfc="+rfc+"";
      Statement st= c.getConexion().createStatement();
      ResultSet rs = st.executeQuery(con);



        pass=rs.getString(1);
            
     }catch(Exception e){
                System.out.println(e.getMessage());
                 }
     return pass;
 }


   
    
    public void insert(int rfc,int id_rol, String contrasenia, String url_image, String uti_vez){
     
    String sql="insert into sistemaTusug.mantenimiento (rfc,id_rol,contrasenia,url_image,uti_vez ) values (?,?,?,?,?)";
    try{
         PreparedStatement pst  = null;
     
         pst  = c.getConexion().prepareStatement(sql);
         pst.setInt(1, rfc);
         pst.setInt(2, id_rol);
         pst.setString(3, contrasenia);
         pst.setString(4, url_image);
         pst.setDate(5, Date.valueOf(uti_vez));
         
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
 Statement st= c.getConexion().createStatement();
String sql;
sql="delete * from sistemaTusug.usuario";
st.executeUpdate(sql);

}
catch(Exception e){}

}
  //update
public  void update (String contrasenia,String url_image,int id_rol)
throws SQLException
{
  try
  {
      
    // create our java preparedstatement using a sql update query
    PreparedStatement ps =null;
    ps=c.getConexion().prepareStatement(
      "UPDATE sistemaTusug.usuario SET contrasenia = ?, url_image = ? WHERE id_rol= ?");

    // set the preparedstatement parameters
    ps.setString(1,contrasenia);
    ps.setString(2,url_image);
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
