/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package inventario;

import conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class consultar {

    public static void main(String[] args) {

        try {

            // CONECTAR CON MYSQL
            conexion con = new conexion();
            Connection cn = con.getConnection();

            // CREAR CONSULTA
            Statement st = cn.createStatement();

            // CONSULTAR INVENTARIO
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM inventario"
            );

            System.out.println("========== INVENTARIO MASTER MOTOS ==========");

            // RECORRER Y MOSTRAR LOS PRODUCTOS
            while (rs.next()) {

                System.out.println(
                        "Codigo: " + rs.getString("codigo")
                        + " | Nombre: " + rs.getString("nombre")
                        + " | Modelo: " + rs.getString("modelo")
                        + " | Cantidad: " + rs.getString("cantidad")
                        + " | Marca: " + rs.getString("marca")
                        + " | Proveedor: " + rs.getString("proveedor")
                        + " | Precio: " + rs.getString("precio")
                );

            }

            // CERRAR CONEXION Y CONSULTA
            rs.close();
            st.close();
            cn.close();

        } catch (SQLException ex) {

            Logger.getLogger(consultar.class.getName())
                    .log(Level.SEVERE, "Error al consultar inventario", ex);

        }

    }
}


