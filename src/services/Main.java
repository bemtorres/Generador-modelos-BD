/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author benja
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        boolean createModels = true;
        boolean createQueries = true;
        boolean createCrudsSQL = true;
        String[] databaseEngine = new String[2];
        databaseEngine[0] = "mysql";
        databaseEngine[1] = "oracle";
        
        try {
            
            Manager manager = new Manager(createModels,createQueries,createCrudsSQL,databaseEngine[1]);
            manager.call();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}