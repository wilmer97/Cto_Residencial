package com.example.Cto_Residencial.Controller;

import com.example.Cto_Residencial.Model.ReservaZona;
import com.example.Cto_Residencial.Service.ReservaZonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservas-zonas")
public class ReservaZonaController {

    @Autowired
    private ReservaZonaService reservaZonaService;

    @GetMapping
    public List<ReservaZona> getAllReservaZonas() {
        return reservaZonaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaZona> getReservaZonaById(@PathVariable Long id) {
        Optional<ReservaZona> reservaZona = reservaZonaService.findById(id);

        return reservaZona.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ReservaZona createReservaZona(@RequestBody ReservaZona reservaZona) {
        return reservaZonaService.save(reservaZona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaZona> updateReservaZona(@PathVariable Long id, @RequestBody ReservaZona revervaZonaDetalles) {

        Optional<ReservaZona> reservaZona = reservaZonaService.findById(id);

        if (reservaZona.isPresent()) {
            ReservaZona updateReversaZona = reservaZona.get();

            updateReversaZona.setFecha(revervaZonaDetalles.getFecha());
            updateReversaZona.setHora_inicio(revervaZonaDetalles.getHora_inicio());
            updateReversaZona.setZona(revervaZonaDetalles.getZona());
            updateReversaZona.setPropietario(revervaZonaDetalles.getPropietario());

            return ResponseEntity.ok(reservaZonaService.save(updateReversaZona));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReversaZona(@PathVariable Long id) {
        if (reservaZonaService.findById(id).isPresent()) {
            reservaZonaService.deleteBy(id);
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
