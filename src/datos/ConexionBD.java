/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

/**
 *
 * @author Daryelin
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Clase encargada exclusivamente de abrir la conexión JDBC hacia la base
 * de datos MySQL. Ajusta URL, USUARIO y PASSWORD según tu entorno (XAMPP,
 * MySQL Workbench, etc.)
 */
public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/farmacia_db?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "daryelin123";

    private ConexionBD() {
        // Clase utilitaria, no se instancia
    }

    public static Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el driver JDBC de MySQL (mysql-connector-j). "
                    + "Verifique que el .jar esté en el classpath.", e);
        }
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
}