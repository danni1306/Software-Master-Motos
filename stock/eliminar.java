
package stock;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class eliminar {

    public static void main(String[] args) {

        // CODIGO DEL PRODUCTO A ELIMINAR
        String codigo_eliminar = "3328";

        // INSTRUCCION SQL
        String sql = "DELETE FROM stock WHERE codigo = ?";

        try {

            // CONECTAR CON MYSQL
            conexion con = new conexion();
            Connection cn = con.getConnection();

            // PREPARAR CONSULTA
            PreparedStatement ps = cn.prepareStatement(sql);

            // ASIGNAR CODIGO DEL PRODUCTO
            ps.setString(1, codigo_eliminar);

            // EJECUTAR ELIMINACION
            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                System.out.println("Producto eliminado correctamente");
            } else {
                System.out.println("No se encontro el producto");
            }

            // CONSULTAR STOCK
            String consulta = "SELECT * FROM stock";

            PreparedStatement psConsulta =
                    cn.prepareStatement(consulta);

            ResultSet rs = psConsulta.executeQuery();

            // MOSTRAR PRODUCTOS RESTANTES
            System.out.println("========== STOCK ==========");

            while (rs.next()) {

                System.out.println(
                        rs.getString("codigo") + " - "
                        + rs.getString("nombre") + " - "
                        + rs.getString("modelo") + " - "
                        + rs.getString("cantidad") + " - "
                        + rs.getString("marca") + " - "
                        + rs.getString("empresa")
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
