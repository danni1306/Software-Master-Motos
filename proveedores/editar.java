
package proveedores;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class editar {

    public static void main(String[] args) {

        // NOMBRE DEL PROVEEDOR QUE SE DESEA EDITAR
        String nombre_editar = "HA BICICLETAS";

        // NUEVOS DATOS DEL PROVEEDOR
        String new_vendedor = "Andres";
        String new_telefono = "3101234567";
        String new_convenio = "12345";

        // INSTRUCCION SQL
        String sql = "UPDATE proveedores SET "
                + "vendedor = ?, "
                + "`numero de telefono` = ?, "
                + "convenio = ? "
                + "WHERE nombre = ?";

        try {

            // CONECTAR CON MYSQL
            conexion con = new conexion();
            Connection cn = con.getConnection();

            // PREPARAR CONSULTA
            PreparedStatement ps = cn.prepareStatement(sql);

            // ASIGNAR NUEVOS VALORES
            ps.setString(1, new_vendedor);
            ps.setString(2, new_telefono);
            ps.setString(3, new_convenio);
            ps.setString(4, nombre_editar);

            // EJECUTAR ACTUALIZACION
            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                System.out.println("Proveedor actualizado correctamente");
            } else {
                System.out.println("No se encontro el proveedor");
            }

            // CONSULTAR PROVEEDORES
            String consulta = "SELECT * FROM proveedores";

            PreparedStatement psConsulta =
                    cn.prepareStatement(consulta);

            ResultSet rs = psConsulta.executeQuery();

            // MOSTRAR PROVEEDORES
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

            Logger.getLogger(editar.class.getName())
                    .log(Level.SEVERE, null, ex);

        }
    }
}
