/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mrbm
 */
public class ConexionMysql {
    
    private static Connection conn;
    
    private static String nameDB   = "sistema";
    
    private static String USER     = "root";
    private static String PASSWORD = "";
    private static String host     = "localhost";
    private static String port     = "3306";
    private static String CONN     = "jdbc:mysql://" + host + ":" + port + "/" + nameDB;

    Statement stm;

    public ConexionMysql() {
        conn = null;
        try {
          
            Class.forName("com.mysql.jdbc.Driver");  
            conn = DriverManager.getConnection(CONN,USER,PASSWORD);
            
            if (conn != null) {
                System.out.println("Conexion exitosa!");
            } else {
                System.out.println("Conexion fallida!");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en la conexión de la base de datos" + ex.toString());
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void close() {
        conn = null;
    }
    
    
    public ArrayList<Table> show() throws SQLException {
        ArrayList<Table> listTables = new ArrayList<>();
        String nombreTabla = "Tables_in_"+nameDB;
        
        stm = conn.createStatement();
        try {
            String query = "SHOW TABLES";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String nombreTable = rs.getString(nombreTabla);
                listTables.add(new Table(nombreTable, describe(nombreTable)));
                //System.out.println(nombre);
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex.toString());

        }
        return listTables;
    }
    
    
    public ArrayList<Attribute> describe(String nameTable) throws SQLException {

        ArrayList<Attribute> listAttribute = new ArrayList<>();

        stm = conn.createStatement();
        try {
            String query = "DESCRIBE "+ nameTable;
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String columnName   = rs.getString("Field");
                String type         = rs.getString("Type");                
                String[] parts      = type.split("\\(");
                String dataType     = parts[0];
                int[] dataScale     = {0,0};
                Attribute attribute = new Attribute(columnName, dataType, false,dataScale,"mysql");
                listAttribute.add(attribute);
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex.toString());

        }
        return listAttribute;
    }
}
