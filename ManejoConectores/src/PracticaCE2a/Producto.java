package PracticaCE2a;

public class Persona {

    private int id;
    private String nombre;
    private Double precio;

    public Persona(int id, String nombre, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
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
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    @Override
    public String toString() {
        String s = "";
        s+="ID "+id+"\n";
        s+="Nombre "+nombre+"\n";
        s+="Precio "+precio+"€\n";
        return s;
    }

}
