/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package proveedores;

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
                    "SELECT * FROM proveedores"
            );

            System.out.println("========== INVENTARIO MASTER MOTOS ==========");

            // RECORRER Y MOSTRAR LOS PRODUCTOS
            while (rs.next()) {

                System.out.println(
                        "Codigo: " + rs.getString("nombre")
                        + " | Nombre: " + rs.getString("NIT")
                        + " | Modelo: " + rs.getString("vendedor")
                        + " | Cantidad: " + rs.getString("numero de telefono")
                        + " | Marca: " + rs.getString("convenio")
                       
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


