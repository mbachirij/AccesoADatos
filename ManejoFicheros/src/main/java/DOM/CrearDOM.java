/*
Creación de xml básico


 */
package DOM;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Vespertino
 */
public class CrearDOM {

    /**
     * @param args the command line arguments
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws javax.xml.transform.TransformerConfigurationException
     */
        public static void main(String[] args) throws ParserConfigurationException, TransformerException {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            // Nodo raíz
            Element personas = doc.createElement("Personas");
            doc.appendChild(personas);

            // Nodo persona
            Element persona = doc.createElement("Persona");
            persona.setAttribute("id", "1");

            Element nombre = doc.createElement("nombre");
            nombre.setTextContent("pepe");

            Element apellidos = doc.createElement("apellidos");
            apellidos.setTextContent("garcia");

            Element edad = doc.createElement("edad");
            edad.setTextContent("23");
           
            Element fechaNac = doc.createElement("FechaNacimiento");
            Element mes = doc.createElement("mes");
            mes.setTextContent("Noviembre");
            Element dia = doc.createElement("dia");
            dia.setTextContent("29");
            Element anio = doc.createElement("anio");
            anio.setTextContent("1993");
           
            fechaNac.appendChild(mes);
            fechaNac.appendChild(dia);
            fechaNac.appendChild(anio);

            // Construimos jerarquía
            persona.appendChild(nombre);
            persona.appendChild(apellidos);
            persona.appendChild(edad);
            personas.appendChild(persona);
            
            persona.appendChild(fechaNac);

            // Guardamos en fichero
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            t.transform(new DOMSource(doc), new StreamResult(new File("personas.xml")));
        }

   
}