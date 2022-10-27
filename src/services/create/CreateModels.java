/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.create;

import services.lib.Attribute;
import services.lib.Query;
import services.lib.Table;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import services.config.Config;

/**
 *
 * @author benja
 */
public class CreateModels {
    private final String tab = "  ";
    public Table table;
    
    public CreateModels(Table table) {
        this.table = table;
    }
    
    public void call() {
        try {
            String ruta = Config.PATH_MODELS + table.toNameTable() + Config.EXT_JAVA;

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
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
