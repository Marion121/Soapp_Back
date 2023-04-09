package com.example.soapp.model;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "bureau")
@Getter
@Setter
public class Bureau {

    @ApiModelProperty(value = "auto generated id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ApiModelProperty(required = true)
    @OneToOne
    @JoinColumn(name = "id_association")
    private Association association;

    @ApiModelProperty(required = true)
    @OneToOne
    @JoinColumn(name = "id_etudiant")
    private Etudiant etudiant;

    @ApiModelProperty(required = true)
    @Column(length = 100)
    private String role; // mettre un enume
}
