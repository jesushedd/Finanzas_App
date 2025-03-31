package org.vjhe.finanzas.modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mariadb://localhost:3306/finanzas";
    private static final String USER = "root";
    private static final String PSWRD = "123456";

    private static Connection connection;

    public static Connection getConnection()  {
        if (connection == null){
            try {
                connection = DriverManager.getConnection(URL, USER, PSWRD);
            } catch (SQLException e) {
                throw new RuntimeException("Error al intentar conectar a la DB" ,e);
            }
        }

        return connection;
    }
}
