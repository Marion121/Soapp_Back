package com.example.soapp.model;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "association")
@Getter
@Setter
public class Association {

    @ApiModelProperty(value = "auto generated id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(required = true)
    @Column(length = 100)
    private String nom;

    @ApiModelProperty(required = true)
    @Column(length = 100)
    private String mdp;

    @ApiModelProperty(required = true)
    @Column(length = 100)
    private String mail;

    @ApiModelProperty(required = true)
    @Column(length = 100)
    private String couleur;

    @ApiModelProperty(required = true)
    @Column(length = 1000)
    private String description;

    @ApiModelProperty(required = false)
    @Column(length = 100)
    private String logo;
/*
    @ManyToMany(mappedBy = "associationList")
    private List<Evenement> evenementList;
*/
}
