package com.example.Cto_Residencial.Controller;

import com.example.Cto_Residencial.Model.Propietario;
import com.example.Cto_Residencial.Service.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/propietario")
public class PropietarioController {

    @Autowired
    private PropietarioService propietarioService;

    @GetMapping
    public List<Propietario> getAllPropietarios() {
        return propietarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propietario> getPropietarioById(@PathVariable Long id) {
        Optional<Propietario> propietario = propietarioService.findById(id);
        return propietario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Propietario createPropietario(@RequestBody Propietario propietario) {
        return propietarioService.save(propietario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Propietario> updatePropietario(@PathVariable Long id, @RequestBody Propietario propietarioDetalles) {

        Optional<Propietario> propietario = propietarioService.findById(id);

        if (propietario.isPresent()) {
            Propietario updatePropietario = propietario.get();

            updatePropietario.setNombre(propietarioDetalles.getNombre());
            updatePropietario.setCedula(propietarioDetalles.getCedula());
            updatePropietario.setFecha_visita(propietarioDetalles.getFecha_visita());
            updatePropietario.setHora_entrada(propietarioDetalles.getHora_entrada());

            return ResponseEntity.ok(propietarioService.save(updatePropietario));

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePropietario(@PathVariable Long id) {

        if (propietarioService.findById(id).isPresent()) {
            propietarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
