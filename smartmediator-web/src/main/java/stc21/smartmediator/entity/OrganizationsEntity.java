package stc21.smartmediator.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "organizations", schema = "public", catalog = "postgres")
public class OrganizationsEntity {
    private UUID id;
    private String fullName;
    private String name;
    private String inn;
    private String address;
    private UUID status;

    public OrganizationsEntity(
            String full_name, String name, String inn, String address, UUID status_id) {
        this.fullName = full_name;
        this.name = name;
        this.inn = inn;
        this.address = address;
        this.status = status_id;
    }

    public OrganizationsEntity() {

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
    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "inn")
    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "status")
    public UUID getStatus() {
        return status;
    }

    public void setStatus(UUID value) { status = value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationsEntity that = (OrganizationsEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(name, that.name) &&
                Objects.equals(inn, that.inn) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, name, inn, address);
    }
}
