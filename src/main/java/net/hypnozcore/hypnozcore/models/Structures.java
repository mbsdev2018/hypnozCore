package net.hypnozcore.hypnozcore.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import net.hypnozcore.hypnozcore.emus.TypeEntreprise;

import javax.persistence.*;
import java.io.Serial;
import java.time.LocalDate;

@Entity
@Table(name = "structures")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor()
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "{id}")
@Builder
public class Structures extends AbstractEntity{
    @Serial
    static final long serialVersionUID = -563840516246290525L;
    String raisonSocial;
    String sigle;
    @Lob
    String description;
    String zoneFiscale;
    String zoneFiscale2;
    LocalDate dateFiscale;
    @Enumerated(EnumType.STRING)
    TypeEntreprise typeEntreprise;
    String bilanSocail;
    String formJuridique;
    String adresse;
    String ville;
    String departement;
    String pays;
    String telephone;
    String email;
    String siteweb;
    @Lob
    String logo;
    private String activiteCommerciale;
    private String responsable;
    private String qualiteResponsable;
    private String capital;
}