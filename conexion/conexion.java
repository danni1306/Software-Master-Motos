
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

    Connection con;

    public conexion() throws SQLException {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/master_motos",
                    "root",
                    "DANDAN13"
            );

            System.out.println("Conectado correctamente a MySQL");

        } catch (ClassNotFoundException e) {

            throw new SQLException("No se encontró el controlador MySQL", e);

        }
    }

    public Connection getConnection() {
        return con;
    }
}


