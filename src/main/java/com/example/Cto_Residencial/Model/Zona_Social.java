package com.example.Cto_Residencial.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "zona_social")
public class Zona_Social {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zona")
    private Long idZona;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "ubicacion", length = 100)
    private String ubicacion;

    @Column(name = "capacidad")
    private Integer capacidad;

    @OneToMany(mappedBy = "zonaSocial")
    private List<Reserva_Zona> reservas;
}
