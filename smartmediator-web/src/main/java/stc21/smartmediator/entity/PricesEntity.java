package stc21.smartmediator.entity;

import org.postgresql.util.PGmoney;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "prices", schema = "public", catalog = "postgres")
public class PricesEntity {
    private UUID id;
    private BigDecimal cost;
    private UUID productId;
    private UUID pricePatternId;

    public PricesEntity(BigDecimal cost, UUID productId, UUID pricePatternId) {
        this.cost = cost;
        this.productId = productId;
        this.pricePatternId = pricePatternId;
    }

    public PricesEntity() {

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

    @Basic
    @Column(name = "cost")
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Column(name = "product_id")
    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID value) {
        this.productId = value;
    }

    @Column(name = "price_pattern_id")
    public UUID getPricePatternId() {
        return pricePatternId;
    }

    public void setPricePatternId(UUID value) {
        this.pricePatternId = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PricesEntity that = (PricesEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(cost, that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cost);
    }
}
