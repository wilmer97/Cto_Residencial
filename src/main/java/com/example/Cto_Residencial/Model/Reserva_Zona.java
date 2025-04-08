package com.example.Cto_Residencial.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reserva_zona")
public class Reserva_Zona {


    public class ReservaZona {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_reserva")
        private Long idReserva;

        @Column(name = "fecha")
        private LocalDate fecha;

        @Column(name = "hora_inicio")
        private LocalTime horaInicio;

        @ManyToOne
        @JoinColumn(name = "id_zona", referencedColumnName = "id_zona")
        private Zona_Social zonaSocial;

        @ManyToOne
        @JoinColumn(name = "id_propietario", referencedColumnName = "id_propietario")
        private Propietario propietario;

        public ReservaZona() {
        }

        public ReservaZona(Long idReserva, LocalDate fecha, LocalTime horaInicio, Zona_Social zonaSocial, Propietario propietario) {
            this.idReserva = idReserva;
            this.fecha = fecha;
            this.horaInicio = horaInicio;
            this.zonaSocial = zonaSocial;
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

        public Zona_Social getZonaSocial() {
            return zonaSocial;
        }

        public void setZonaSocial(Zona_Social zonaSocial) {
            this.zonaSocial = zonaSocial;
        }

        public Propietario getPropietario() {
            return propietario;
        }

        public void setPropietario(Propietario propietario) {
            this.propietario = propietario;
        }

        @Override
        public String toString() {
            return "ReservaZona{" +
                    "idReserva=" + idReserva +
                    ", fecha=" + fecha +
                    ", horaInicio=" + horaInicio +
                    ", zonaSocial=" + zonaSocial +
                    ", propietario=" + propietario +
                    '}';
        }
    }
}



