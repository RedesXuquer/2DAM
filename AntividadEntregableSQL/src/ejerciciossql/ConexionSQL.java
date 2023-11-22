/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciossql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author denos
 */
public class ConexionSQL {

    Connection con;
    
    public ConexionSQL(String BBDD, String User, String Pass) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+BBDD,User,Pass);
        System.out.println("Conexión realizada");
    }

    public ResultSet Read(String consulta) throws SQLException{
        PreparedStatement preparedStatement = con.prepareStatement(consulta);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;   
    }

    public int Ejecutar(String titulo,String autor,String anyoNacimiento,String anyoPublicacion, String editorial, String nPaginas) throws SQLException{
        PreparedStatement preparedStatement = con.prepareStatement("Insert into libros (titulo, autor, anyoNacimiento, anyoPublicacion, editorial, nPaginas ) values (?,?,?,?,?,?)");
        preparedStatement.setString(1, titulo);
        preparedStatement.setString(2, autor);
        preparedStatement.setString(3, anyoNacimiento);
        preparedStatement.setString(4, anyoPublicacion);
        preparedStatement.setString(5, editorial);
        preparedStatement.setString(6, nPaginas);
        return preparedStatement.executeUpdate();
    }
/*
    public Integer Ejecutar(Integer Id, String Name,String CC,String District,String Population) throws SQLException{
        PreparedStatement preparedStatement = con.prepareStatement("update city set Name=?, CountryCode=?, District=?, Population=? where id=?");
        preparedStatement.setString(1, Name);
        preparedStatement.setString(2, CC);
        preparedStatement.setString(3, District);
        preparedStatement.setString(4, Population);
        preparedStatement.setInt(5, Id);
        return preparedStatement.executeUpdate();
    }
*/
    public int Delete(Integer Id) throws SQLException{
        PreparedStatement preparedStatement = con.prepareStatement("delete from city where id=?");
        preparedStatement.setInt(1, Id);
        return preparedStatement.executeUpdate();
    }
}
