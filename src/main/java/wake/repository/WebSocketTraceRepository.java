package wake.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import wake.model.Trace;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class WebSocketTraceRepository implements TraceRepository {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Override
    public List<Trace> findAll() {
        return Collections.emptyList();
    }

    @Override
    public void add(Map<String, Object> map) {
        messagingTemplate.convertAndSend("/topic/traces" + map.get("path"), new Trace(Instant.now(), map));
    }
}
