package com.example.Cto_Residencial.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "visitante")
public class Visitante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_visitante")
    private Long idVisitante;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "cedula", length = 100)
    private String cedula;

    @Column(name = "telefono", length = 50)
    private String telefono;

    @Column(name = "correo", length = 100)
    private String correo;

    @ManyToOne
    @JoinColumn(name = "Id_Propietario", referencedColumnName = "Id_propietario")
    private Propietario propietario;

    public Visitante() {
    }

    public Visitante(Long idVisitante, String nombre, String cedula, String telefono, String correo, Propietario propietario) {
        this.idVisitante = idVisitante;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.propietario = propietario;
    }

    public Long getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(Long idVisitante) {
        this.idVisitante = idVisitante;
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

    @Override
    public String toString() {
        return "Visitante{" +
                "idVisitante=" + idVisitante +
                ", nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", propietario=" + propietario +
                '}';
    }
}
