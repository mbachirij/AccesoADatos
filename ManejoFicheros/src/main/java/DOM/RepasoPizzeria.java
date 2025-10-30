package DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class RepasoPizzeria {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File("ManejoFicheros\\Pizzeria.xml"));

        listarPedidos(doc);
        //calculoTotales(doc);
        cambioEstado(doc);

    }

    public static void escribirPedidos(Document doc) throws TransformerException {
        doc.getDocumentElement().normalize();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "no");
        t.transform(new DOMSource(doc), new StreamResult(new File("ManejoFicheros\\Pizzeria.xml")));
    }

    public static void listarPedidos(Document doc){

        NodeList pedidos = doc.getElementsByTagName("pedido");
        //Recorremos la lista de elementos pedido y quiero sus atributos
        for(int i = 0; i < pedidos.getLength(); i++){
            String id = pedidos.item(i).getAttributes().getNamedItem("id").getNodeValue();
            String fecha = pedidos.item(i).getAttributes().getNamedItem("fecha").getNodeValue();
            String estado = pedidos.item(i).getAttributes().getNamedItem("estado").getNodeValue();
            System.out.println("Pedido "+(i+1)+" -> ID: " + id + " Fecha: " + fecha + " Estado: " + estado);
        }
    }
    /*
     * Para cada <pedido>, si <total @calculado="false">, recalcular sumando
     * cantidad * precio_unitario de cada linea.
     * Actualizar el contenido de <total> con 2 decimales y poner
     * calculado="true".
     */
    public static void calculoTotales(Document doc){

        NodeList pedidos = doc.getElementsByTagName("pedido");

        for(int i = 0; i < pedidos.getLength(); i++){
            double totalPrecio = 0;
            Element pedido = (Element) pedidos.item(i);

            Element total = (Element) pedido.getElementsByTagName("total").item(0);
            boolean calculado = Boolean.parseBoolean(total.getAttribute("calculado"));

            if(!calculado){
                double precio = 0;

                NodeList lineas = pedido.getElementsByTagName("linea");
                for(int j = 0; j < lineas.getLength(); j++){
                    Element linea = (Element) lineas.item(j);

                    double precioUnitario = Double.parseDouble(linea.getElementsByTagName("precio_unitario").item(0).getTextContent());
                    int cantidad = Integer.parseInt(linea.getElementsByTagName("cantidad").item(0).getTextContent());

                    precio = cantidad * precioUnitario;
                    totalPrecio+=precio;
                }
                total.setTextContent(String.valueOf(totalPrecio));
                System.out.println("Pedido: "+ pedido.getAttribute("id") +" CalculoTotal "+totalPrecio);
            }
        }
    }

    /*
     * Cambio de estado: pedir un pedido y cambiar su estado
     * Preparación -> horno
     * Horno -> reparto
     * Reparto -> entregado
     * Y si ya está entregado, no cambiar y mostrar un aviso
     */
    public static void cambioEstado(Document doc) throws TransformerException {

        NodeList pedidos = doc.getElementsByTagName("pedido");
        for(int i = 0; i < pedidos.getLength(); i++){
            Element pedido = (Element) pedidos.item(i);
            String estado = pedido.getAttribute("estado");

            if(estado.equals("preparacion")){
                pedido.setAttribute("estado", "horno");
                System.out.println("Cambio estado de preparacion a horno");
            } else if(estado.equals("horno")){
                pedido.setAttribute("estado", "reparto");
                System.out.println("Cambio estado de horno a reparto");
            } else if(estado.equals("reparto")){
                pedido.setAttribute("estado", "entregado");
                System.out.println("Cambio estado de reparto a entregado");
            } else if(estado.equals("entregado")){
                System.out.println("El pedido ya ha sido entregado");
            }

        }
        escribirPedidos(doc);
    }
}
