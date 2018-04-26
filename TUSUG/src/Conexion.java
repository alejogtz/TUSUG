import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion{
	private static Connection conn = null;
	//URL de Descargar del Driver
	//https://jdbc.postgresql.org/download.html
	private Conexion(){}
	
	public void realizaConexion(){            
            String urlDatabase =  "jdbc:postgresql://localhost:5432/midatabase"; 
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(urlDatabase,  "usuario", "password");
            } catch (Exception e) {
                System.out.println("Ocurrio un error : "+e.getMessage());
            }
            System.out.println("La conexión se realizo sin problemas! =) ");
	}
	
	public static Connection getConexion(){
		if (conn == null)
			new Conexion().realizaConexion();
		return conn;
	}
}
