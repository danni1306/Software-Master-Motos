
package proveedores;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class eliminar {

    public static void main(String[] args) {

        // NOMBRE DEL PROVEEDOR A ELIMINAR
        String nombre_eliminar = "HA BICICLETAS";

        // INSTRUCCION SQL
        String sql = "DELETE FROM proveedores WHERE nombre = ?";

        try {

            // CONECTAR CON MYSQL
            conexion con = new conexion();
            Connection cn = con.getConnection();

            // PREPARAR CONSULTA
            PreparedStatement ps = cn.prepareStatement(sql);

            // ASIGNAR NOMBRE DEL PROVEEDOR
            ps.setString(1, nombre_eliminar);

            // EJECUTAR ELIMINACION
            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                System.out.println("Proveedor eliminado correctamente");
            } else {
                System.out.println("No se encontro el proveedor");
            }

            // CONSULTAR PROVEEDORES
            String consulta = "SELECT * FROM proveedores";

            PreparedStatement psConsulta =
                    cn.prepareStatement(consulta);

            ResultSet rs = psConsulta.executeQuery();

            // MOSTRAR PROVEEDORES RESTANTES
            System.out.println("========== PROVEEDORES ==========");

            while (rs.next()) {

                System.out.println(
                        rs.getString("nombre") + " - "
                        + rs.getString("nit") + " - "
                        + rs.getString("vendedor") + " - "
                        + rs.getString("numero de telefono") + " - "
                        + rs.getString("convenio")
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
