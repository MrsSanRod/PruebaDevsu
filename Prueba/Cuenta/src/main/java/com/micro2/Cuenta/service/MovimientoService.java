package com.micro2.Cuenta.service;

import com.micro2.Cuenta.Exceptions.MovimientoException;
import com.micro2.Cuenta.config.RabbitMQConfig;
import com.micro2.Cuenta.entity.Cuenta;
import com.micro2.Cuenta.entity.Movimiento;
import com.micro2.Cuenta.repository.CuentaRepository;
import com.micro2.Cuenta.repository.MovimientoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @RabbitListener(queues = "personaClienteQueue")
    public void handleClienteMessage(Long cliente) {
        System.out.println("ClienteId recibido: " + cliente);

        Cuenta nuevaCuenta = new Cuenta();
        nuevaCuenta.setClienteId(cliente);
        nuevaCuenta.setNumeroCuenta(generarNumeroCuenta());
        nuevaCuenta.setTipo("Ahorros");
        nuevaCuenta.setSaldoInicial(0.0);
        nuevaCuenta.setEstado(true);

        cuentaRepository.save(nuevaCuenta);

        System.out.println("Nueva cuenta creada para el cliente: " + cliente);
    }

    private String generarNumeroCuenta() {
        return "CUENTA-" + System.currentTimeMillis();
    }

    public Movimiento saveMovimiento(Movimiento movimiento) throws MovimientoException {
        double saldoInicial = movimiento.getSaldo();
        double saldoFinal = 0.0;
        if(movimiento.getTipoMovimiento().equals("Deposito")){
            saldoFinal = saldoInicial + movimiento.getValor();
        }

        if(movimiento.getTipoMovimiento().equals("Retiro")){
            saldoFinal = saldoInicial - movimiento.getValor();
        }

        if(saldoFinal < 0.0) {
            throw new MovimientoException("Saldo no disponible", null, 500);
        }
        movimiento.setSaldo(saldoFinal);

        return movimientoRepository.save(movimiento);
    }

    public List<Movimiento> getAllMovimientos() {
        return movimientoRepository.findAll();
    }
}
