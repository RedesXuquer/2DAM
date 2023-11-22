/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author denos
 */

public class LeerFichero {

    BufferedReader br = null;
    FileReader fr = null;
    File f = null;

    public LeerFichero(String nombreFichero) throws FileNotFoundException {

        this.f = new File(nombreFichero);
        this.fr = new FileReader(f);
        this.br = new BufferedReader(fr);
    }

    public int leerCaracter() throws IOException {
        return this.br.read();
    }
    
    public String leerLinea() throws IOException {
        return this.br.readLine(); 
    }

    public void Cerrar() throws IOException {

        this.br.close();
        this.fr.close();

    }
}

