package com.example.Cto_Residencial.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reserva_zona")
public class ReservaZona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reserva;

    private LocalDate fecha;
    private LocalTime hora_inicio;

    @ManyToOne
    @JoinColumn(name = "id_zona")
    private ZonaSocial zona;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private Propietario propietario;

    public ReservaZona() {
    }

    public ReservaZona(Long id_reserva, LocalDate fecha, LocalTime hora_inicio, ZonaSocial zona, Propietario propietario) {
        this.id_reserva = id_reserva;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.zona = zona;
        this.propietario = propietario;
    }

    public Long getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(Long id_reserva) {
        this.id_reserva = id_reserva;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public ZonaSocial getZona() {
        return zona;
    }

    public void setZona(ZonaSocial zona) {
        this.zona = zona;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
}
