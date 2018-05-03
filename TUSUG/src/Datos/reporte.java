package Datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import libra.conexion2;
public class reporte {
  Conexion c;
    
    public reporte(Conexion con){
   c= con;
    }
    
     public void cargar(){
     try{
          String [] registros= new String[4];

        String cons="select * from sistemaTusug.reporte" ;
        
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


   
    
    public void insert(String fecha,int folio, String url_formato, String tipo_reporte ){
     
    String sql="insert into sistemaTusug.reporte (fecha, folio, url_formato, tipo_reporte) values (?,?,?,?)";
    try{
         PreparedStatement pst  = null;
     
         pst  = c.getConexion().prepareStatement(sql);
         pst.setDate(1, Date.valueOf(fecha));
         pst.setInt(2, folio);
         pst.setString(3, url_formato);
         pst.setString(4, tipo_reporte);
        
         
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
sql="delete * from sistemaTusug.reporte ";
st.executeUpdate(sql);

}
catch(Exception e){}

}
  //update
public  void update (String url_formato, String tipo_reporte,int folio)
throws SQLException
{
  try
  {
      
    // create our java preparedstatement using a sql update query
    PreparedStatement ps =null;
    ps=c.getConexion().prepareStatement(
      "UPDATE sistemaTusug.reporte SET url_formato = ?, tipo_reporte = ? WHERE folio = ?");

    // set the preparedstatement parameters
    ps.setString(1,url_formato);
    ps.setString(2,tipo_reporte);
    ps.setInt(3,folio);
  

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
