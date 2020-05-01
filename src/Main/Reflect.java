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
public class Reflect {

    private ArrayList<Table> tables;
    
    private String tab = "    ";
    private String dir = "src/Modelo/";
    private String ext = ".java";


    public Reflect() throws SQLException {
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
            
            String contenido = "";
            for (Attribute a : table.getAttributes()) {
//                System.out.println(a.toNameAttribute());
//                contenido += tab + a.toNameAttribute()+"\n";
                contenido += getGetterSetter(a);
            }

            File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
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
        out += tab + "public void set"+a.toNameAttribute()+"("+ a.getNameAttribute()+" "+a.toNameAttribute()+") {\n";
        out += tab + tab + "this."+a.toNameAttribute()+" = \""+a.toNameAttribute()+"\";\n";
        out += tab + "}\n\n";
        return out;
    }
}
