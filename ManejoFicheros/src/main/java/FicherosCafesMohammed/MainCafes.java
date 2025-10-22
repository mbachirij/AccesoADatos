package FicherosCafesMohammed;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MainCafes {

    public static void main(String[] args){

        try(BufferedReader br = new BufferedReader(new FileReader("MisCafes.txt")))
        {
            System.out.println( "** INVENTARIO DE CAFES **");
            ArrayList<Cafe> cafes = new ArrayList<>();

            String linea;
            while((linea = br.readLine())!=null){

                String nombre = linea;
                String precio = br.readLine();

                ArrayList<Lote> lotes = new ArrayList<>();



                while((linea = br.readLine()) !=null && !linea.equals("0"))
                {
                    String kilos = linea;
                    String caducidad = br.readLine();

                    lotes.add(new Lote(Double.parseDouble(kilos), caducidad));

                }

                double sumaKilos = 0.0;
                for(Lote l: lotes){
                    sumaKilos+=l.getKilos();
                }

                double stock=sumaKilos;

                cafes.add(new Cafe(nombre, Double.parseDouble(precio), stock, lotes));

            }

            for(Cafe c: cafes){
                System.out.println(c.toString());
            }
            Scanner sc = new Scanner(System.in);

            System.out.println("** VENTA DE CAFES **");

            while(true) {
                System.out.print("Marca pedida (F=fin): ");
                String marca = sc.nextLine().toUpperCase().trim();

                if (marca.equals("F")) {
                    break;
                }

                Cafe cafe = null;

                // ForEach para buscar café
                for (Cafe c : cafes) {
                    //recorro los cafes y si es igual a la marca que me pasa...
                    if (c.getNombre().equalsIgnoreCase(marca)) {
                        //lo asigno a cafe
                        cafe = c;
                        break;
                    }
                }
                //si cafe es null significa que no existe esa marca
                if (cafe == null) {
                    System.out.println("ERROR: marca desconocida.");
                    continue;  // vuelve a pedir marca
                }

                System.out.print("Kilos pedidos: ");
                double numKilos;

                //Controlo que lo que paso por parámetro es un double
                try {

                    numKilos = Double.parseDouble(sc.nextLine());

                } catch (NumberFormatException e) {
                    System.out.println("ERROR: cantidad no válida.");
                    continue; // vuelve a la pedir marca
                }

                //Controlo que el stock sea suficiente
                //Si numKilos es mayor que el stock de cafe me salta el error
                if (numKilos > cafe.getStock()) {
                    System.out.println("ERROR: stock insuficiente.");
                    continue; // vuelve a la pedir marca
                }

                //Venta kilos lotes
                //ArrayList con los lotes del cafe
                ArrayList<Lote> lotes = cafe.getLot();
                double restante = numKilos;
                //Recorro la lista de lotes
                //restante es el numero de kilos que falta por vender
                //si restante llega a 0 salgo del bucle porque ya he vendido todos los kilos
                for (int i = 0; i < lotes.size() && restante > 0; i++) {

                    Lote lote = lotes.get(i);
                    double kilosLote = lote.getKilos();

                    if (kilosLote <= restante) {
                        System.out.println("... Vendidos " + kilosLote + " kg del lote de " + lote.getCaducidad());
                        restante -= kilosLote;
                        lote.setKilos(0);
                    } else {
                        System.out.println("... Vendidos " + restante + " kg del lote de " + lote.getCaducidad());
                        lote.setKilos(kilosLote - restante);
                        restante = 0;
                    }
                }

                //Actualizo el stock y resto el numero de kilos vendidos
                cafe.setStock(cafe.getStock() - numKilos);

                //ahora muestro existencias finales:
                System.out.println("EXISTENCIAS FINALES:");
                //cuento stock total que me queda despues de vender
                double stockTotal = 0.0;
                for(Lote l: cafe.getLot()){
                    if(l.getKilos()==0){
                        continue;
                    }
                    System.out.println(l.toString());
                    stockTotal+=l.getKilos();

                }
                System.out.println("Stock Total: " + stockTotal);
                System.out.println();

            }




        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
