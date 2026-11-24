
package stock;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class editar {

    public static void main(String[] args) {

        // CODIGO DEL PRODUCTO QUE SE DESEA EDITAR
        String codigo_editar = "3328";

        // NUEVOS DATOS DEL PRODUCTO
        String new_nombre = "BUJIA";
        String new_modelo = "GN";
        String new_cantidad = "30";
        String new_marca = "NGK";
        String new_empresa = "INTEGRANDO";

        // INSTRUCCION SQL
        String sql = "UPDATE stock SET "
                + "nombre = ?, "
                + "modelo = ?, "
                + "cantidad = ?, "
                + "marca = ?, "
                + "empresa = ? "
                + "WHERE codigo = ?";

        try {

            // CONECTAR CON MYSQL
            conexion con = new conexion();
            Connection cn = con.getConnection();

            // PREPARAR CONSULTA
            PreparedStatement ps = cn.prepareStatement(sql);

            // ASIGNAR NUEVOS VALORES
            ps.setString(1, new_nombre);
            ps.setString(2, new_modelo);
            ps.setString(3, new_cantidad);
            ps.setString(4, new_marca);
            ps.setString(5, new_empresa);
            ps.setString(6, codigo_editar);

            // EJECUTAR ACTUALIZACION
            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                System.out.println("Producto actualizado correctamente");
            } else {
                System.out.println("No se encontro el producto");
            }

            // CONSULTAR STOCK
            String consulta = "SELECT * FROM stock";

            PreparedStatement psConsulta =
                    cn.prepareStatement(consulta);

            ResultSet rs = psConsulta.executeQuery();

            // MOSTRAR PRODUCTOS
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

            Logger.getLogger(editar.class.getName())
                    .log(Level.SEVERE, null, ex);

        }
    }
}

package stock;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class editar {

    public static void main(String[] args) {

        // CODIGO DEL PRODUCTO QUE SE DESEA EDITAR
        String codigo_editar = "3328";

        // NUEVOS DATOS DEL PRODUCTO
        String new_nombre = "BUJIA";
        String new_modelo = "GN";
        String new_cantidad = "30";
        String new_marca = "NGK";
        String new_empresa = "INTEGRANDO";

        // INSTRUCCION SQL
        String sql = "UPDATE stock SET "
                + "nombre = ?, "
                + "modelo = ?, "
                + "cantidad = ?, "
                + "marca = ?, "
                + "empresa = ? "
                + "WHERE codigo = ?";

        try {

            // CONECTAR CON MYSQL
            conexion con = new conexion();
            Connection cn = con.getConnection();

            // PREPARAR CONSULTA
            PreparedStatement ps = cn.prepareStatement(sql);

            // ASIGNAR NUEVOS VALORES
            ps.setString(1, new_nombre);
            ps.setString(2, new_modelo);
            ps.setString(3, new_cantidad);
            ps.setString(4, new_marca);
            ps.setString(5, new_empresa);
            ps.setString(6, codigo_editar);

            // EJECUTAR ACTUALIZACION
            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                System.out.println("Producto actualizado correctamente");
            } else {
                System.out.println("No se encontro el producto");
            }

            // CONSULTAR STOCK
            String consulta = "SELECT * FROM stock";

            PreparedStatement psConsulta =
                    cn.prepareStatement(consulta);

            ResultSet rs = psConsulta.executeQuery();

            // MOSTRAR PRODUCTOS
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

            Logger.getLogger(editar.class.getName())
                    .log(Level.SEVERE, null, ex);

        }
    }
}
