package wake.repository;

import org.springframework.beans.factory.annotation.Autowired;
import wake.model.Trace;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompositeTraceRepository implements TraceRepository {
    @Autowired
    List<TraceRepository> repositories;

    @Override
    public List<Trace> findAll() {
        return repositories.stream().flatMap((r) -> r.findAll().stream()).collect(Collectors.toList());
    }

    @Override
    public void add(Map<String, Object> map) {
        for (TraceRepository repository : repositories) {
            repository.add(map);
        }

    }
}
