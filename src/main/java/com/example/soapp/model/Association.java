package com.example.soapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

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


    /*@JoinTable(
            name = "evenement",
            joinColumns = @JoinColumn(name ="association_id" ),
            inverseJoinColumns = @JoinColumn(name = "evenement_id"))
    @JsonManagedReference
    @JsonIgnore
    private Evenement evenementList;*/

    /*@OneToMany
    @JoinTable(
            name = "event_asso",
            joinColumns = @JoinColumn(name = "evenement_id"),
            inverseJoinColumns = @JoinColumn(name = "association_id"))
    @JsonManagedReference
    @JsonIgnore
    private Set<Evenement> evenementList;*/

   /* @OneToMany
    @JoinTable(
            name = "post_asso",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "association_id"))
    @JsonManagedReference
    @JsonIgnore
    private Set<Post> postList;*/
}
