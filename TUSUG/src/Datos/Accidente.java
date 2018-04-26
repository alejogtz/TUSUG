package Datos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Accidente 
{
	Conexion c;
    
    public Accidente(Conexion con)
    {
    	c = con;
    }
    
    public void registrarAccidente(int codigo_accidente,int id_posesion,Date fecha, String descripcion, String lugar,String velocidad)
    {
        try 
        {
        	PreparedStatement pstm = c.getConexion().prepareStatement("insert into " +
                    "sistemaTusug.accidente(codigo_accidente,id_posesion,fecha, descripcion, lugar,velocidad) " +
                    " values(?,?,?,?,?,?)");
            pstm.setInt(1, codigo_accidente);
            pstm.setInt(2, id_posesion);
            pstm.setDate(3, fecha);
            pstm.setString(4, descripcion);
            pstm.setString(5, lugar);
            pstm.setString(6, velocidad);
            pstm.execute();
            pstm.close(); 
        } 
        catch(SQLException e)
        {
        	System.out.println(e);
        }
    }
    
    public Object [][] getDatosAccidente()
    {
    	int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try
        {
        	PreparedStatement pstm = c.getConexion().prepareStatement("SELECT count(codigo_accidente) as total FROM sistemaTusug.accidente ");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }
        catch(SQLException e)
        {
        	System.out.println(e);
        }    
       
        Object[][] data = new String[registros][6];
        try
        {
        	PreparedStatement pstm = c.getConexion().prepareStatement("SELECT * " +
            " FROM sistemaTusug.accidente " +
            "ORDER BY codigo_accidente ");
         	ResultSet res = pstm.executeQuery();
         	int i = 0;
         	while(res.next())
         	{
         		int codigo_accidente = res.getInt("codigo_accidente");
	            int id_posesion = res.getInt("id_posesion");
    	        String fecha = new SimpleDateFormat("yyyy-MM-dd").format(res.getDate("fecha"));
        	    String descripcion = res.getString("descripcion");
            	String lugar = res.getString("lugar");
            	String velocidad = res.getString("velocidad");
                      
            	data[i][0] = Integer.toString(codigo_accidente);            
            	data[i][1] = Integer.toString(id_posesion);
            	data[i][2] = fecha;
            	data[i][3] = descripcion;            
            	data[i][4] = lugar;  
            	data[i][5] = velocidad;
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
    
    public void borrarAccidente(int codigo_accidente)
    {
    	try 
    	{
    		PreparedStatement pstm = c.getConexion().prepareStatement("delete from sistemaTusug.accidente where codigo_accidente = ?");            
            pstm.setInt(1, codigo_accidente);               
            pstm.execute();
            pstm.close();            
        }
        catch(SQLException e)
        {
        	System.out.println(e);
        }            
    }
    
    public void actualizarAccidente(int codigo_accidente,int id_posesion,Date fecha, String descripcion, String lugar,String velocidad)
    {
    	try 
    	{
    		PreparedStatement pstm = c.getConexion().prepareStatement("UPDATE sistemaTusug.accidente SET " +
            "codigo_accidente = ? ," +
            "id_posesion = ? ," +
            "fecha = ? ," +  
            "descripcion = ? ," +  
            "lugar = ? ," +
            "velocidad = ? " +
            "WHERE codigo_accidente = ? ");
            pstm.setInt(1, codigo_accidente);
            pstm.setInt(2, id_posesion);
            pstm.setDate(3, fecha);
            pstm.setString(4, descripcion);
            pstm.setString(5, lugar);
            pstm.setString(6, velocidad);
            
            pstm.execute();
            pstm.close();            
        }
        catch(SQLException e)
        {
        	System.out.println(e);
        }
    }
    
    public void consultarAccidente()
    {
    	Object[][] datos = getDatosAccidente();
        for(int i = 0; i<datos.length;i++)
        {
        	System.out.println(datos[i][0].toString()+ " " + datos[i][1].toString() + " " + datos[i][2].toString() + " " + datos[i][3].toString() + " " + datos[i][4].toString()+ " "+ datos[i][5].toString());
        }
	}
}
