package Practica1;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    // Relación OneToMany: Un departamento tiene muchos empleados.
    // El atributo "departamento" en la clase Empleado es el propietario de la clave foránea
    @OneToMany(mappedBy = "departamento")
    private List<Empleado> empleados;

    public Departamento(){}
    public Departamento(Long id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() {
        String s = "";
        s+= "ID "+id+"\n";
        s+= "Nombre "+nombre;
        return s;
    }
}
