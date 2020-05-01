/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Models.Attribute;
import Models.Table;
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
    
    private String tab = "    ";
    private String dir = "src/Modelo/";
    private String ext = ".java";


    public Clip() throws SQLException {
        Conexion conn = new Conexion();

        conn.getConnection();
        this.tables = conn.show();
        conn.desconectar();

        for (Table xx : this.tables) {
            createModels(xx);
        }

    }

    private void createModels(Table table) {
        try {
            
            String ruta = dir + table.toNameTable() + ext;
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
                
            }
            
            for (Attribute a : table.getAttributes()) {
                content += getGetterSetter(a);
            }
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
    
    
    private String getContructor(Attribute a){
        
        String out = "";
        return out;
    }
    
    private String getGetterSetter(Attribute a){
        String out = "";
        out += tab + "public void set"+a.toNameUpper()+"("+ a.getNameAttribute()+" "+a.toNameLower()+") {\n";
        out += tab + tab + "this."+a.toNameLower()+" = "+a.toNameLower()+";\n";
        out += tab + "}\n\n";
        out += tab + "public "+a.getNameAttribute()+" get"+a.toNameUpper()+"() {\n";
        out += tab + tab + "return "+a.toNameLower()+";\n";
        out += tab + "}\n\n";
        return out;
    }
}
