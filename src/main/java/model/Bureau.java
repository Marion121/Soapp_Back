package model;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import org.springframework.data.mapping.Association;

@Entity
@Table(name= "bureau")
public class Bureau {
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
