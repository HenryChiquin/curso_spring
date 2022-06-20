package com.pracitca.curso_spring.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "c_usuario")
@ToString @EqualsAndHashCode
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "Id")
    private Long id;
    @Getter @Setter @Column(name = "Nombre")
    private String nombre;
    @Getter @Setter @Column(name = "Apellido")
    private String apellido;
    @Getter @Setter @Column(name = "Email")
    private String email;
    @Getter @Setter @Column(name = "Telefono")
    private String telefono;
    @Getter @Setter @Column(name = "Password")
    private String password;

}
