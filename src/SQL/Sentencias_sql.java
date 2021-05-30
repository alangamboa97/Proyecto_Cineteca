/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alang
 */
public class Sentencias_sql {
    
     
    PreparedStatement ps;
    ResultSet rs;
    Conexion con = new Conexion();
    int respuesta=0;

    
    
    
     public boolean insertar(String datos[], String insert) 
    {
        boolean estado = false;
        try 
        {
            ps = con.Conectar().prepareStatement(insert);
            for (int i = 0; i <= datos.length - 1; i++) 
            {
                ps.setString(i + 1, datos[i]);
            }
            ps.execute();
            ps.close();
            estado = true;
        } 
        catch (SQLException e) 
        {
            System.out.println(e);
        }
        return estado;
    }

     public Object[][] GetTabla(String colName[], String tabla, String sql, Boolean SoloActivos) 
    {
        int registros = 0;
        try {
            if (SoloActivos)
                ps = con.Conectar().prepareStatement("select count(*) as total from " + tabla + " where Id_Estatus_Objeto = 1");
            else
                ps = con.Conectar().prepareStatement("select count(*) as total from " + tabla);

            rs = ps.executeQuery();
            rs.next();
            registros = rs.getInt("total");
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] data = new String[registros][colName.length];
        String col[] = new String[colName.length];

        try {
            ps = con.Conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                for (int j = 0; j <= colName.length - 1; j++) {
                    col[j] = rs.getString(colName[j]);
                    if (col[j] == null) {
                        col[j] = "";
                    }
                    data[i][j] = col[j];
                }
                i++;
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }
    
}
