package Practica1;

import jakarta.persistence.*;

@Entity
@Table(name = "tarjeta_acceso")
public class TarjetaAcceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarjeta;
    @Column(unique = true) // El código de acceso dene ser único
    private String codigoAcceso;
    private Boolean activo;

    // Relación OneToOne: Una tarjeta pertenece a un empleado.
    // Usamos mappedBy para indicar que Empleado es el propietario de la relación.
    // CAMBIO: Debe coincidir con el nombre del atributo en la clase Empleado (private TarjetaAcceso tarjetaAcceso;)
    @OneToOne(mappedBy = "tarjetaAcceso")
    private Empleado empleado;

    public TarjetaAcceso(){}
    public TarjetaAcceso(Long idTarjeta, String codigoAcceso, Boolean activo){
        this.idTarjeta = idTarjeta;
        this.codigoAcceso = codigoAcceso;
        this.activo = activo;
    }

    public Long getIdTarjeta() { return idTarjeta; }
    public void setIdTarjeta(Long idTarjeta) { this.idTarjeta = idTarjeta; }
    public String getCodigoAcceso() { return codigoAcceso; }
    public void setCodigoAcceso(String codigoAcceso) { this.codigoAcceso = codigoAcceso; }
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }

    @Override
    public String toString(){
        String s = "";
        s+="ID "+idTarjeta+"\n";
        s+="Codigo de acceso "+codigoAcceso+"\n";
        s+="Activo "+activo;
        return s;
    }

}
