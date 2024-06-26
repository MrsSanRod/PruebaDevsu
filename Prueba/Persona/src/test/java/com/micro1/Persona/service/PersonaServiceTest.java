package com.micro1.Persona.service;

import com.micro1.Persona.entity.Persona;
import com.micro1.Persona.repository.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PersonaServiceTest {

    @Mock
    private PersonaRepository personaRepository;

    @InjectMocks
    private PersonaService personaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSavePersona() {
        Persona persona = new Persona();
        when(personaRepository.save(persona)).thenReturn(persona);

        Persona result = personaService.savePersona(persona);
        assertEquals(persona, result);

        verify(personaRepository, times(1)).save(persona);
    }

    @Test
    public void testGetAllPersonas() {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona();
        List<Persona> personas = Arrays.asList(persona1, persona2);
        when(personaRepository.findAll()).thenReturn(personas);

        List<Persona> result = personaService.getAllPersonas();
        assertEquals(2, result.size());
        assertEquals(persona1, result.get(0));
        assertEquals(persona2, result.get(1));

        verify(personaRepository, times(1)).findAll();
    }
}

