/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mrbm
 */
public class Clip {

    private ArrayList<Table> tables;
    
    private String tab = "  ";
    private String dirModels = "src/Modelo/";
    private String dirQuery = "src/Query/";
    private String dirCruds = "src/CrudSQL/";
    private Query query;

    private String ext = ".java";


    public Clip(boolean models, boolean queries, boolean crudSql) throws SQLException {
        Conexion conn = new Conexion();
        query = new Query();
        
        conn.getConnection();
        this.tables = conn.show();
        conn.close();

        for (Table xx : this.tables) {
            if(models) createModels(xx);
            if(queries) createQuery(xx);
            if(crudSql) createCrudSQL(xx);
        }
        

    }

    private void createModels(Table table) {
        try {
            
            String ruta = dirModels + table.toNameTable() + ext;
            String content = "";
            int cont = table.getAttributes().size();
            
            content += "package Modelo;\n\n";
            content += "public class "+ table.toNameTable() +"{\n\n";
            
            for (Attribute a : table.getAttributes()) {
                content += tab + "private "+a.getNameAttribute()+" "+a.toNameLower()+";\n";
            }
            
            content +="\n";
            content += tab + "public "+ table.toNameTable() +"() {}\n\n";
         
            
            content += tab + "public "+ table.toNameTable() +"(";
            int x = 0;
            for (Attribute a : table.getAttributes()) {
                content+= a.getNameAttribute()+ " "+ a.toNameLower();
                if (x<cont-1) {
                    content+=",";
                }
                x++;
            }
            
            content += "){\n";
            
            for (Attribute a : table.getAttributes()) {
                content += tab + tab +"this."+ a.toNameLower()+" = "+a.toNameLower()+";\n";
            }        
            content += tab + "}\n\n";
            
            for (Attribute a : table.getAttributes()) {
                content += tab + "public void set"+a.toNameUpper()+"("+ a.getNameAttribute()+" "+a.toNameLower()+") {\n";
                content += tab + tab + "this."+a.toNameLower()+" = "+a.toNameLower()+";\n";
                content += tab + "}\n\n";
                content += tab + "public "+a.getNameAttribute()+" get"+a.toNameUpper()+"() {\n";
                content += tab + tab + "return "+a.toNameLower()+";\n";
                content += tab + "}\n\n";
            }
           
            content += tab + "@Override\n";
            content += tab +"public String toString() {\n";
            content += tab + tab +  "return \"" + table.toNameTable() + " {";
            for (Attribute a : table.getAttributes()) {
               content += a.toNameLower()+":\"+" + a.toNameLower()+ "+\", ";
          
            }
            content += "}\";\n";
            content += tab + "}\n";
            
            content += "}";

            File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void createQuery(Table table){
          try {
            
            String ruta = dirQuery + table.toNameTable() + ".sql";
            String content = "";
            
            int cont = table.getAttributes().size();
            content +="\n\n";
            content += "-- Tablas de " + table.toNameTable() + "\n\n";
            String nombre = "";
            for (Attribute a : table.getAttributes()) {
                nombre = a.getColumnName();
                break;
            }
            content += query.buscarTabla(table.getName(), nombre,nombre)+"\n";
            content += query.buscarTodosTabla(table.getName()) + "\n";
            content += query.insertarTabla(table.getName(), table.getAttributes()) + "\n";
            content += query.updateTabla(table.getName(), table.getAttributes()) + "\n";
            content += query.eliminarTabla(table.getName(),nombre,nombre) + "\n";
            
            content += "\n\n\n-- PROCEDIMIENTOS --\n\n";
            content += query.createProcedimiento(table)+"\n";
            //content += "public class "+ table.toNameTable() +"\n\n";

            File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void createCrudSQL(Table table){
        String ruta = dirCruds + "crud_" + table.toNameTable().toLowerCase() + ".sql";
        
        StringBuilder content = new StringBuilder();
        
        content.append(CrudSQL.PackageHeader(table));
        
        content.append(CrudSQL.InsertHeader(table));
        content.append(";\n");
        content.append(CrudSQL.UpdateHeader(table));
        content.append(";\n");
        content.append(CrudSQL.DeleteHeader(table));
        content.append(";\n");
        content.append(CrudSQL.ReadHeader(table));
        content.append(";\n");
        content.append(CrudSQL.ReadAllHeader());
        content.append(";\n");
        
        content.append("\nend crud_");
        content.append(table.getName().toLowerCase());
        content.append(";\n/\n");
        
        content.append(CrudSQL.PackageBody(table));
        
        content.append(CrudSQL.InsertBody(table));
        content.append(CrudSQL.UpdateBody(table));
        content.append(CrudSQL.DeleteBody(table));
        content.append(CrudSQL.ReadBody(table));
        content.append(CrudSQL.ReadAllBody(table));
        
        content.append("\nend crud_");
        content.append(table.getName().toLowerCase());
        content.append(";");
        
        try {
            File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content.toString());
            bw.close();
            System.out.println(ruta+" creado :D");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
