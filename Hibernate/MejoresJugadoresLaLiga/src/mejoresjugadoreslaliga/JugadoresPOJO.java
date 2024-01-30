/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mejoresjugadoreslaliga;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author denos
 */

@Entity
@Table(name = "mejoresjugadores")

public class JugadoresPOJO {
    
    @Id @Column(name = "id") private int id;
    @Column(name = "nombre") private String nombre;
    @Column(name = "equipo") private String ewuipo;
    @Column(name = "golesJugador") private int golesJugador;
    @Column(name = "golesEquipo") private int golesEquipo;
    @Column(name = "contribucion") private int contribucion;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEwuipo() {
        return ewuipo;
    }

    public void setEwuipo(String ewuipo) {
        this.ewuipo = ewuipo;
    }

    public int getGolesJugador() {
        return golesJugador;
    }

    public void setGolesJugador(int golesJugador) {
        this.golesJugador = golesJugador;
    }

    public int getGolesEquipo() {
        return golesEquipo;
    }

    public void setGolesEquipo(int golesEquipo) {
        this.golesEquipo = golesEquipo;
    }

    public int getContribucion() {
        return contribucion;
    }

    //@Id @Column(name = "songId") private int id;
    public void setContribucion(int contribucion) {
        this.contribucion = contribucion;
    }
    
    
}
