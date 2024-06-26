package com.micro1.Persona.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cliente extends Persona{
    private String clienteId;
    private String contrasena;
    private boolean estado;

    @OneToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
}
