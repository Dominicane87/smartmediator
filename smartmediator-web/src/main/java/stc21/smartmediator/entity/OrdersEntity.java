package stc21.smartmediator.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "orders", schema = "public", catalog = "postgres")
public class OrdersEntity {
    private UUID id;
    private String note;
    private UUID statusId;
    private UUID buyerId;
    private UUID sellerId;
    private UUID deliveryTypeId;
    private UUID pricePatternId;
    private UUID getFrom;
    private UUID setTo;

    public OrdersEntity(
            String note,
            UUID statusId,
            UUID buyerId,
            UUID sellerId,
            UUID deliveryTypeId,
            UUID pricePatternId,
            UUID getFrom,
            UUID setTo) {
        this.note = note;
        this.statusId = statusId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.deliveryTypeId = deliveryTypeId;
        this.pricePatternId = pricePatternId;
        this.getFrom = getFrom;
        this.setTo = setTo;
    }

    public OrdersEntity() {

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
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Column(name = "status")
    public UUID getStatusId() {
        return statusId;
    }

    public void setStatusId(UUID statusId) {
        this.statusId = statusId;
    }

    @Column(name = "buyer_id")
    public UUID getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(UUID buyerId) {
        this.buyerId = buyerId;
    }

    @Column(name = "delivery")
    public UUID getDeliveryTypeId() {
        return deliveryTypeId;
    }

    public void setDeliveryTypeId(UUID value) {
        this.deliveryTypeId = value;
    }

    @Column(name = "price_pattern_id")
    public UUID getPricePatternId() {
        return pricePatternId;
    }

    public void setPricePatternId(UUID value) {
        this.pricePatternId = value;
    }

    @Column(name = "get_from")
    public UUID getGetFrom() {
        return getFrom;
    }

    public void setGetFrom(UUID value) {
        this.getFrom = value;
    }

    @Column(name = "set_to")
    public UUID getSetTo() {
        return setTo;
    }

    public void setSetTo(UUID value) {
        this.setTo = value;
    }

    @Column(name = "seller_id")
    public UUID getSellerId() {
        return sellerId;
    }

    public void setSellerId(UUID value) {
        this.sellerId = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, note);
    }
}
