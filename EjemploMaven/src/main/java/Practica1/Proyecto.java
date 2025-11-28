package Practica1;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "proyecto")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double presupuesto;

    // Relación ManyToMany: Un proyecto puede tener muchos empleados, y viceversa.
    // Usamos mappedBy para indicar que Empleado es el propietario de la relación.
    @ManyToMany(mappedBy = "proyectos")
    private List<Empleado> empleados;

    public Proyecto(){}
    public Proyecto(Long id, String nombre, double presupuesto){
        this.id = id;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
    }

    // CAMBIO: La variable se llama 'id', no 'idProyecto'.
    public Long getIdProyecto() { return id; }
    public void setIdProyecto(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPresupuesto() { return presupuesto; }
    public void setPresupuesto(double presupuesto) { this.presupuesto = presupuesto; }

    @Override
    public String toString() {
        String s = "";
        // CAMBIO: Usar la variable correcta 'id'
        s+= "ID "+id+"\n";
        s+= "Nombre "+nombre+"\n";
        s+="Presupuesto "+presupuesto;
        return s;
    }

}
