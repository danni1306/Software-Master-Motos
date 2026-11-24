
package ventas;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class editar {

    public static void main(String[] args) {

        // NOMBRE DEL REPUESTO QUE SE DESEA EDITAR
        String nombre_editar = "BUJIA";

        // NUEVOS DATOS DE LA VENTA
        String new_nombre = "BUJIA NGK";
        double new_precio = 18000;
        double new_mano_obra = 5000;
        double new_total = new_precio + new_mano_obra;

        // INSTRUCCION SQL
        String sql = "UPDATE ventas SET "
                + "`nombre de repuesto` = ?, "
                + "precio = ?, "
                + "`mano de obra` = ?, "
                + "total = ? "
                + "WHERE `nombre de repuesto` = ?";

        try {

            // CONECTAR CON MYSQL
            conexion con = new conexion();
            Connection cn = con.getConnection();

            // PREPARAR CONSULTA
            PreparedStatement ps = cn.prepareStatement(sql);

            // ASIGNAR NUEVOS VALORES
            ps.setString(1, new_nombre);
            ps.setDouble(2, new_precio);
            ps.setDouble(3, new_mano_obra);
            ps.setDouble(4, new_total);
            ps.setString(5, nombre_editar);

            // EJECUTAR ACTUALIZACION
            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                System.out.println("Venta actualizada correctamente");
            } else {
                System.out.println("No se encontro la venta");
            }

            // CONSULTAR VENTAS
            String consulta = "SELECT * FROM ventas";

            PreparedStatement psConsulta =
                    cn.prepareStatement(consulta);

            ResultSet rs = psConsulta.executeQuery();

            // MOSTRAR VENTAS
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

            Logger.getLogger(editar.class.getName())
                    .log(Level.SEVERE, null, ex);

        }
    }
}
