/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.lib;

import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class CrudSQL {
    //package head    
    //package body
    //f ins, p upd, f del, f read, f all
    public static String PackageHeader(Table tabla){
        return "create or replace package crud_"+tabla.getName().toLowerCase()+"\nis\n";
    }
    
    public static String InsertHeader(Table tabla){
        String plantilla = "-- insert \nfunction ins( \n%s) return number";
        StringBuilder params = new StringBuilder();
        ArrayList<Attribute> attr = tabla.getAttributes();
        int size = attr.size();
        for (int i = 1; i < size; i++) { // i=1 se omite id
            params.append("p_");
            params.append(attr.get(i).getColumnName());
            params.append(" in ");
            params.append(tabla.getName());
            params.append(".");
            params.append(attr.get(i).getColumnName());
            if(i<size-1) params.append("%type,\n");
            else params.append("%type\n");
        }
        return String.format(plantilla, params.toString()).toLowerCase();
    }
    
    public static String UpdateHeader(Table tabla){
        String plantilla = "-- update \nprocedure upd (\n%s)";
        StringBuilder params = new StringBuilder();
        ArrayList<Attribute> attr = tabla.getAttributes();
        int size = attr.size();
        for (int i = 0; i < size; i++) {
            params.append("p_");
            params.append(attr.get(i).getColumnName());
            params.append(" in ");
            params.append(tabla.getName());
            params.append(".");
            params.append(attr.get(i).getColumnName());
            if(i<size-1) params.append("%type,\n");
            else params.append("%type\n");
        }
        return String.format(plantilla, params.toString()).toLowerCase();
    }
    
    public static String DeleteHeader(Table tabla){
        String plantilla = "-- delete \nprocedure del (\n%s)";
        StringBuilder params = new StringBuilder();
        ArrayList<Attribute> attr = tabla.getAttributes();
        params.append("p_");
        params.append(attr.get(0).getColumnName());
        params.append(" in ");
        params.append(tabla.getName());
        params.append(".");
        params.append(attr.get(0).getColumnName());
        params.append("%type\n");
        return String.format(plantilla, params.toString()).toLowerCase();
    }
    
    public static String ReadHeader(Table tabla){
        String plantilla = "-- read \nfunction read (\n%s) return sys_refcursor";
        StringBuilder params = new StringBuilder();
        ArrayList<Attribute> attr = tabla.getAttributes();
        params.append("p_");
        params.append(attr.get(0).getColumnName());
        params.append(" in ");
        params.append(tabla.getName());
        params.append(".");
        params.append(attr.get(0).getColumnName());
        params.append("%type\n");  
        return String.format(plantilla, params.toString()).toLowerCase();
    }
    
    public static String ReadAllHeader(){
        return "-- all \nfunction read_all return sys_refcursor";
    }
    
    public static String PackageBody(Table tabla){
        return "create or replace package body crud_"+tabla.getName().toLowerCase()+"\nis\n";
    }
    
    public static String InsertBody(Table tabla){
        String nombreTabla = tabla.getName();
        ArrayList<Attribute> attr = tabla.getAttributes();
        int size = attr.size();
        
        StringBuilder body = new StringBuilder(CrudSQL.InsertHeader(tabla));
        body.append("\nas \nnew_id number := 0;\nbegin\n");
        body.append("new_id := ");
        body.append(nombreTabla);
        body.append("_seq.nextval;\n");
        body.append("insert into ");
        body.append(nombreTabla);
        body.append("(");
        
        for (int i = 0; i < size; i++) {
            body.append(attr.get(i).getColumnName());
            if(i<size-1) body.append(",");
            else body.append(")\n");
        }
        
        body.append("values (new_id,");
        for (int i = 1; i < size; i++) {
            body.append("p_");
            body.append(attr.get(i).getColumnName());
            if(i<size-1) body.append(",");
            else body.append(");\n");
        }
        body.append("return new_id;\n");
        body.append("end;\n\n");
        
        return body.toString().toLowerCase();
    }
    
    public static String UpdateBody(Table tabla){
        String nombreTabla = tabla.getName();
        ArrayList<Attribute> attr = tabla.getAttributes();
        int size = attr.size();
        
        StringBuilder body = new StringBuilder(CrudSQL.UpdateHeader(tabla));
        body.append("\nas\nbegin\n");
        body.append("update ");
        body.append(nombreTabla);
        body.append(" set\n");
        for (int i = 1; i < size; i++) {
            body.append(attr.get(i).getColumnName());
            body.append(" = p_");
            body.append(attr.get(i).getColumnName());
            if(i<size-1) body.append(",");
            else body.append(";\n");
        }
        body.append("end;\n\n");
        
        return body.toString().toLowerCase();
    }
    
    public static String DeleteBody(Table tabla){
        String nombreTabla = tabla.getName();
        ArrayList<Attribute> attr = tabla.getAttributes();
        StringBuilder body = new StringBuilder(CrudSQL.DeleteHeader(tabla));
        body.append("\nas\nbegin\n");
        body.append("delete from ");
        body.append(nombreTabla);
        body.append(" where ");
        body.append(attr.get(0).getColumnName());
        body.append(" = p_");
        body.append(attr.get(0).getColumnName());
        body.append(";\nend;\n\n");
        
        return body.toString().toLowerCase();
    }
    
    public static String ReadBody(Table tabla){
        String nombreTabla = tabla.getName();
        ArrayList<Attribute> attr = tabla.getAttributes();
        StringBuilder body = new StringBuilder(CrudSQL.ReadHeader(tabla));
        body.append("\nas \nmy_cursor sys_refcursor;\n");
        body.append("begin\n");
        body.append("open my_cursor for\n");
        body.append("select * from ");
        body.append(nombreTabla);
        body.append(" where ");
        body.append(attr.get(0).getColumnName());
        body.append(" = p_");
        body.append(attr.get(0).getColumnName());
        body.append(";\nreturn my_cursor;");
        body.append("\nend;\n\n");
        
        return body.toString().toLowerCase();
    }
    
    public static String ReadAllBody(Table tabla){
        String nombreTabla = tabla.getName();
        StringBuilder body = new StringBuilder(CrudSQL.ReadAllHeader());
        body.append("\nas \nmy_cursor sys_refcursor;\n");
        body.append("begin\n");
        body.append("open my_cursor for\n");
        body.append("select * from ");
        body.append(nombreTabla);
        body.append(";\nreturn my_cursor;");
        body.append("\nend;\n\n");
        
        return body.toString().toLowerCase();
    }
}
