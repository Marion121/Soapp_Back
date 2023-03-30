package model;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;

@Entity
@Table(name= "association")
public class Association {

    @ApiModelProperty(value = "auto generated id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_association;

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
}
