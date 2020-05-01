/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author mrbm
 */
public class Attribute {
    private String  columnName;
    private String  dataType;
    private boolean nullable;
    private String  nameAttribute; 

    public Attribute(String columnName, String dataType, boolean nullable) {
        this.columnName = columnName;
        this.dataType = dataType;
        this.nullable = nullable;
        this.nameAttribute = this.findAttribute();
    }

    public Attribute() {
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    /**
    * Retorna el tipo de datos de Java String, Int
    * @author Bemtorres
    * @param  null
    * @return String: tipo de dato String, Int
    */
    public String getNameAttribute() {
        return nameAttribute;
    }

    public void setNameAttribute(String nameAttribute) {
        this.nameAttribute = nameAttribute;
    }

    @Override
    public String toString() {
        return "Attribute{" + "columnName=" + columnName + ", dataType=" + dataType + ", nullable=" + nullable + ", nameAttribute=" + nameAttribute + '}';
    }

          
    /**
    * Convierte el tipo de datos primitivo de SQL a JAVA
    * @author Bemtorres
    * @param  this.getDataType()
    * @return tipo de datos en String
    */
    private String findAttribute(){
        
        //
        String[] types = {"number","date","varchar2","time",};
        String[] vars  = {"int","String","String","String",};
        
        //String[] a = t.split("\\(");
        //String s = a[0].toLowerCase();
        String s = getDataType().toLowerCase();
        int x = -1;
        for (int i = 0; i < types.length ; i++) {
            if(types[i] == null ? s == null : types[i].equals(s) ){
                
                x=i;
                break;
            }
        }
        
        if(x>-1){
            return vars[x];
        }else{
            return "string";
        }
        
    }
    
        
    /**
    * Este metodo convierte la columna en Lower Camel Case: hola_mundo -> holaMundo
    * @author Bemtorres
    * @param  this.getColumnName()
    * @return String: las primera letra en minuscula
    */
    public String toNameLower(){
        String[] names = this.getColumnName().toLowerCase().split("_");
        String nameAttribute = "";
        for (int i = 0; i < names.length ; i++) {
            if(i==0){
                 nameAttribute += names[i];
            }else{
                 nameAttribute += names[i].substring(0, 1).toUpperCase() + names[i].substring(1).toLowerCase();
            }
           
        }
        return nameAttribute;
    }
    
    /**
    * Este metodo convierte la columna en Upper Camel Case: hola_mundo -> HolaMundo
    * @author Bemtorres
    * @param  this.getColumnName()
    * @return String: las primera letra en mayuscula
    */
    public String toNameUpper(){
        String[] names = this.getColumnName().toLowerCase().split("_");
        String nameAttribute = "";
        for (int i = 0; i < names.length ; i++) {
            nameAttribute += names[i].substring(0, 1).toUpperCase() + names[i].substring(1).toLowerCase();
        }
        return nameAttribute;
    }
    
}
