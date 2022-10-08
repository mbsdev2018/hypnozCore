package net.hypnozcore.hypnozcore.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sites")
@Where(clause = "flag_etat <> 'DELETED'")
@SQLDelete(sql = "UPDATE sites SET flag_etat = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Sites extends AbstractEntity{
    @Column(name = "sit_code", length = 20)
    private String sitCode;

    @Column(name = "sit_nom_FR", length = 100)
    private String sitNomFr;

    @Column(name = "sit_inactif")
    private int sitInactif;

    @Column(name = "sit_id_responsable")
    private long sitIdResponsable;

    @Column(name = "sit_nom_responsable", length = 100)
    private String sitNomResponsable;

    @ManyToOne(fetch = FetchType.EAGER )
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(foreignKey = @ForeignKey(name = "str_fk", value = ConstraintMode.NO_CONSTRAINT),
            insertable = false, updatable = false)
    @MapsId("structuresId")
    private Structures structures;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Sites sites = (Sites) o;
        return getId() != null && Objects.equals(getId(), sites.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
