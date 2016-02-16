package wake.repository;
import wake.model.Trace;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * In-memory implementation of {@link TraceRepository}.
 *
 * @author Dave Syer
 * @author Olivier Bourgain
 */
public class MemoryTraceRepository implements TraceRepository {

    private int capacity = 100;

    private boolean reverse = true;

    private final List<Trace> traces = new LinkedList<Trace>();

    /**
     * Flag to say that the repository lists traces in reverse order.
     * @param reverse flag value (default true)
     */
    public void setReverse(boolean reverse) {
        synchronized (this.traces) {
            this.reverse = reverse;
        }
    }

    /**
     * Set the capacity of the in-memory repository.
     * @param capacity the capacity
     */
    public void setCapacity(int capacity) {
        synchronized (this.traces) {
            this.capacity = capacity;
        }
    }

    @Override
    public List<Trace> findAll() {
        synchronized (this.traces) {
            return Collections.unmodifiableList(new ArrayList<Trace>(this.traces));
        }
    }

    @Override
    public void add(Map<String, Object> map) {
        Trace trace = new Trace(Instant.now(), map);
        synchronized (this.traces) {
            while (this.traces.size() >= this.capacity) {
                this.traces.remove(this.reverse ? this.capacity - 1 : 0);
            }
            if (this.reverse) {
                this.traces.add(0, trace);
            }
            else {
                this.traces.add(trace);
            }
        }
    }

}