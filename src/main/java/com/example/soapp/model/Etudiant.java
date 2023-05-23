package com.example.soapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name= "etudiant")
@Getter
@Setter
public class Etudiant {

    @ApiModelProperty(value = "auto generated id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(required = true)
    @Column(length = 100)
    private String nom;

    @ApiModelProperty(required = true)
    @Column(length = 100)
    private String prenom;

    @ApiModelProperty(required = true)
    @Column(length = 10)
    private String promotion;

    @ApiModelProperty(required = true)
    @Column(length = 100)
    private String mdp;

    @ApiModelProperty(required = true)
    @Column(length = 100)
    private String mail;

    @ApiModelProperty(required = true)
    @Column(length = 10)
    private String formation;

    @ApiModelProperty(required = false)
    @Column(length = 1000)
    private String photo;

    @ManyToMany
    @JoinTable(
            name = "event_etudiant",
            joinColumns = @JoinColumn(name = "etudiant_id" ),
            inverseJoinColumns = @JoinColumn(name = "evenement_id"))
    @JsonManagedReference
    @JsonIgnore
    private Set<Evenement> evenementParticipe;

    @ManyToMany
    @JoinTable(
            name = "asso_etudiant",
            joinColumns = @JoinColumn(name = "etudiant_id" ),
            inverseJoinColumns = @JoinColumn(name = "asso_id"))
    @JsonManagedReference
    @JsonIgnore
    private Set<Association> assoFavories;


    @Override
    public String toString() {
        return "\n Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", promotion='" + promotion + '\'' +
                ", mdp='" + mdp + '\'' +
                ", mail='" + mail + '\'' +
                ", formation='" + formation + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
