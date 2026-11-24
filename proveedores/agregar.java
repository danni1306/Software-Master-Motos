package proveedores;

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
            // Conexión a la base de datos
            conexion con = new conexion();
            Connection cn = con.getConnection();

            Statement st;
            ResultSet rs;

            // Datos del proveedor
            String nombre = "BICICLETA";
            String nit = "900123456";
            String vendedor = "Carlos";
            String telefono = "3001234567";
            String convenio = "1232";

            // Instrucción SQL
            String sql = "INSERT INTO proveedores "
                    + "(nombre, nit, vendedor, `numero de telefono`, convenio) "
                    + "VALUES ('" + nombre + "', '" + nit + "', '"
                    + vendedor + "', '" + telefono + "', '"
                    + convenio + "')";

            // Ejecutar inserción
            st = cn.createStatement();
            st.executeUpdate(sql);

            System.out.println("Proveedor agregado correctamente");

            // Consultar proveedores
            rs = st.executeQuery("SELECT * FROM proveedores");

            while (rs.next()) {
                System.out.println(
                        rs.getString("nombre") + " - "
                        + rs.getString("nit") + " - "
                        + rs.getString("vendedor") + " - "
                        + rs.getString("numero de telefono") + " - "
                        + rs.getString("convenio")
                );
            }

            // Cerrar conexiones
            rs.close();
            st.close();
            cn.close();

        } catch (SQLException ex) {
            Logger.getLogger(agregar.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}