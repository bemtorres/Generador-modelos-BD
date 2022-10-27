/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.create;

import java.io.File;
import services.config.Config;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

/**
 *
 * @author benja
 */
public class CreateFolders {
        
    public void call() {
        create(Config.PATH_CONN,"conn");
        create(Config.PATH_MODELS,"modelo");
        create(Config.PATH_QUERIES,"query");
        create(Config.PATH_CRUD,"crudsql");
    }
    
    public void create(String path, String name) {
        delete(path);
    
        File directorio = new File(path);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado " + name);
            } else {
                System.out.println("Error al crear directorio");
            }
        }
    }
    
    public void delete(String path) {
        File directory = new File(path);
       
        if (directory.exists()) {
            Arrays.stream(Objects.requireNonNull(directory.listFiles()))
                    .filter(Predicate.not(File::isDirectory))
                    .forEach(File::delete);
           directory.delete();     
        }
    }
}
