/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

/**
 *
 * @author alang
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    Connection con = null;
    private final String url = "";
    
    public Conexion() {
        try 
        {
            //con = DriverManager.getConnection(url, usuario, contraseña);
            con = DriverManager.getConnection(url);
            if (con != null) 
            {
                System.out.println("Conexión a base de datos Cineteca listo");
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Error de Conexion" + e.getMessage());
        } 
    }

    public Connection Conectar() 
    {
        return con;
    }

    public void desconectar() 
    {
        con = null;
        System.out.println("Conexion terminada");
    }
}
