package wake;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import wake.config.WebSocketConfiguration;
import wake.repository.CompositeTraceRepository;
import wake.repository.LogTraceRepository;
import wake.repository.MemoryTraceRepository;
import wake.repository.WebSocketTraceRepository;

@SpringBootApplication
@Import(WebSocketConfiguration.class)
public class WakeApplication {
    private static final Logger LOG = LoggerFactory.getLogger(WakeApplication.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(WakeApplication.class, args);
    }

    @Bean
    @Primary
    public CompositeTraceRepository compositeTraceRepository() {
        return new CompositeTraceRepository();
    }

    @Bean
    public LogTraceRepository logTraceRepository() {
        return new LogTraceRepository();
    }

    @Bean
    public MemoryTraceRepository memoryTraceRepository() {
        return new MemoryTraceRepository();
    }
}
