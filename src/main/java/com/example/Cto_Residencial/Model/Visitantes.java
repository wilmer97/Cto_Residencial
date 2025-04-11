package com.example.Cto_Residencial.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "visitante")
public class Visitantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_visitantes;

    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private Propietario propietario;

    public Visitantes() {
    }

    public Visitantes(Long id_visitantes, String nombre, String cedula, String telefono, String correo, Propietario propietario) {
        this.id_visitantes = id_visitantes;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.propietario = propietario;
    }

    public Long getId_visitantes() {
        return id_visitantes;
    }

    public void setId_visitantes(Long id_visitantes) {
        this.id_visitantes = id_visitantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
}
