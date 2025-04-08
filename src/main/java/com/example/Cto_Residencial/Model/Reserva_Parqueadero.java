package com.example.Cto_Residencial.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reserva_parqueadero")
public class Reserva_Parqueadero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora_inicio")
    private LocalTime horaInicio;

    @ManyToOne
    @JoinColumn(name = "id_propietario", referencedColumnName = "id_propietario")
    private Propietario propietario;

    public Reserva_Parqueadero() {
    }

    public Reserva_Parqueadero(Long idReserva, LocalDate fecha, LocalTime horaInicio, Propietario propietario) {
        this.idReserva = idReserva;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.propietario = propietario;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "Reserva_Parqueadero{" +
                "idReserva=" + idReserva +
                ", fecha=" + fecha +
                ", horaInicio=" + horaInicio +
                ", propietario=" + propietario +
                '}';
    }
}
