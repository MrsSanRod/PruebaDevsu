package com.micro2.Cuenta.controller;

import com.micro2.Cuenta.Exceptions.MovimientoException;
import com.micro2.Cuenta.Exceptions.Response;
import com.micro2.Cuenta.entity.Movimiento;
import com.micro2.Cuenta.repository.MovimientoRepository;
import com.micro2.Cuenta.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;

    @Autowired
    private MovimientoRepository movimientoRepository;

    @PostMapping
    public Object createMovimiento(@RequestBody Movimiento movimiento) throws MovimientoException {
        try {
            return movimientoService.saveMovimiento(movimiento);
        } catch (MovimientoException e) {
            return new ResponseEntity<>(new Response(e.getHttpCode(),
                    e.getMessage(), e.getMessage()), HttpStatus.valueOf(e.getHttpCode()));
        }
    }

    @GetMapping
    public List<Movimiento> getAllMovimientos() {
        return movimientoService.getAllMovimientos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> getMovimientoById(@PathVariable Long id) {
        Optional<Movimiento> movimiento = movimientoRepository.findById(id);
        return movimiento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimiento> updateMovimiento(@PathVariable Long id, @RequestBody Movimiento movimientoDetails) {
        Optional<Movimiento> movimiento = movimientoRepository.findById(id);
        if (movimiento.isPresent()) {
            Movimiento updatedMovimiento = movimiento.get();
            updatedMovimiento.setFecha(movimientoDetails.getFecha());
            updatedMovimiento.setTipoMovimiento(movimientoDetails.getTipoMovimiento());
            updatedMovimiento.setValor(movimientoDetails.getValor());
            updatedMovimiento.setSaldo(movimientoDetails.getSaldo());
            return ResponseEntity.ok(movimientoRepository.save(updatedMovimiento));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable Long id) {
        if (movimientoRepository.existsById(id)) {
            movimientoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
