
package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import libray.conexion2;


public class accesoservicio {
    conexion2 c2= new conexion2();
    Connection cn=c2.connectDatabase();
    
    public accesoservicio(){
    conexion2 c2= new conexion2();
    Connection cn=c2.connectDatabase();
    }
    
     public void cargar(){
     try{
          //String [] titulos={"codigo_m","codigo_autobus","fecha_ingreso","fecha_salida","costo_reparacion"};
          String [] registros= new String[4];
          //model=new DefaultTableModel(null,titulos);

        String cons="select * from sistemaTusug.servicio" ;
        
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
               // model.addRow(registros);
                
            }
            
     }catch(Exception e){
                System.out.println(e.getMessage());
                 }
 }


   
    
    public void insert(int id_s,int cod_m, int cod_p, int can_p ){
     
    String sql="insert into sistemaTusug.servicio (id_servicio, codigo_m, codigo_producto, cantidad_producto) values (?,?,?,?)";
    try{
         PreparedStatement pst  = null;
     
         pst  = cn.prepareStatement(sql);
         pst.setInt(1, id_s);
         pst.setInt(2, cod_m);
         pst.setInt(3, cod_p);
         pst.setInt(4, can_p);
        
         
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
sql="delete * from sistemaTusug.servicio ";
st.executeUpdate(sql);

}
catch(Exception e){}

}
  //update
public  void update (int codigo_producto,int cantidad_producto,int id_servicio)
throws SQLException
{
  try
  {
      
    // create our java preparedstatement using a sql update query
    PreparedStatement ps =null;
    ps=cn.prepareStatement(
      "UPDATE sistemaTusug.servicio SET codigo_producto = ?, cantidad_producto = ? WHERE id_servicio = ?");

    // set the preparedstatement parameters
    ps.setInt(1,codigo_producto);
    ps.setInt(2,cantidad_producto);
    ps.setInt(3,id_servicio);
  

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
