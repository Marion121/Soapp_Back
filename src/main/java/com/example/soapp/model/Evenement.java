package com.example.soapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name= "evenement")
@Getter
@Setter
public class Evenement {
    @ApiModelProperty(value = "auto generated id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(required = true)
    @Column(length = 100)
    private String nom;

    @ApiModelProperty(required = false)
    @Column(length = 100)
    private String lieu;

    @ApiModelProperty(required = true)
    private Date dateCreation;

    @ApiModelProperty(required = true)
    private Date date_evenement;

    @ApiModelProperty(required = true)
    private Boolean validation;

    @ApiModelProperty(required = false)
    private int nbr_place;

    @ApiModelProperty(required = false)
    private Date date_heure_shotgun;

    @ApiModelProperty(required = false)
    @Column(length = 1000)
    private String description ;

    @ApiModelProperty(required = false)
    @Column(length = 200)
    private String lien ;

    @ApiModelProperty(required = false)
    @Column(length = 50)
    private String titre_lien ;

    @ApiModelProperty(required = false)
    private float prix_cotisant;

    @ApiModelProperty(required = false)
    private float prix_non_cotisant;


    @ManyToMany(mappedBy = "evenementList")
    @JsonManagedReference
    @JsonIgnore
    private Set<Association> association;

/*
    @ApiModelProperty(required = false)
    private List<long> liste_association_liee = new ArrayList<>();*/



}