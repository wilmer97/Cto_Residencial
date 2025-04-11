package com.example.Cto_Residencial.Model;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "propietario")
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_propietario;

    private String nombre;
    private String cedula;
    private String fecha_visita;
    private String hora_entrada;

    @OneToMany(mappedBy = "propietario")
    private List<ReservaZona> reservaZonas;

    @OneToMany(mappedBy = "propietario")
    private List<ReservaParqueadero> reservaParqueaderos;

    public Propietario() {
    }

    public Propietario(Long id_propietario, String nombre, String cedula, String fecha_visita, String hora_entrada, List<ReservaZona> reservaZonas, List<ReservaParqueadero> reservaParqueaderos) {
        this.id_propietario = id_propietario;
        this.nombre = nombre;
        this.cedula = cedula;
        this.fecha_visita = fecha_visita;
        this.hora_entrada = hora_entrada;
        this.reservaZonas = reservaZonas;
        this.reservaParqueaderos = reservaParqueaderos;
    }

    public Long getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(Long id_propietario) {
        this.id_propietario = id_propietario;
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

    public String getFecha_visita() {
        return fecha_visita;
    }

    public void setFecha_visita(String fecha_visita) {
        this.fecha_visita = fecha_visita;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public List<ReservaZona> getReservaZonas() {
        return reservaZonas;
    }

    public void setReservaZonas(List<ReservaZona> reservaZonas) {
        this.reservaZonas = reservaZonas;
    }

    public List<ReservaParqueadero> getReservaParqueaderos() {
        return reservaParqueaderos;
    }

    public void setReservaParqueaderos(List<ReservaParqueadero> reservaParqueaderos) {
        this.reservaParqueaderos = reservaParqueaderos;
    }
}
