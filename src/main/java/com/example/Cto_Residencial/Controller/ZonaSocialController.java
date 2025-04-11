package com.example.Cto_Residencial.Controller;

import com.example.Cto_Residencial.Model.ZonaSocial;
import com.example.Cto_Residencial.Service.ZonaSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/zonas-sociales")
public class ZonaSocialController {

    @Autowired
    private ZonaSocialService zonaSocialService;

    @GetMapping
    public List<ZonaSocial> getAllZonasSociales() {
        return zonaSocialService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZonaSocial> getZonaSocialById(@PathVariable Long id) {
        Optional<ZonaSocial> zonaSocial = zonaSocialService.findById(id);
        return zonaSocial.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ZonaSocial createZonaSocial(@RequestBody ZonaSocial zonaSocial) {
        return zonaSocialService.save(zonaSocial);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ZonaSocial> updateZonaSocial(@PathVariable Long id, @RequestBody ZonaSocial zonaSocialDetalles) {
        Optional<ZonaSocial> zonaSocial = zonaSocialService.findById(id);

        if (zonaSocial.isPresent()) {
            ZonaSocial updateZonaSocial = zonaSocial.get();

            updateZonaSocial.setNombre(zonaSocialDetalles.getNombre());
            updateZonaSocial.setUbicacion(zonaSocialDetalles.getUbicacion());
            updateZonaSocial.setCapacidad(zonaSocialDetalles.getCapacidad());

            return ResponseEntity.ok(zonaSocialService.save(updateZonaSocial));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZonaSocial(@PathVariable Long id) {
        if (zonaSocialService.findById(id).isPresent()) {
            zonaSocialService.deleteByid(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
