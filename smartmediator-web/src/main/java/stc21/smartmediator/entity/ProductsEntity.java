package stc21.smartmediator.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "products", schema = "public", catalog = "postgres")
public class ProductsEntity {
    private UUID id;
    private String code;
    private String name;
    private BigDecimal quantity;
    private String note;
    private Boolean deleted;
    private UUID unitId;
    private UUID productTypeId;
    private UUID sellerId;

    public ProductsEntity(
            String code, String name, BigDecimal quantity, String note, UUID unitId, UUID productTypeId, UUID sellerId) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.note = note;
        this.deleted = false;
        this.unitId = unitId;
        this.productTypeId = productTypeId;
        this.sellerId = sellerId;
    }

    public ProductsEntity() {

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
    @Column(name = "quantity")
    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
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

    @Column(name="unit_id")
    public UUID getUnitId() {
        return unitId;
    }

    public void setUnitId(UUID unitId) {
        this.unitId = unitId;
    }

    @Column(name = "products_type_id")
    public UUID getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(UUID typeId) {
        this.productTypeId = typeId;
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
        ProductsEntity that = (ProductsEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(code, that.code) &&
                Objects.equals(name, that.name) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(note, that.note) &&
                Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, quantity, note, deleted);
    }
}
