/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ventas;

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

            // CONSULTAR VENTAS
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM ventas"
            );

            System.out.println("========== VENTAS MASTER MOTOS ==========");

            // RECORRER Y MOSTRAR LAS VENTAS
            while (rs.next()) {

                System.out.println(
                        "Nombre de repuesto: " + rs.getString("nombre de repuesto")
                        + " | Precio: " + rs.getString("precio")
                        + " | Mano de obra: " + rs.getString("mano de obra")
                        + " | Total: " + rs.getString("total")
                );

            }

            // CERRAR CONEXION Y CONSULTA
            rs.close();
            st.close();
            cn.close();

        } catch (SQLException ex) {

            Logger.getLogger(consultar.class.getName())
                    .log(Level.SEVERE, "Error al consultar ventas", ex);

        }

    }
}
