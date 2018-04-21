import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Poliza 
{
	Conexion c;
    public Poliza(Conexion con)
    {
        c = con;
    }
    
    public void registrarPoliza(int codigo_poliza, int codigo_autobus, String descripcion, Date fecha_comienzo, Date fecha_terminacion, int prima_pagar, int limite_indemnizacion)
    {
        try 
        {
        	PreparedStatement pstm = c.getConexion().prepareStatement("insert into " +
                    "sistematusug.poliza(codigo_poliza,codigo_autobus,descripcion,fecha_comienzo,fecha_terminacion,prima_pagar,limite_indemnizacion) " +
                    " values(?,?,?,?,?,?,?)");
            pstm.setInt(1, codigo_poliza);
            pstm.setInt(2, codigo_autobus);
            pstm.setString(3, descripcion);
            pstm.setDate(4, fecha_comienzo);
            pstm.setDate(5, fecha_terminacion);
            pstm.setInt(6, prima_pagar);
            pstm.setInt(7, limite_indemnizacion);
            
           
            pstm.execute();
            pstm.close(); 
        } 
        catch(SQLException e)
        {
        	System.out.println("ñ.ñ "+e);
      	}
    }
    
    public Object [][] getDatosPoliza()
    {
    	int registros = 0;
      	//obtenemos la cantidad de registros existentes en la tabla
     	try
     	{
     		PreparedStatement pstm = c.getConexion().prepareStatement("SELECT count(codigo_poliza) as total FROM sistematusug.poliza ");
         	ResultSet res = pstm.executeQuery();
         	res.next();
         	registros = res.getInt("total");
         	res.close();
      	}
      	catch(SQLException e)
      	{
      		System.out.println(e);
      	}    
       
      	Object[][] data = new String[registros][7];
      	try
      	{
      		PreparedStatement pstm = c.getConexion().prepareStatement("SELECT * " +
            	" FROM sistematusug.poliza " +
            	"ORDER BY codigo_poliza ");
        	ResultSet res = pstm.executeQuery();
        	int i = 0;
        	while(res.next())
        	{
        		int codigoPoliza = res.getInt("codigo_poliza");
            	int codigoAutobus = res.getInt("codigo_autobus");
            	String descripcion = res.getString("descripcion");
            	String fechaComienzo = new SimpleDateFormat("yyyy-MM-dd").format(res.getDate("fecha_comienzo"));
            	String fechaTerminacion = new SimpleDateFormat("yyyy-MM-dd").format(res.getDate("fecha_terminacion"));
            	int primaPagar = res.getInt("prima_pagar");
            	int limiteIndemnizacion = res.getInt("limite_indemnizacion");
            
            	data[i][0] = Integer.toString(codigoPoliza);            
            	data[i][1] = Integer.toString(codigoAutobus);            
            	data[i][2] = descripcion;
            	data[i][3] = fechaComienzo;
            	data[i][4] = fechaTerminacion;
            	data[i][5] = Integer.toString(primaPagar);
            	data[i][6] = Integer.toString(limiteIndemnizacion); 
            	i++;
            }
         	res.close();
        }
        catch(SQLException e)
        {
        	System.out.println(e);
    	}
    	return data;
 	}
    
    public void borrarPoliza(int codigo_poliza)
    {
    	try 
    	{
    		PreparedStatement pstm = c.getConexion().prepareStatement("delete from sistemaTusug.poliza where codigo_poliza = ?");            
            pstm.setInt(1, codigo_poliza);               
            pstm.execute();
            pstm.close();            
        }
        catch(SQLException e)
        {
        	System.out.println(e);
        }            
    }
    
    
    public void actualizarPoliza(int codigo_poliza, int codigo_autobus, String descripcion, Date fecha_comienzo, Date fecha_terminacion, int prima_pagar, int limite_indemnizacion)
    {
    	try 
    	{
    		PreparedStatement pstm = c.getConexion().prepareStatement("UPDATE sistemaTusug.poliza SET " +
              "codigo_poliza = ? ," +
              "codigo_autobus = ? ," +
              "descripcion = ? " +  
              "fecha_comienzo = ? " +
              "fecha_terminacion = ? ," +
              "prima_pagar = ? ," +
              "limite_indemnizacion = ? " +  
              "where codigo_poliza = ? "
              );            
            pstm.setInt(1, codigo_poliza);
            pstm.setInt(2, codigo_autobus);
            pstm.setString(3, descripcion);
            pstm.setDate(4, fecha_comienzo);
            pstm.setDate(5, fecha_terminacion);
            pstm.setInt(6, prima_pagar);
            pstm.setInt(7, limite_indemnizacion);
            
            pstm.execute();
            pstm.close();            
        }
        catch(SQLException e)
        {
        	System.out.println(e);
      	}
    }
    
    public void consultarPoliza()
    {
    	Object[][] datos = getDatosPoliza();
        for(int i = 0; i<datos.length;i++)
        {
        	System.out.println(datos[i][0].toString()+ " " + datos[i][1].toString() + " " + datos[i][2].toString() + " " + datos[i][3].toString()+ " " + datos[i][4].toString()+ " " +datos[i][5].toString()+ " " +datos[i][6].toString());
        }
	}
}
