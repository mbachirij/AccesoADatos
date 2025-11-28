package Practica1;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(unique = true) // El email es único en la empresa
    private String email;

    // Relación ManyToOne: Un empleado pertenece a un solo departamento.
    // Esta es la parte propietaria de la relación.
    @ManyToOne
    @JoinColumn(name = "id_departamento") // CAMBIO: "id" choca con la PK. Usar un nombre distinto.
    private Departamento departamento;

    // Relación OneToOne: Un empleado tiene una tarjeta de acceso
    @OneToOne
    @JoinColumn(name = "id_tarjeta", unique = true) // CAMBIO: Usar un nombre distinto a "id".
    private TarjetaAcceso tarjetaAcceso;

    // Relación ManyToMany: Un empleado puede estar en muchos proyectos y viceversa.
    @ManyToMany
    @JoinTable(
            name = "empleado_proyecto",
            joinColumns = @JoinColumn(name = "idEmpleado"),
            inverseJoinColumns = @JoinColumn(name = "idProyecto")
    )
    private List<Proyecto> proyectos;

    public Empleado(){}
    public Empleado(Long id, String nombre, String email){
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        String s = "";
        s+= "ID "+id+"\n";
        s+= "Nombre "+nombre+"\n";
        s+="Email "+email;
        return s;
    }
}
