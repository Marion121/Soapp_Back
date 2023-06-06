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
    private Date datePost;

    @ApiModelProperty(required = true)
    private Date date_debut_evenement;

    @ApiModelProperty(required = true)
    private Date date_fin_evenement;

    @ApiModelProperty(required = true)
    private String validation;

    @ApiModelProperty(required = false)
    private Integer nbr_place;

    @ApiModelProperty(required = false)
    private Date date_heure_shotgun;

    @ApiModelProperty(required = false)
    @Column(length = 1000)
    private String description ;

    @ApiModelProperty(required = false)
    @Column(length = 1000)
    private String text ;

    @ApiModelProperty(required = false)
    @Column(length = 1000)
    private String lien ;

    @ApiModelProperty(required = false)
    @Column(length = 50)
    private String titre_lien ;

    @ApiModelProperty(required = false)
    @Column(length = 50)
    private String poster ;

    @ApiModelProperty(required = false)
    private String prix;


    @ApiModelProperty(required = true)
    @JoinTable(
            name = "association",
            joinColumns = @JoinColumn(name ="association_id" ),
            inverseJoinColumns = @JoinColumn(name = "evenement_id"))
//    @JsonManagedReference
//    @JsonIgnore
    private Long association_id;


    @ManyToMany(mappedBy = "evenementParticipe")
    @JsonManagedReference
    @JsonIgnore
    private Set<Etudiant> etudiants;


    @Override
    public String toString() {
        return "Evenement{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", lieu='" + lieu + '\'' +
                ", dateCreation=" + dateCreation +
                ", datePost=" + datePost +
                ", date_debut_evenement=" + date_debut_evenement +
                ", date_fin_evenement=" + date_fin_evenement +
                ", validation='" + validation + '\'' +
                ", nbr_place=" + nbr_place +
                ", date_heure_shotgun=" + date_heure_shotgun +
                ", description='" + description + '\'' +
                ", text='" + text + '\'' +
                ", lien='" + lien + '\'' +
                ", titre_lien='" + titre_lien + '\'' +
                ", poster='" + poster + '\'' +
                ", prix_cotisant=" + prix +
                ", association_id=" + association_id +
                ", etudiants=" + etudiants +
                '}';
    }
}
