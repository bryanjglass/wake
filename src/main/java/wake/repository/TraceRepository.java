package wake.repository;

import wake.model.Trace;

import java.util.List;
import java.util.Map;

public interface TraceRepository {
    List<Trace> findAll();

    void add(Map<String, Object> map);
}
