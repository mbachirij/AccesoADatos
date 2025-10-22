/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FicherosCafesMohammed;

/**
 *
 * @author Vespertino
 */
public class Lote {
    private double kilos;
    private String caducidad;

    public Lote(double kilos, String caducidad) {
        this.kilos = kilos;
        this.caducidad = caducidad;
    }

    public double getKilos() {
        return kilos;
    }

    public void setKilos(double kilos) {
        this.kilos = kilos;
    }
    public String getCaducidad() {
        return caducidad;
    }
    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }

    @Override
    public String toString() {
        String s = caducidad+": "+kilos+"kg\n";
        return s;
    }
    
}
