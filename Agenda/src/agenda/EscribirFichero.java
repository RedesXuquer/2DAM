/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author denos
 */
public class EscribirFichero {
    
    FileWriter fw;
    BufferedWriter bw;
    
    public EscribirFichero(String path) throws IOException {
        
        File f = new File(path);
        this.fw = new FileWriter(f);
        this.bw = new BufferedWriter(fw);
    }
    
    public void Escribir(String linea) throws IOException {
        this.bw.write(linea);
    }
    
    public void Cerrar() throws IOException{
        this.bw.close();
        this.fw.close();
    }
    
}
