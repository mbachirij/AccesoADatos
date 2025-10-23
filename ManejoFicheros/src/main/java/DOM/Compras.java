package DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Compras {

    public static void main(String[] args) throws Exception{

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File("D:\\AccesoADatos\\AccesoADatos\\ManejoFicheros\\Compras.xml"));

        //Te consigo el elemento raíz
        Element compras = (Element) doc.getElementsByTagName("Compras").item(0);

        Element nuevaCompra = doc.createElement("Compra");
        nuevaCompra.setAttribute("id", "4");

        Element fecha = doc.createElement("fecha");
        fecha.setTextContent("20/05/2021");

        Element ubicacion = doc.createElement("ubicacion");
        ubicacion.setTextContent("Huércanos");

        Element articulos = doc.createElement("articulos");
        articulos.setAttribute("cantidad", "2");

        Element articulo = doc.createElement("articulo");
        articulo.setAttribute("id", "1");
        articulo.setTextContent("Papas");

        Element articulo1 = doc.createElement("articulo");
        articulo1.setAttribute("id", "2");
        articulo1.setTextContent("Queso");


        nuevaCompra.appendChild(fecha);
        nuevaCompra.appendChild(ubicacion);
        nuevaCompra.appendChild(articulos);
        articulos.appendChild(articulo);
        articulos.appendChild(articulo1);

        compras.appendChild(nuevaCompra);

        // Guardamos en fichero
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.setOutputProperty("indent", "yes");
        t.transform(new DOMSource(doc), new StreamResult(new File("D:\\AccesoADatos\\AccesoADatos\\ManejoFicheros\\Compras2.xml")));
        t.setOutputProperty("indent", "yes");
    }

}
