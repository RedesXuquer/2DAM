/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicialsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author denos
 */
public class ConexionSQL {
    
    Connection conexion;
    Statement statement;
    ResultSet resultado;

    public void nueva(String BBDD, String user, String pass) {
            // Parámetros de conexión a la base de datos

        try {
            // Establecer la conexión con la base de datos
            conexion = DriverManager.getConnection((String) "jdbc:mysql://localhost:3306/" + BBDD, user, pass);

            // Crear una declaración SQL
            statement = conexion.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public ResultSet read(String consulta) throws SQLException{
        
        resultado = statement.executeQuery(consulta);
        
        return resultado;
    }
    
    public int createS(String Name, String CC, String District, String Population){
        
        int filasInsertadas = 0;
        
        try {

            // Crear la sentencia SQL de inserción
            String consulta = "INSERT INTO city (Name, CountryCode, District, Population) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
            preparedStatement.setString(1, Name);
            preparedStatement.setString(2, CC);
            preparedStatement.setString(3, District);
            preparedStatement.setString(4, Population);

            // Ejecutar la sentencia SQL para insertar los datos
            filasInsertadas = preparedStatement.executeUpdate();

            // Comprobar si la inserción fue exitosa
            if (filasInsertadas > 0) {
                System.out.println("Datos insertados con éxito.");
            } else {
                System.out.println("La inserción falló.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return filasInsertadas;
    }
    
    public int CUD(String consulta){

        int filasAfectadas = 0;

        try {

            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            // Ejecutar la sentencia SQL para insertar los datos
            filasAfectadas = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filasAfectadas;
    }
    
    
    public void finalizar() throws SQLException{
        // Cerrar la conexión y recursos
        resultado.close();
        statement.close();
        conexion.close();
    }
}
