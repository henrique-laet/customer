package com.laet.customer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    private String email;

    @Column(name = "telefone")
    private Integer telephone;

    @Column(name = "data_nascimento")
    private Date dateBirth;

    @OneToMany
    @JoinColumn(name = "endereco_id")
    private Address address;
}
