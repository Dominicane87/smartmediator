package stc21.smartmediator.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "price_patterns", schema = "public", catalog = "postgres")
public class PricePatternsEntity {
    private UUID id;
    private String code;
    private String name;
    private UUID parentId;
    private Timestamp createDate;
    private String note;
    private Boolean deleted;
    private UUID sellerId;

    public PricePatternsEntity(String code, String name, UUID parentId, String note, UUID sellerId) {
        this.code = code;
        this.name = name;
        this.parentId = parentId;
        this.note = note;
        this.sellerId = sellerId;
        this.createDate = Timestamp.valueOf(LocalDateTime.now());
        this.deleted = false;
    }

    public PricePatternsEntity() {

    }

    @Id
    @Column(name = "id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    @Column(name = "parent_id")
    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "deleted")
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Column(name = "seller_id")
    public UUID getSellerId() {
        return this.sellerId;
    }

    public void setSellerId(UUID sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PricePatternsEntity that = (PricePatternsEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(code, that.code) &&
                Objects.equals(name, that.name) &&
                Objects.equals(parentId, that.parentId) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(note, that.note) &&
                Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, parentId, createDate, note, deleted);
    }
}
