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

    
    private String findAttribute(){
        
        //
        String[] types = {"number","date","varchar2","time",};
        String[] vars  = {"int","string","string","string",};
        
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
    
}
