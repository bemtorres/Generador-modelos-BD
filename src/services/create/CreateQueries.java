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
import services.config.Config;

/**
 *
 * @author benja
 */
public class CreateQueries {
    public Table table;
    public Query query = new Query();
    
    public CreateQueries(Table table) {
        this.table = table;
    }
    
    public void call(){
          try {
            String ruta = Config.PATH_QUERIES + table.toNameTable() + Config.EXT_SQL;

            String content = "";
            
//            int cont = table.getAttributes().size();
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
              try (BufferedWriter bw = new BufferedWriter(fw)) {
                  bw.write(content);
              }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
