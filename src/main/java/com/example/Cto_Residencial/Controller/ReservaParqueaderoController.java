package com.example.Cto_Residencial.Controller;

import com.example.Cto_Residencial.Model.ReservaParqueadero;
import com.example.Cto_Residencial.Service.ReservaParqueaderoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservas-parqueaderos")
public class ReservaParqueaderoController {

    @Autowired
    private ReservaParqueaderoService reservaParqueaderoService;

    @GetMapping
    public List<ReservaParqueadero> getAllReservasParqueaderos() {
        return reservaParqueaderoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaParqueadero> getReservaParqueaderoById(@PathVariable Long id) {
        Optional<ReservaParqueadero> reservaParqueadero = reservaParqueaderoService.findById(id);
        return reservaParqueadero.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ReservaParqueadero createReservaParqueadero(@RequestBody ReservaParqueadero reservaParqueadero) {
        return reservaParqueaderoService.save(reservaParqueadero);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaParqueadero> updateReservaParqueadero(@PathVariable Long id, @RequestBody ReservaParqueadero reservaParqueaderoDetalles) {
        Optional<ReservaParqueadero> reservaParqueadero = reservaParqueaderoService.findById(id);

        if (reservaParqueadero.isPresent()){
            ReservaParqueadero updateReservaParqueadero = reservaParqueadero.get();

            updateReservaParqueadero.setFecha(reservaParqueaderoDetalles.getFecha());
            updateReservaParqueadero.setHora_inicio(reservaParqueaderoDetalles.getHora_inicio());
            updateReservaParqueadero.setPropietario(reservaParqueaderoDetalles.getPropietario());

            return ResponseEntity.ok(reservaParqueaderoService.save(updateReservaParqueadero));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservaParqueadero(@PathVariable Long id) {
        if (reservaParqueaderoService.findById(id).isPresent()) {
            reservaParqueaderoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
