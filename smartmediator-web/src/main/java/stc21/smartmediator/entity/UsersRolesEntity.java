package stc21.smartmediator.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "user_role", schema = "public", catalog = "postgres")
public class UsersRolesEntity {

    @Id
    @Column(name = "user_id")
    private UUID user_id;

    @Basic
    @Column(name = "roles")
    private String roles;

    public UsersRolesEntity() {
    }

    public UsersRolesEntity(UUID user_id, String roles) {
        this.user_id = user_id;
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersRolesEntity that = (UsersRolesEntity) o;
        return Objects.equals(user_id, that.user_id) &&
                Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, roles);
    }

}
