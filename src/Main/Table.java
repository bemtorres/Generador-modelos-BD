/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.Attribute;
import java.util.ArrayList;

/**
 *
 * @author mrbm
 */
public class Table {
    private String name;
    private ArrayList<Attribute> attributes;

    public Table(String name, ArrayList<Attribute> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public Table() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Table{" + "name=" + name + ", attributes=" + attributes + '}';
    }
    
    
    /**
    * Este metodo convierte la columna en Lower Camel Case: hola_mundo -> holaMundo
    * @author Bemtorres
    * @return String: las primera letra en minuscula
    */
    public String toNameTable(){
        String[] names = this.getName().toLowerCase().split("_");
        String nameTable = "";
        for (int i = 0; i < names.length ; i++) {
            nameTable += names[i].substring(0, 1).toUpperCase() + names[i].substring(1).toLowerCase();
        }
        return nameTable;
    }
    
}
