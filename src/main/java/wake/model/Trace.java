package wake.model;

import org.springframework.util.Assert;

import java.time.Instant;
import java.util.Map;


public final class Trace {

    private final Instant timestamp;

    private final Map<String, Object> info;

    public Trace(Instant timestamp, Map<String, Object> info) {
        Assert.notNull(timestamp, "Timestamp must not be null");
        Assert.notNull(info, "Info must not be null");
        this.timestamp = timestamp;
        this.info = info;
    }

    public Instant getTimestamp() {
        return this.timestamp;
    }

    public Map<String, Object> getInfo() {
        return this.info;
    }

}