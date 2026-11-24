
package inventario;

import conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class agregar {

    public static void main(String[] args) {

        Connection cn;
        Statement st;
        ResultSet rs;

        String codigo = "42345";
        String nombre = "Bandas de freno";
        String modelo = "GS 125";
        String cantidad = "6";
        String marca = "GX Motor";
        String proveedor = "HA BICICLETAS";
        String precio = "20000";

        String sql = "INSERT INTO inventario "
                + "(codigo, nombre, modelo, cantidad, marca, proveedor, precio) "
                + "VALUES ('" + codigo + "', '" + nombre + "', '"
                + modelo + "', '" + cantidad + "', '" + marca
                + "', '" + proveedor + "', '" + precio + "')";

        try {

            conexion con = new conexion();

            cn = con.getConnection();
            st = cn.createStatement();

            st.executeUpdate(sql);

            System.out.println("Producto agregado correctamente");

            rs = st.executeQuery("SELECT * FROM inventario");

            while (rs.next()) {

                System.out.println(
                        rs.getString("codigo") + " - "
                        + rs.getString("nombre") + " - "
                        + rs.getString("modelo") + " - "
                        + rs.getString("cantidad") + " - "
                        + rs.getString("marca") + " - "
                        + rs.getString("proveedor") + " - "
                        + rs.getString("precio")
                );

            }

        } catch (SQLException ex) {

            Logger.getLogger(agregar.class.getName())
                    .log(Level.SEVERE, null, ex);

        }

    }
}
