/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package generadorpersonajes;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author denos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button button;
    @FXML
    private TextField fieldNombre;
    @FXML
    private TextField fieldFuerza;
    @FXML
    private TextField fieldDestreza;
    @FXML
    private TextField fieldConstitucion;
    @FXML
    private TextField fieldInteligencia;
    @FXML
    private TextField fieldSabiduria;
    @FXML
    private TextField fieldCarisma;
    @FXML
    private TextField fieldObjeto1;
    @FXML
    private TextField fieldObjeto2;
    @FXML
    private TextField fieldObjeto3;
    @FXML
    private TextField fieldObjeto4;
    @FXML
    private TextField fieldObjeto5;
    @FXML
    private TextField fieldObjeto6;
    @FXML
    private TextField fieldObjeto7;
    @FXML
    private TextField fieldObjeto8;
    @FXML
    private TextField fieldObjeto9;
    @FXML
    private TextField fieldObjeto10;
    @FXML
    private TextField fieldObjeto11;
    @FXML
    private TextField fieldObjeto12;
    @FXML
    private TextArea areaObjetos;
    @FXML
    private TextField fieldNombreEliminar;
    @FXML
    private TextArea AreaMostrarPersonajes;
    @FXML
    private Button buttonEliminarPersonaje;
    @FXML
    private Button buttonAnyadirPersonaje;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        // Tu array de elementos
        String[] elementos = {
            // Armas
            "Espadas", "Hachas", "Arcos", "Varitas mágicas", "Martillos", "Dagas",
            // Armas únicas con propiedades especiales
            "Espada flameante", "Arco de precisión",
            
            // Armaduras
            "Armaduras de cuero", "Armaduras de placas", "Armaduras de mallas", "Capas",
            // Armaduras encantadas
            "Armadura que otorga invisibilidad temporal",
            
            // Pociones y Elixires
            "Pociones de curación", "Pociones de resistencia", "Elixires de fuerza",
            // Pociones con efectos temporales
            "Poción de invisibilidad", "Poción de velocidad aumentada",
            
            // Objetos de Consumo
            "Comida", "Bebida",
            // Tabacos o hierbas
            "Tabacos", "Hierbas",
            
            // Reliquias y Artefactos
            "Objetos antiguos con propiedades mágicas o históricas",
            // Artefactos poderosos
            "Artefactos con habilidades únicas",
            
            // Gemas y Piedras Preciosas
            "Gemas mágicas que pueden utilizarse para encantar objetos",
            // Piedras que contienen energía elemental
            "Piedras que contienen energía elemental",
            
            // Herramientas Especiales
            "Ganchos", "Linternas", "Llaves maestras", "Mapas mágicos",
            // Herramientas con usos específicos
            "Herramientas para superar obstáculos en el juego",
            
            // Libros y Rollos
            "Libros de hechizos", "Pergaminos con información valiosa", "Mapas antiguos",
            // Textos que proporcionan conocimiento o desbloquean habilidades
            "Textos que proporcionan conocimiento o desbloquean habilidades",
            
            // Componentes de Hechizos
            "Ingredientes para rituales mágicos", "Polvos", "Plumas de criaturas mágicas",
            // Elementos necesarios para lanzar hechizos específicos
            "Elementos necesarios para lanzar hechizos específicos",
            
            // Mascotas y Compañeros
            "Animales entrenados", "Bestias místicas", "Criaturas mágicas como compañeros de aventura",
            // Mascotas con habilidades especiales
            "Mascotas con habilidades especiales que pueden ayudar en situaciones específicas",
            
            // Joyas Encantadas
            "Anillos", "Amuletos", "Pulseras con propiedades mágicas",
            // Joyas que otorgan bonificaciones a las estadísticas del personaje
            "Joyas que otorgan bonificaciones a las estadísticas del personaje",
            
            // Trofeos y Recompensas
            "Cabezas de monstruos derrotados", "Medallas de honor", "Estandartes de batalla",
            // Trofeos que pueden ser intercambiados por recompensas o reconocimientos en el juego
            "Trofeos que pueden ser intercambiados por recompensas o reconocimientos en el juego"
        };

        Random random = new Random();
        // Número de elementos a seleccionar al azar
        int cantidadSeleccion = random.nextInt(10) + 3;

        // Método para seleccionar elementos al azar
        String[] elementosSeleccionados = seleccionarAlAzar(elementos, cantidadSeleccion);

        // Imprimir los elementos seleccionados
        System.out.println("Elementos seleccionados al azar:");
        areaObjetos.setText("");
        for (String elemento : elementosSeleccionados) {
            areaObjetos.setText(areaObjetos.getText()+elemento+"\n");
        }
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    // Método para seleccionar elementos al azar
    public String[] seleccionarAlAzar(String[] array, int cantidad) {
        Random random = new Random();
        int longitudArray = array.length;

        // Verificar si la cantidad solicitada es mayor que la longitud del array
        if (cantidad > longitudArray) {
            throw new IllegalArgumentException("La cantidad solicitada es mayor que la longitud del array.");
        }

        // Array para almacenar los elementos seleccionados
        String[] seleccionados = new String[cantidad];

        // Índices ya seleccionados para evitar duplicados
        boolean[] indicesSeleccionados = new boolean[longitudArray];

        // Seleccionar elementos al azar
        for (int i = 0; i < cantidad; i++) {
            int indiceAleatorio;
            do {
                indiceAleatorio = random.nextInt(longitudArray);
            } while (indicesSeleccionados[indiceAleatorio]);

            // Marcar el índice como seleccionado
            indicesSeleccionados[indiceAleatorio] = true;

            // Asignar el elemento al array de elementos seleccionados
            seleccionados[i] = array[indiceAleatorio];
        }

        return seleccionados;
    }
}
