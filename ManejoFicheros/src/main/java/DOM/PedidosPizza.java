package DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;

public class PedidosPizza {
    /**
     * @param args the command line arguments
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws javax.xml.transform.TransformerConfigurationException
     */
    public static void main(String[] args) throws Exception {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("D:\\AccesoADatos\\AccesoADatos\\ManejoFicheros\\Pedidos_Pizzeria.xml"));

            /*
             * Creo una lista de nodos con todos los elementos de tipo pedido
             */
            NodeList nl = doc.getElementsByTagName("pedido");
            double total = 0;
            //Ahora puedo recorrer la lista de elementos "pedido"
            for (int i = 0; i < nl.getLength(); i++) {
                //Obtengo los atributos de cada elemento pedido
                String id = nl.item(i).getAttributes().getNamedItem("id").getNodeValue();
                String fecha = nl.item(i).getAttributes().getNamedItem("fecha").getNodeValue();
                String estado = nl.item(i).getAttributes().getNamedItem("estado").getNodeValue();
                System.out.println("Pedido "+(i+1)+" Id "+id+" fecha "+fecha+" estado "+estado);
                Element pedido= (Element) nl.item(i);
                String calculado = pedido.getElementsByTagName("total").item(0).getAttributes().getNamedItem("calculado").getNodeValue();

                for(int j=0;j<pedido.getElementsByTagName("linea").getLength();j++) {
                    if (calculado.equals("false")) {
                        //Lo calculo
                        double p0 = Double.parseDouble(pedido.getElementsByTagName("cantidad").item(0).getTextContent());
                        double p1 = Double.parseDouble(pedido.getElementsByTagName("precio_unitario").item(1).getTextContent());
                        double tot = p0 + p1;
                        String nuevoTotal = String.format("%.2f", tot);
                        pedido.getElementsByTagName("total").item(0).setTextContent(nuevoTotal);
                        pedido.getElementsByTagName("total").item(0).getAttributes().getNamedItem("calculado").setNodeValue("true");
                    }
                }
            }


        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }


    }
}
