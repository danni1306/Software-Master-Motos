/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ventas;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class eliminar {

    public static void main(String[] args) {

        // NOMBRE DEL REPUESTO A ELIMINAR
        String nombre_eliminar = "BUJIA";

        // INSTRUCCION SQL
        String sql = "DELETE FROM ventas WHERE `nombre de repuesto` = ?";

        try {

            // CONECTAR CON MYSQL
            conexion con = new conexion();
            Connection cn = con.getConnection();

            // PREPARAR CONSULTA
            PreparedStatement ps = cn.prepareStatement(sql);

            // ASIGNAR NOMBRE DEL REPUESTO
            ps.setString(1, nombre_eliminar);

            // EJECUTAR ELIMINACION
            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                System.out.println("Venta eliminada correctamente");
            } else {
                System.out.println("No se encontro la venta");
            }

            // CONSULTAR VENTAS
            String consulta = "SELECT * FROM ventas";

            PreparedStatement psConsulta =
                    cn.prepareStatement(consulta);

            ResultSet rs = psConsulta.executeQuery();

            // MOSTRAR VENTAS RESTANTES
            System.out.println("========== VENTAS MASTER MOTOS ==========");

            while (rs.next()) {

                System.out.println(
                        "Nombre de repuesto: " + rs.getString("nombre de repuesto")
                        + " | Precio: " + rs.getString("precio")
                        + " | Mano de obra: " + rs.getString("mano de obra")
                        + " | Total: " + rs.getString("total")
                );
            }

            // CERRAR RECURSOS
            rs.close();
            psConsulta.close();
            ps.close();
            cn.close();

        } catch (SQLException ex) {

            Logger.getLogger(eliminar.class.getName())
                    .log(Level.SEVERE, null, ex);

        }
    }
}
