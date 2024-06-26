package com.micro2.Cuenta.service;

import com.micro2.Cuenta.entity.Cuenta;
import com.micro2.Cuenta.repository.CuentaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CuentaServiceTest {

    @Mock
    private CuentaRepository cuentaRepository;

    @InjectMocks
    private CuentaService cuentaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveCuenta() {
        Cuenta cuenta = new Cuenta();
        when(cuentaRepository.save(cuenta)).thenReturn(cuenta);

        Cuenta result = cuentaService.saveCuenta(cuenta);
        assertEquals(cuenta, result);

        verify(cuentaRepository, times(1)).save(cuenta);
    }

    @Test
    public void testGetAllCuentas() {
        Cuenta cuenta1 = new Cuenta();
        Cuenta cuenta2 = new Cuenta();
        List<Cuenta> cuentas = Arrays.asList(cuenta1, cuenta2);
        when(cuentaRepository.findAll()).thenReturn(cuentas);

        List<Cuenta> result = cuentaService.getAllCuentas();
        assertEquals(2, result.size());
        assertEquals(cuenta1, result.get(0));
        assertEquals(cuenta2, result.get(1));

        verify(cuentaRepository, times(1)).findAll();
    }
}
