/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Main.Conexion;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author mrbm
 */
public class Method {
//
//    private Conexion conn;
//    
//    public Method(){
//        this.conn = new Conexion();
//    }
//    
//    public String chatObtener(int idConversacion) {
//
//               
//        CallableStatement cstm = null;
//
//        try {
//
//            cstm = conn.getConnection().prepareCall("begin ? := func_mensajes_obtener(?); end;");
//            cstm.registerOutParameter(1, OracleTypes.CURSOR);
//            cstm.setInt(2, idConversacion);
//            cstm.execute();
//
//            ResultSet cursor = (ResultSet) cstm.getObject(1);
//
//            while (cursor.next()) {
////                // obtiene datos
////                Date horaenvio = cursor.getDate("horaenvio");
////                String texto = cursor.getString("texto");
////                int idAutor = cursor.getInt("id_autor");
////                //crea objetos
////                Usuario autor = Chat.getUsuario(idAutor);
////                Mensaje mensajito = new Mensaje(autor, horaenvio, true, texto);
////                // agrega mensaje
////                mensajes2.add(mensajito);
//            }
//            
//
//            conn.close();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//      
//        try {
//            
//            cstm = conn.getConnection().prepareCall("begin ? := FUNC_BUSCAR_ENVIAR_CORREO(?,?,?); end;");
//
////            cstm.registerOutParameter(1, Types.VARCHAR);
////            cstm.setString(2, texto);
////            cstm.setInt(3, i); //valor i por entrada
//
//            cstm.executeUpdate();
//            String respuesta = cstm.getString(1);
//
//            cstm.close();
//            conn.close();
//
//        } catch (SQLException e) {
//            return "-1";
//        }
//    }
}
