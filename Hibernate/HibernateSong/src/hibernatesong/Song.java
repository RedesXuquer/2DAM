/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernatesong;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author denos
 */

@Entity
// Seleccionamos el nombre de la tabla
@Table(name = "song")

// POJO class
public class Song {

    // Indicamos el tipo ID y le marcamos el nombre de la columna, en este caso songId. Después le marcamos el tipo de dato, en este caso **int** y el nombre de la variable id.
    @Id @Column(name = "songId") private int id;

    // Indicamos el nombre de la segunda columna **songName**. Después le marcamos el tipo de dato, en este caso **String** y el nombre de la variable songName.
    @Column(name = "songName") private String songName;
 
    // Indicamos el nombre de la tercera columna **singer**. Después le marcamos el tipo de dato, en este caso **String** y el nombre de la variable artist.
    @Column(name = "singer") private String artist;
 
    // Método con el cual devolvemos el ID
    public int getId() { return id; }
 
    // Método con el cual establecemos el ID
    public void setId(int id) { this.id = id; }
 
    // Método con el cual devolvemos el nombre de la canción
    public String getSongName() { return songName; }

    // Método con el cual establecemos el nombre de la canción 
    public void setSongName(String songName)
    {
        this.songName = songName;
    }

    // Método con el cual devolvemos el nombre del artista
    public String getArtist() { return artist; }

    // Método con el cual establecemos el nombre del artista 
    public void setArtist(String artist)
    {
        this.artist = artist;
    }
}
