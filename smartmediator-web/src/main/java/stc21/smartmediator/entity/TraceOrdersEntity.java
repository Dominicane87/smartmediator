package stc21.smartmediator.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "trace_orders", schema = "public", catalog = "postgres")
public class TraceOrdersEntity {
    private UUID id;
    private Timestamp createDate;
    private String note;
    private UUID statusId;
    private UUID author;
    private UUID orderId;

    public TraceOrdersEntity(String note,
                             UUID statusId,
                             UUID author,
                             UUID orderId) {
        this.note = note;
        this.statusId = statusId;
        this.author = author;
        this.orderId = orderId;
        this.createDate = Timestamp.valueOf(LocalDateTime.now());
    }

    public TraceOrdersEntity() {

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

    @Column(name = "status")
    public UUID getStatusId() {
        return statusId;
    }

    public void setStatusId(UUID value) {
        this.statusId = value;
    }

    @Column(name = "author")
    public UUID getAuthor() {
        return author;
    }

    public void setAuthor(UUID value) {
        this.author = value;
    }

    @Column(name = "order_id")
    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID value) {
        this.orderId = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TraceOrdersEntity that = (TraceOrdersEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createDate, note);
    }
}
