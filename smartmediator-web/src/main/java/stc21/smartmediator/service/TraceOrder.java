package stc21.smartmediator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stc21.smartmediator.entity.TraceOrdersEntity;
import stc21.smartmediator.repository.TraceOrdersRepository;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.*;

@Component
public class TraceOrder {
   public final String noteFieldName = "note";
   public final String createDateFieldName = "create_date";

   public final TraceOrdersRepository repository;

   @Autowired
   public TraceOrder(TraceOrdersRepository repository) {
       this.repository = repository;
   }

    public TraceOrdersEntity get(UUID id) {
        Optional<TraceOrdersEntity> trace = repository.findById(id);
        return trace.orElse(null);
    }

    public ArrayList<TraceOrdersEntity> getAll() {
        Iterable<TraceOrdersEntity> traces = repository.findAll();
        ArrayList<TraceOrdersEntity> traceList = new ArrayList<>();
        traces.forEach(traceList::add);
        return traceList;
    }

    public TraceOrdersEntity update(UUID id, Map<String, String> fields) {

        TraceOrdersEntity trace = repository.findById(id).orElse(null);
        if(trace == null) {
            throw new IllegalStateException("TraceOrder with id = " + id + " not found.");
        }

        String note = fields.get(noteFieldName);
        if(note != null) {
            trace.setNote(note);
        }

        String createDate = fields.get(createDateFieldName);
        if(createDate != null) {
            trace.setCreateDate(Timestamp.valueOf(createDate));
        }

        return repository.save(trace);
    }

    @Transactional
    public int deleteByAuthor(UUID userId) {
        Collection<TraceOrdersEntity> traces = repository.findAllByAuthor(userId);
        traces.forEach(
                x -> delete(x.getId()));
        return traces.size();
    }

    @Transactional
    public int deleteByOrderId(UUID orderId) {
        Collection<TraceOrdersEntity> traces = repository.findAllByOrderId(orderId);
        traces.forEach(
                x -> delete(x.getId()));
        return traces.size();
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
