
package access;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import libray.conexion2;


public class Access {
  conexion2 c2= new conexion2();
  Connection cn=c2.connectDatabase();
    
    public Access(){
    conexion2 c2= new conexion2();
    Connection cn=c2.connectDatabase();
    }
    
     public void cargar(){
     try{
          String [] registros= new String[5];

        String cons="select * from sistemaTusug.mantenimiento" ;
        
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
                registros[4]=rs.getString(5);
                System.out.println(registros[4]);
                
            }
            
     }catch(Exception e){
                System.out.println(e.getMessage());
                 }
 }


   
    
    public void insert(int codm,int coda, String fechi, String fechs, int cosre ){
     
    String sql="insert into sistemaTusug.mantenimiento (codigo_m, codigo_autobus, fecha_ingreso, fecha_salida, costo_reparacion) values (?,?,?,?,?)";
    try{
         PreparedStatement pst  = null;
     
         pst  = cn.prepareStatement(sql);
         pst.setInt(1, codm);
         pst.setInt(2, coda);
         pst.setDate(3, Date.valueOf(fechi));
         pst.setDate(4,  Date.valueOf(fechs));
         pst.setInt(5,cosre);
         
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
sql="delete * from sistemaTusug.mantenimiento where codigo_m =" +x+";";
st.executeUpdate(sql);

}
catch(Exception e){}

}
  //update
public  void update (int codigo_m,int codigo_autobus,int codigo_m2)
throws SQLException
{
  try
  {
      
    PreparedStatement ps =null;
    ps=cn.prepareStatement(
      "UPDATE sistemaTusug.mantenimiento SET codigo_m = ?, codigo_autobus = ? WHERE codigo_autobus = ?");

    ps.setInt(1,codigo_m);
    ps.setInt(2,codigo_autobus);
    ps.setInt(3,codigo_m2);
  

    ps.executeUpdate();
    ps.close();
  }
  catch (SQLException se)
  {
    throw se;
  }
}
    
}
