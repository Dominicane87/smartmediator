package stc21.smartmediator.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "external_links", schema = "public", catalog = "postgres")
public class ExternalLinksEntity {
    private UUID id;
    private String code;
    private UUID sellerId;
    private UUID productId;

    public ExternalLinksEntity(String code, UUID sellerId, UUID productId) {
        this.code = code;
        this.sellerId = sellerId;
        this.productId = productId;
    }

    public ExternalLinksEntity() {

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

    @Column
    public UUID getSellerId() {
        return sellerId;
    }

    public void setSellerId(UUID value) {
        this.sellerId = value;
    }

    @Column
    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID value) {
        this.productId = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExternalLinksEntity that = (ExternalLinksEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code);
    }
}
