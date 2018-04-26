
package Modelo;

import java.sql.Date;

public class Pruebas {
    
    public Pruebas(){}
    
    
    
    public static void main(String[] args){
        Conexion c = new Conexion();
        c.realizaConexion();
        
        //Expediente_Per l = new Expediente_Per();
        //l.registrarExpedienteP(15161294,1,1);
        //l.borrarExpediente(15161294);
        //l.actualizarExpediente(15161294,2,2);
        //l.consultarExpediente();
        
        
        //Trabajador t = new Trabajador(c);
        //t.registrarTrabajador(17161200,"1000000","Abraham","Cruz Gallardo","Fraccionamiento El tuGfa","CGA9600",Date.valueOf("1986-10-08"),Date.valueOf("2017-01-15"),Date.valueOf("2018-04-10"),"Activo","TuGfa");
        //t.actualizarTrabajador(17161200,"1111111","Abraham","Cruz Gallardo","Fraccionamiento El tuGfa","CGA9600",Date.valueOf("1990-10-08"),Date.valueOf("2017-01-15"),Date.valueOf("2018-04-10"),"Activo","TuGfa");
        //t.consultarTrabajadores();
        //t.registrarTrabajador(16161295,"147563","Armando","Cruz Garcia","Fraccionamiento El Retiro","CRGA961",Date.valueOf("1996-10-08"),Date.valueOf("2018-01-15"),Date.valueOf("2018-04-15"),"Activo","Adiosi");
        


        //Chofer ch = new Chofer(c);
        //ch.registrarChofer(17161200, 1547809, 8, 3);
        //ch.actualizarChofer(17161200,1000000,8,1);
        //ch.consultarChofer();
        //ch.borrarChofer(17161200);
        
        
        
        //Control_Asistencia ca = new Control_Asistencia(c);
        //ca.registrarAsistencia(Date.valueOf("2018-04-17"),17161200, "10:00","12:00","No se baña.");
        //ca.actualizarAsistencia(Date.valueOf("2018-04-17"), 17161200,"11:00", "13:00", "Tarde pero se baña.");
        //ca.consultarAsistencia();
        //ca.borrarAsistencia(17161200);
        
        
        
        //Chofer_autobus cha = new Chofer_autobus(c);
        //cha.registrarChoferAutobus(17161200,1001);
        //cha.actualizarRelacionChoferAutobus(17161200, 1002);
        //cha.consultarRelacionChoferAutobus();
        //cha.borrarRelacionChoferAutobus(17161200);
    }
}
