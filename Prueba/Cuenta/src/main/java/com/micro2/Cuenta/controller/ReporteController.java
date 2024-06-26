package com.micro2.Cuenta.controller;

import com.micro2.Cuenta.entity.Cuenta;
import com.micro2.Cuenta.entity.Movimiento;
import com.micro2.Cuenta.repository.CuentaRepository;
import com.micro2.Cuenta.repository.MovimientoRepository;
import com.micro2.Cuenta.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public ResponseEntity<?> getEstadoCuenta(
            @RequestParam("fechaInicio") String fechaInicio,
            @RequestParam("fechaFin") String fechaFin,
            @RequestParam("clienteId") Long clienteId) {
        System.out.println(fechaFin);
        LocalDateTime hoy = LocalDateTime.now();
        return ResponseEntity.ok(reporteService.generarReporte(fechaInicio, fechaFin, clienteId));
    }
}
