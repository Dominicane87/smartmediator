package stc21.smartmediator.model.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users_organizations", schema = "public", catalog = "postgres")
public class UsersOrganizationsEntity {
    private UUID id;
    private UUID user_id;
    private UUID org_id;

    public UsersOrganizationsEntity(UUID user_id, UUID org_id) {
        this.user_id = user_id;
        this.org_id = org_id;
    }

    public UsersOrganizationsEntity() {

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public UUID getId() {
        return id;
    }

    private void setId(UUID id) {
        this.id = id;
    }

    @Column(name = "user_id")
    public UUID getUserId() {
        return user_id;
    }

    public void setUserId(UUID id) {
        this.user_id = id;
    }

    @Column(name = "org_id")
    public UUID getOrgId() {
        return org_id;
    }

    public void setOrgId(UUID id) {
        this.org_id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersOrganizationsEntity that = (UsersOrganizationsEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
