/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciossql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denos
 */
public class LeerCSV {

    BufferedReader bufferedReader;
    
    public LeerCSV(String path){
        
        try {
            //FileReader fileReader = new FileReader(new File(path));
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "ISO-8859-1"));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(LeerCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<String> LeerLinea() throws IOException{
        List<String> libroCompleto = new ArrayList<>();
        String cadena ="";
        int caracter;
        
        while ((caracter = bufferedReader.read())!=10 && caracter!=-1){
            if (";".equals(String.valueOf((char) caracter))){
                //System.out.println(cadena);
                if ( "".equals(cadena)){
                    cadena="N.C";
                }
                libroCompleto.add(cadena);
                cadena = "";
            }
            else{
                cadena = cadena + (char) caracter;
            }
        }
        
        libroCompleto.add(cadena);
        
        if ( caracter == -1){
            return null;
        }
        else{
            return libroCompleto;
        }
    }
}
