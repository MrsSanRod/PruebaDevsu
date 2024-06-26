package com.micro2.Cuenta.service;

import com.micro2.Cuenta.entity.Cuenta;
import com.micro2.Cuenta.entity.Movimiento;
import com.micro2.Cuenta.repository.CuentaRepository;
import com.micro2.Cuenta.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReporteService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    public Map<String, Object> generarReporte(String fechaInicio, String fechaFin, Long clienteId) {
        List<Cuenta> cuentas = cuentaRepository.findByClienteId(clienteId);
        Map<String, Object> reporte = new HashMap<>();
        reporte.put("clienteId", clienteId);
        reporte.put("cuentas", cuentas);

        for (Cuenta cuenta : cuentas) {
            List<Movimiento> movimientos = movimientoRepository
                    .findByCuentaIdAndFechaBetween(cuenta.getId(), fechaInicio, fechaFin);
            reporte.put("movimientosCuenta" + cuenta.getId(), movimientos);
        }

        return reporte;
    }
}
