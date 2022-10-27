/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.lib;

import services.lib.Attribute;
import java.util.ArrayList;

/**
 *
 * @author mrbm
 */
public class Query {
        
    public String buscarTabla(String nombreTabla, String column, String data){
        return "SELECT * FROM " + nombreTabla + " WHERE " + column + "=" + data + ";";
    }
    
    public String buscarTodosTabla(String nombreTabla){
        return "SELECT * FROM " + nombreTabla + ";";
    }
    
    public String insertarTabla(String nombreTabla,ArrayList<Attribute> listaAttributes){
        String query = "INSERT INTO "+nombreTabla+" (";
        int x = 0;
        for (Attribute a: listaAttributes) {
            query += a.getColumnName();
            if(x<listaAttributes.size()-1){
                query +=",";
            }
            x++;
        }
        query += ") VALUES (";
        
        x = 0;
        for (Attribute a: listaAttributes) {
            switch(a.getNameAttribute()){
                case "String":
                    query += "\""+a.getColumnName()+"\"";
                    break;
                case "int":
                    query += a.getColumnName();
                    break;
                default:
                    query += "\""+a.getColumnName()+"\"";
                    break;
            }
            if(x<listaAttributes.size()-1){
                query +=",";
            }
            x++;
        }
       
        query += ");";
        return query;
    }
    
    public String updateTabla(String nombreTabla,ArrayList<Attribute> listaAttributes){
        String query = "UPDATE "+nombreTabla+" SET ";
        int x = 0;
        for (Attribute a: listaAttributes) {
            query += a.getColumnName() + "="; 
            
            switch(a.getNameAttribute()){
                case "String":
                    query += "\""+a.getColumnName()+"\"";
                    break;
                case "int":
                    query += a.getColumnName();
                    break;
                default:
                    query += "\""+a.getColumnName()+"\"";
                    break;
            }
            if(x<listaAttributes.size()-1){
                query +=",";
                x++;
            }
        }
        query += " WHERE "; 
        Attribute aa = new Attribute();
        for (Attribute a: listaAttributes) {
            aa = a;
            break;
        }
        query += aa.getColumnName()+"=";
        switch(aa.getNameAttribute()){
            case "String":
                query += "\""+aa.getColumnName()+"\"";
                break;
            case "int":
                query += aa.getColumnName();
                break;
            default:
                query += "\""+aa.getColumnName()+"\"";
                break;
        }
        query += ";";
        return query;
    }
    
    public String eliminarTabla(String nombreTabla, String column, String data){
        return "DELETE * FROM " + nombreTabla + " WHERE " + column + "=" + data + ";";    
    }
    
    public String createFunction(Table tabla){
        String query  = "";
        String tab = "    ";
        query += "CREATE OR REPLACE FUNCTION f_create_"+tabla.getName().toLowerCase();
        query += "(";
        int x = 0;
        for (Attribute a: tabla.getAttributes()) {
            query += "v_"+a.getColumnName().toLowerCase() + " " + a.getDataType();
            if(x<tabla.getAttributes().size()-1){
                query +=",";
                x++;
            }
        }
        query += ") RETURN NUMBER\n";
        query += "AS \n  NEW_ID INT:=0;\nBEGIN \nNEW_ID := "+tabla.getName().toLowerCase()+"_seq.nextval;\n ";
        
        query += "INSERT INTO "+tabla.toNameTable()+" (";
        x = 0;
        for (Attribute a: tabla.getAttributes()) {
            query += a.getColumnName();
            if(x<tabla.getAttributes().size()-1){
                query +=",";
            }
            x++;
        }
        query += ") VALUES (";
        
        x = 0;
        for (Attribute a: tabla.getAttributes()) {
            query += "v_"+a.getColumnName().toLowerCase();
            if(x<tabla.getAttributes().size()-1){
                query +=",";
            }
            x++;
        }
       
        query += ");";
        query += tab + "";
        query += "\n RETURN NEW_ID;\nEND;\n";
        return query;
    }
    
    public String createProcedimiento(Table tabla){
        String query  = "";
        String tab = "    ";
        query += "CREATE OR REPLACE PROCEDURE proc_insert_"+tabla.getName().toLowerCase();
        query += "(";
        int x = 0;
        for (Attribute a: tabla.getAttributes()) {
            query += "v_"+a.getColumnName().toLowerCase() + " " + a.getDataType();
            if(x<tabla.getAttributes().size()-1){
                query +=",";
                x++;
            }
        }
        query += ")\n";
        query += "AS \nBEGIN \n";
        
        query += "INSERT INTO "+tabla.toNameTable()+" (";
        x = 0;
        for (Attribute a: tabla.getAttributes()) {
            query += a.getColumnName();
            if(x<tabla.getAttributes().size()-1){
                query +=",";
            }
            x++;
        }
        query += ") VALUES (";
        
        x = 0;
        for (Attribute a: tabla.getAttributes()) {
            query += "v_"+a.getColumnName().toLowerCase();
            if(x<tabla.getAttributes().size()-1){
                query +=",";
            }
            x++;
        }
       
        query += ");";
        query += tab + "";
        query += "\nEND;\n";
        return query;        
    }
}
