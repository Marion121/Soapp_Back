package model;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import org.springframework.data.mapping.Association;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name= "evenement")
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
    private Date date_creation;

    @ApiModelProperty(required = true)
    private Date date_evenement;

    @ApiModelProperty(required = true)
    private Boolean validation;

    @ApiModelProperty(required = true)
    @OneToOne
    @JoinColumn(name = "id_association")
    private Association association;

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
    private long prix_cotisant;

    @ApiModelProperty(required = false)
    private long prix_non_cotisant;

    @ApiModelProperty(required = false)
    private List<long> liste_association_liee = new ArrayList<>();
}
