package stc21.smartmediator.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users", schema = "public", catalog = "postgres")
public class UsersEntity {
    private UUID id;
    private String email;
    private String password;
    private String username;
//    private UUID role;
    private UUID status;
    private Boolean active;

    public UsersEntity(String email, String password_hash,
                       String full_name,
//                       UUID role_id,
                       UUID status_id, Boolean active) {
        this.email = email;
        this.password = password_hash;
        this.username = full_name;
//        this.role = role_id;
        this.status = status_id;
        this.active = active;
    }

    public UsersEntity() {

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

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordHash) {
        this.password = passwordHash;
    }

//    @Column(name = "role")
//    public UUID getRole() {
//        return role;
//    }
//
//    public void setRole(UUID value) { role = value; }

    @Column(name = "status")
    public UUID getStatus() {
        return status;
    }

    public void setStatus(UUID value) { status = value; }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String fullName) {
        this.username = fullName;
    }

    @Basic
    @Column(name = "active")
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, username);
    }
}
