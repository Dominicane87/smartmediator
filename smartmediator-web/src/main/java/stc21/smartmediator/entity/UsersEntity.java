package stc21.smartmediator.entity;

import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users", schema = "public", catalog = "postgres")
public class UsersEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "password_hash")
    private String passwordHash;

    @Basic
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "role")
    private UUID role;

    @Column(name = "status")
    private UUID status;

    public UsersEntity(String email,
                       String password_hash,
                       String full_name,
                       UUID role_id,
                       UUID status_id) {
        this.email = email;
        this.passwordHash = password_hash;
        this.fullName = full_name;
        this.role = role_id;
        this.status = status_id;
    }

    public UsersEntity() {

    }

    public UUID getId() {
        return id;
    }

    private void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public UUID getStatus() {
        return status;
    }

    public void setStatus(UUID value) {
        status = value;
    }

    public void setPasswordHash(String password) {
        this.passwordHash = DigestUtils.md5Hex(password);
    }

    public String getFullName() {
        return fullName;
    }

    public UUID getRole() {
        return role;
    }

    public void setRole(UUID role) {
        this.role = role;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(email, that.email) &&
                Objects.equals(passwordHash, that.passwordHash) &&
                Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, passwordHash, fullName);
    }
}
