/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import services.databases.ConexionMysql;
import services.databases.ConexionOracle;
import services.lib.Table;
import java.sql.SQLException;
import java.util.ArrayList;
import services.create.CreateCrudSQL;
import services.create.CreateFolders;
import services.create.CreateModels;
import services.create.CreateQueries;

/**
 *
 * @author benja
 */
public class Manager {
    public boolean createModels = false;
    public boolean createQueries = false;
    public boolean createCrudsSQL = false;
    public String databaseEngine = "";
    
    public ArrayList<Table> tables; 

    public Manager(boolean createModels, boolean createQueries, boolean createCrudsSQL, String databaseEngine) throws SQLException {
        this.createModels = createModels;
        this.createQueries = createQueries;
        this.createCrudsSQL = createCrudsSQL;
        this.databaseEngine = databaseEngine;
    }

    public void call() throws SQLException {
        if(connBD()){
            (new CreateFolders()).call();
            
            if(!this.tables.isEmpty()){
                for (Table xx : this.tables) {
                    if(this.createModels) (new CreateModels(xx)).call();
                    if(this.createQueries) (new CreateQueries(xx)).call();
                    if(this.createCrudsSQL) (new CreateCrudSQL(xx)).call();
                }
            }else{
                System.err.println("No existen datos.");
            }
        }else{
            System.err.println("No se ha podido establecer conexión.");
        }
    }
    
    private boolean connBD() throws SQLException{
        switch(this.databaseEngine){
            case "oracle":
                ConexionOracle connOracle = new ConexionOracle();
                connOracle.getConnection();
                setTables( connOracle.show());
                connOracle.close();
                return true;
            case "mysql":
                ConexionMysql connMysql = new ConexionMysql();
                connMysql.getConnection();
                setTables( connMysql.show());
                connMysql.close();
                return true;           
            default:
                break;
        }
        return false;

    }
    
    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }
}
