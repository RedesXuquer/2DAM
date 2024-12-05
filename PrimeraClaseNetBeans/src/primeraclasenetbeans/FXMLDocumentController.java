/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package primeraclasenetbeans;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author denos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","");
        try {
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM country");
        while(rs.next()) {
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9)+" "+rs.getString(10) +" "+rs.getString(11)+" "+rs.getString(12)+" "+rs.getString(13)+" "+rs.getString(14));
        }
        rs.close();
        stmt.close();
        
        } catch (Exception e) {
        System.out.println(e);
        }
        
        PreparedStatement psInsertar = con.prepareStatement("INSERT INTO city (Name, CountryCode, District, Population) VALUES (?,?,?,?)");
        psInsertar.setString(1,"Alzira");
        psInsertar.setString(2,"ESP");
        psInsertar.setString(3,"ESP");
        psInsertar.setInt(4, 1000);
        int resultadoInsertar = psInsertar.executeUpdate();
            
        
        Statement stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM city where ID=4087");
        
        con.close();    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
