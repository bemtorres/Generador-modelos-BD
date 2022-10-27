/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.databases;

import services.lib.Attribute;
import services.lib.Table;
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
public class ConexionOracle {

    private static Connection conn;
    
    private static String USER     = "HR";
    private static String PASSWORD = "abcd14abcd";
    private static String HOST     = "localhost";
    private static String PORT     = "1521";
//    private static String SID      = "XE";
    private static String SID      = "orcl";
    
    private static String CONN     = "jdbc:oracle:thin:@" + HOST + ":" + PORT + ":" + SID;

    Statement stm;

    public ConexionOracle() {
        conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(CONN, USER, PASSWORD);

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
        stm = conn.createStatement();
        try {
            String query = "SELECT table_name FROM USER_TABLES";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String nameTable = rs.getString("table_name");
                listTables.add(new Table(nameTable, describe(nameTable)));
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
            String query = "SELECT * FROM user_tab_columns WHERE table_name='" + nameTable + "'";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {

                String columnName = rs.getString("COLUMN_NAME");
                String dataType   = rs.getString("DATA_TYPE");
                //int[] dataPrecision = rs.getInt("DATA_PRESION");
                int[] dataScale   = {rs.getInt("DATA_PRECISION"),rs.getInt("DATA_SCALE")};
                
                Attribute attribute = new Attribute(columnName, dataType, false,dataScale,"oracle");
                listAttribute.add(attribute);
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex.toString());
        }
        return listAttribute;
    }

}
