/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Models.Table;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mrbm
 */
public class JavaReflect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        Conexion conn = new Conexion();
        
        conn.getConnection();
        
        ArrayList<Table> tables = conn.show();
        
        for (Table xx : tables) {
            System.out.println(xx.toString());
        }
        
        conn.desconectar();
//
//        System.out.println(type("NUMBER(3,0)"));
//        System.out.println(type("VARCHAR2(3)"));
//        System.out.println(type("DATE"));
//        System.out.println(type("TIME"));
        
    }
    
    
    public static String type(String t){
        
        //
        String[] types = {"number","date","varchar2","time",};
        String[] vars  = {"int","string","string","string",};
        
        String[] a = t.split("\\(");
        String s = a[0].toLowerCase();
        int x = -1;
        for (int i = 0; i < types.length ; i++) {
            if(types[i] == null ? s == null : types[i].equals(s) ){
                
                x=i;
                break;
            }
            //System.out.println("estado : "+ types[i] + " s " + s + " x " + x + " dato curioso " + (types[i]==s));
        }
        
        if(x>-1){
            return vars[x];
        }else{
            return "string";
        }
        
    }
    
}
