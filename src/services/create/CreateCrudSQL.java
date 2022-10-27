/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.create;

import services.lib.Query;
import services.lib.Table;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import services.config.Config;
import services.lib.CrudSQL;

/**
 *
 * @author benja
 */
public class CreateCrudSQL {
    public Table table;
    
    public CreateCrudSQL(Table table) {
        this.table = table;
    }
    
    public void call(){        
        String ruta = Config.PATH_CRUD + "crud_" + table.toNameTable().toLowerCase() + Config.EXT_SQL;

        
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
