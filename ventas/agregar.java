
package ventas;

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

            // DATOS DE LA VENTA
            String nombre_repuesto = "BUJIA";
            double precio = 15000;
            double mano_obra = 5000;
            double total = precio + mano_obra;

            // INSTRUCCION SQL
            String sql = "INSERT INTO ventas "
                    + "(`nombre de repuesto`, precio, `mano de obra`, total) "
                    + "VALUES ('" + nombre_repuesto + "', "
                    + precio + ", "
                    + mano_obra + ", "
                    + total + ")";

            // EJECUTAR INSERCION
            st = cn.createStatement();
            st.executeUpdate(sql);

            System.out.println("Venta agregada correctamente");

            // CONSULTAR VENTAS
            rs = st.executeQuery("SELECT * FROM ventas");

            // MOSTRAR VENTAS
            System.out.println("========== VENTAS ==========");

            while (rs.next()) {
                System.out.println(
                        rs.getString("nombre de repuesto") + " - "
                        + rs.getString("precio") + " - "
                        + rs.getString("mano de obra") + " - "
                        + rs.getString("total")
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
