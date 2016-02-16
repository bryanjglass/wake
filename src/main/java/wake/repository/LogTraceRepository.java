package wake.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wake.model.Trace;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LogTraceRepository implements TraceRepository {
    private static final Logger LOG = LoggerFactory.getLogger(LogTraceRepository.class);

    @Override
    public List<Trace> findAll() {
        return Collections.emptyList();
    }

    @Override
    public void add(Map<String, Object> map) {
        LOG.info("{}", map);
    }
}
