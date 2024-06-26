package com.micro2.Cuenta.service;

import com.micro2.Cuenta.entity.Cuenta;
import com.micro2.Cuenta.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    public Cuenta saveCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public List<Cuenta> getAllCuentas() {
        return cuentaRepository.findAll();
    }
}

