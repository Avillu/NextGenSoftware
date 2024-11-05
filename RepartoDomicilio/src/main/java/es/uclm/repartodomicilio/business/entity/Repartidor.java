package es.uclm.repartodomicilio.business.entity;

import java.util.*;
import jakarta.persistence.*;

@Entity

public class Repartidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String dniRepartidor;

    @Column(nullable = false)
    private String nombre_repartidor;

    @Column(nullable = false)
    private String apellido_repartidor;

    @Column(nullable = false)
    private String password_repartidor;

    @Column(nullable = false)
    private String email_repartidor;

    @Column(nullable = false)
    private boolean disponible;
    //private int eficiencia;
    //  Collection<ServicioEntrega> servicios;
    //  Collection<CodigoPostal> zonas;

    // Constructor vacío
    public Repartidor() {
    }

    // Constructor
    public Repartidor(String dni_repartidor, String nombre_repartidor, String apellido_repartidor, String password_repartidor, String email_repartidor, boolean disponible) {
        this.dniRepartidor = dni_repartidor;
        this.nombre_repartidor = nombre_repartidor;
        this.apellido_repartidor = apellido_repartidor;
        this.password_repartidor = password_repartidor;
        this.email_repartidor = email_repartidor;
        this.disponible = disponible;
    }

    //Métodos get y set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDniRepartidor() {
        return dniRepartidor;
    }

    public void setDni_repartidor(String dni_repartidor) {
        this.dniRepartidor = dni_repartidor;
    }

    public String getNombre_repartidor() {
        return nombre_repartidor;
    }

    public void setNombre_repartidor(String nombre_repartidor) {
        this.nombre_repartidor = nombre_repartidor;
    }

    public String getApellido_repartidor() {
        return apellido_repartidor;
    }

    public void setApellido_repartidor(String apellido_repartidor) {
        this.apellido_repartidor = apellido_repartidor;
    }
    public String getPassword_repartidor(){return  password_repartidor; }

    public  void setPassword_repartidor(String password_repartidor) {

        this.password_repartidor = password_repartidor;

    }

    public String getEmail_repartidor(){
        return  email_repartidor;
    }

    public void setEmail_repartidor(String email_repartidor){
        this.email_repartidor = email_repartidor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}

