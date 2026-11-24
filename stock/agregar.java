
package stock;

import conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class agregar {

    public static void main(String[] args) {

        try {
            // CONEXION A MYSQL
            conexion con = new conexion();
            Connection cn = con.getConnection();

            Statement st;
            ResultSet rs;

            // DATOS DEL PRODUCTO
            String codigo = "3328";
            String nombre = "BUJIA";
            String modelo = "GN";
            String cantidad = "30";
            String marca = "NGK";
            String empresa = "INTEGRANDO";

            // INSTRUCCION SQL
            String sql = "INSERT INTO stock "
                    + "(codigo, nombre, modelo, cantidad, marca, empresa) "
                    + "VALUES ('" + codigo + "', '" + nombre + "', '"
                    + modelo + "', '" + cantidad + "', '"
                    + marca + "', '" + empresa + "')";

            // EJECUTAR INSERCION
            st = cn.createStatement();
            st.executeUpdate(sql);

            System.out.println("Producto agregado correctamente");

            // CONSULTAR STOCK
            rs = st.executeQuery("SELECT * FROM stock");

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

            // CERRAR CONEXIONES
            rs.close();
            st.close();
            cn.close();

        } catch (SQLException ex) {
            Logger.getLogger(agregar.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}
