package com.example.Cto_Residencial.Model;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "zona_social")
public class ZonaSocial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_zona;

    private String nombre;
    private String ubicacion;
    private String capacidad;

    @OneToMany(mappedBy = "zona")
    private List<ReservaZona> reservas;

    public ZonaSocial() {
    }

    public ZonaSocial(Long id_zona, String nombre, String ubicacion, String capacidad, List<ReservaZona> reservas) {
        this.id_zona = id_zona;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.reservas = reservas;
    }

    public Long getId_zona() {
        return id_zona;
    }

    public void setId_zona(Long id_zona) {
        this.id_zona = id_zona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public List<ReservaZona> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaZona> reservas) {
        this.reservas = reservas;
    }
}
