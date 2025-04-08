package com.example.Cto_Residencial.Model;


import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "propietario")
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_propietario")
    private Long idPropietario;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "cedula", length = 100)
    private String cedula;

    @Column(name = "fecha_visita", length = 100)
    private LocalTime fecha_visita;

    @Column(name = "hora_entrada", length = 50)
    private LocalTime hora_entrada;

    @OneToMany(mappedBy = "propietario")
    private List<Visitante> visitantes;

    @OneToMany(mappedBy = "propietario")
    private List<Reserva_Zona> reservasZonas;

    @OneToMany(mappedBy = "propietario")
    private List<Reserva_Parqueadero> reservasParqueaderos;


    public Propietario() {
    }

    public Propietario(Long idPropietario, String nombre, String cedula, LocalTime fecha_visita, LocalTime hora_entrada) {
        this.idPropietario = idPropietario;
        this.nombre = nombre;
        this.cedula = cedula;
        this.fecha_visita = fecha_visita;
        this.hora_entrada = hora_entrada;
    }

    public Long getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Long idPropietario) {
        this.idPropietario = idPropietario;
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

    public LocalTime getFecha_visita() {
        return fecha_visita;
    }

    public void setFecha_visita(LocalTime fecha_visita) {
        this.fecha_visita = fecha_visita;
    }

    public LocalTime getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(LocalTime hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public List<Visitante> getVisitantes() {
        return visitantes;
    }

    public void setVisitantes(List<Visitante> visitantes) {
        this.visitantes = visitantes;
    }

    public List<Reserva_Zona> getReservasZonas() {
        return reservasZonas;
    }

    public void setReservasZonas(List<Reserva_Zona> reservasZonas) {
        this.reservasZonas = reservasZonas;
    }

    public List<Reserva_Parqueadero> getReservasParqueaderos() {
        return reservasParqueaderos;
    }

    public void setReservasParqueaderos(List<Reserva_Parqueadero> reservasParqueaderos) {
        this.reservasParqueaderos = reservasParqueaderos;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "idPropietario=" + idPropietario +
                ", nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", fecha_visita=" + fecha_visita +
                ", hora_entrada=" + hora_entrada +
                ", visitantes=" + visitantes +
                ", reservasZonas=" + reservasZonas +
                ", reservasParqueaderos=" + reservasParqueaderos +
                '}';
    }
}
