/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoxml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author denos
 */
public class ApoyoXML {
    
    List<NotasPOJO> listaNotas = new ArrayList<>();
    
    public void LeerXML(String path) throws SAXException, ParserConfigurationException, IOException{
        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
        Document document = dbBuilder.parse(new File(path));
        
        Element raiz = document.getDocumentElement();
        System.out.println("Contenido XML " + raiz.getNodeName() + ":");
        NodeList nodeList = document.getElementsByTagName("alumno");
        
        for (int i=0;i<nodeList.getLength();i++){
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element eElement = (Element) node;
                NotasPOJO alumno = new NotasPOJO();
                alumno.setID(Integer.parseInt(eElement.getAttribute("id")));
                alumno.setDNI(eElement.getElementsByTagName("DNI").item(0).getTextContent());
                alumno.setNombre(eElement.getElementsByTagName("Nombre").item(0).getTextContent());
                alumno.setNota(Double.parseDouble(eElement.getElementsByTagName("Nota").item(0).getTextContent()));
                listaNotas.add(alumno);
            }
        }
    }
    
    public NotasPOJO Read(int index){
        return listaNotas.get(index);
    }
    
    public void Delete(int index){
        listaNotas.remove(index);
    }
    
    public void Create(String DNI, String nombre, Double nota ){
        NotasPOJO nuevo = new NotasPOJO();
        
        nuevo.setID(listaNotas.size());
        nuevo.setDNI(DNI);
        nuevo.setNombre(nombre);
        nuevo.setNota(nota);
        
        listaNotas.add(nuevo);
    }    
    
    public void update(Integer position, String DNI, String nombre, Double nota ){
        //listaNotas.get(position).setID(id);
        listaNotas.get(position).setDNI(DNI);
        listaNotas.get(position).setNombre(nombre);
        listaNotas.get(position).setNota(nota);
    }    

    public int registros(){
        return listaNotas.size();
    }
    
    public void EscribirXML(String path) throws TransformerConfigurationException, TransformerException, ParserConfigurationException{
        // Crear un documento XML vacío
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        // Crear el elemento raíz
        Element rootElement = doc.createElement("notas");
        doc.appendChild(rootElement);

        for (NotasPOJO notas: listaNotas ){
            
            
            // Agregar elementos y datos al documento
            Element childElement = doc.createElement("alumno");
            childElement.setAttribute("id", String.valueOf(notas.getID()));

            // Agregamos bicicleta con ID=1 al root Bicicletas
            rootElement.appendChild(childElement);
            
            
            // Agregar elementos dentro de bicicleta -> marca
            Element dni = doc.createElement("DNI");
            dni.appendChild(doc.createTextNode(notas.getDNI()));        
            childElement.appendChild(dni);

            // Agregar elementos dentro de bicicleta -> modelo
            Element nombre = doc.createElement("Nombre");
            nombre.appendChild(doc.createTextNode(notas.getNombre()));
            childElement.appendChild(nombre);

            // Agregar elementos dentro de bicicleta -> anyo
            Element nota = doc.createElement("Nota");
            nota.appendChild(doc.createTextNode(String.valueOf(notas.getNota())));
            childElement.appendChild(nota);   

            
        }
        // Guardar el documento XML en un archivo
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();        
        
        // Formateamos el fichero XML
        Properties outputProperties = new Properties();
        
        // Aquí marcamos que la tabulación debe ser de 4 espacios
        outputProperties.setProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        
        // Aquí marcamos que queremos la tabulación
        outputProperties.setProperty(OutputKeys.INDENT, "yes");
        
        // Aquí marcamos que queremos la inicialización del archivo XML
        outputProperties.setProperty(OutputKeys.OMIT_XML_DECLARATION, "no");

        // Aplicamos las propiedades del fichero XML
        transformer.setOutputProperties(outputProperties);  // Opcional: dar formato al archivo

        // Especifica la ruta del archivo en el que deseas guardar el XML
        File xmlFile = new File(path);

        // Guarda el documento XML en el archivo especificado
        Result output = new StreamResult(xmlFile);
        transformer.transform(new DOMSource(doc), output);

        System.out.println("Archivo XML generado correctamente.");
    }
    
}
