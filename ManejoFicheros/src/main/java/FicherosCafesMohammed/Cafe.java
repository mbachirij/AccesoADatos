/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FicherosCafesMohammed;

import java.util.ArrayList;

/**
 *
 * @author Vespertino
 */
public class Cafe {
    private String nombre;
    private double precio;
    private double stock;
    private ArrayList<Lote> lot = new ArrayList<>();

    public Cafe(String nombre, double precio, double stock, ArrayList<Lote> lot) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.lot = lot;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public ArrayList<Lote> getLot() {
        return lot;
    }

    public void setLot(ArrayList<Lote> lot) {
        this.lot = lot;
    }

    @Override
    public String toString() {
        String s = "";
        s+= nombre+" a "+precio+" euros/kg\n";
        s+= lot+"\n";
        s+= "Stock Total: "+stock;
        return s;
    }
}
