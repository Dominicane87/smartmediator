package stc21.smartmediator.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "sellers", schema = "public", catalog = "postgres")
public class SellersEntity {
    private UUID id;
    private UUID orgId;

    public SellersEntity(UUID orgId) {
        this.orgId = orgId;
    }

    public SellersEntity() {

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Column(name = "org_id")
    public UUID getOrgId() {
        return orgId;
    }

    public void setOrgId(UUID id) {
        this.orgId = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellersEntity that = (SellersEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
