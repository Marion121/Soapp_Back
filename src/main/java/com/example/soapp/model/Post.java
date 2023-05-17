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
@Table(name= "post")
@Getter
@Setter
public class Post {

    @ApiModelProperty(value = "auto generated id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(required = true)
    @Column(length = 100)
    private String nom;

    @ApiModelProperty(required = true)
    private Date dateCreation;

    /*@ManyToMany(mappedBy = "postList")
    @JsonManagedReference
    @JsonIgnore
    private Set<Association> association;*/

    @ApiModelProperty(required = true)
    @JoinTable(
            name = "association",
            joinColumns = @JoinColumn(name ="association_id" ),
            inverseJoinColumns = @JoinColumn(name = "evenement_id"))
    @JsonManagedReference
    @JsonIgnore
    private Long association_id;

    @ApiModelProperty(required = false)
    @Column(length = 1000)
    private String description ;

    @ApiModelProperty(required = false)
    @Column(length = 200)
    private String lien ;

    @ApiModelProperty(required = false)
    @Column(length = 50)
    private String titre_lien ;
}
