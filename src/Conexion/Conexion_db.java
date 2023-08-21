/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mariadb.jdbc.Connection;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author sotog
 */
public class Conexion_db {
    // private: Este modificador de acceso asegura que la variable sólo puede ser accedida directamente dentro de la clase en la que fue declarada
    // final :  Este modificador indica que una vez que se le asigna un valor a la variable (ya sea en el momento de la declaración o dentro del constructor de la clase), no puede ser cambiado
    // Declara variables para los detalles de conexión: nombre de la base de datos, usuario, contraseña

    private final String base = "bd_productos";
    private final String user = "root";
    private final String password = "";

    // Define la URL de conexión a la base de datos. Si en algún caso se usa MySQL, se debe cambiar el inicio de la URL.
    private final String url = "jdbc:mariadb://localhost:3306/" + base;
    // Declara una variable para la conexión
    private Connection con = null;

    public Connection getConexion() {

        try {
            // Intenta cargar el driver de MariaDB en memoria. Si se usase MySQL, se tendría que cargar el driver correspondiente.
            Class.forName("org.mariadb.jdbc.Driver");

            // Establece la conexión usando los detalles definidos anteriormente y la asigna a la variable con
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e) {
            // En caso de un error SQL, imprime el error
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            // En caso de que no se encuentre el driver, se registra el error con un logger
            Logger.getLogger(Conexion_db.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Retorna la conexión establecida o null en caso de que no se haya podido conectar
       return con;

}
    
}
