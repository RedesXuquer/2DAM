/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author denos
 */
public class ModelSQL {
    
    Connection con;
    
    public ModelSQL(String BBDD, String User, String Pass) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+BBDD,User,Pass);
        System.out.println("Conexión realizada");
    }

    public Integer Actualizar(Integer Id, String nombre,Double precio,String categoria) throws SQLException{
        PreparedStatement preparedStatement = con.prepareStatement("update producto set nombre=?, precio=?, categoria=? where id=?");
        preparedStatement.setString(1, nombre);
        preparedStatement.setDouble(2, precio);
        preparedStatement.setString(3, categoria);
        preparedStatement.setInt(4, Id);
        return preparedStatement.executeUpdate();
    }

    public int Delete(Integer Id) throws SQLException{
        PreparedStatement preparedStatement = con.prepareStatement("delete from producto where id=?");
        preparedStatement.setInt(1, Id);
        return preparedStatement.executeUpdate();
    }
    
    /*
    
        // Indicamos el tipo ID y le marcamos el nombre de la columna, en este caso songId. Después le marcamos el tipo de dato, en este caso **int** y el nombre de la variable id.
    @Id @Column(name = "id") private int id;

    // Indicamos el nombre de la segunda columna **songName**. Después le marcamos el tipo de dato, en este caso **String** y el nombre de la variable songName.
    @Column(name = "nombre") private String nombre;
 
    // Indicamos el nombre de la tercera columna **singer**. Después le marcamos el tipo de dato, en este caso **String** y el nombre de la variable artist.
    @Column(name = "precio") private Double precio;

    // Indicamos el nombre de la tercera columna **singer**. Después le marcamos el tipo de dato, en este caso **String** y el nombre de la variable artist.
    @Column(name = "categoria") private String categoria;
    
    
    
    
    
    
    
    
    */
    
    
}
