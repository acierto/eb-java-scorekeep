package scorekeep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class WebConfig {
    private static final Logger logger = LoggerFactory.getLogger(WebConfig.class);

    @Bean
    public Filter SimpleCORSFilter() {
        return new SimpleCORSFilter();
    }

    static {
        if (System.getenv("NOTIFICATION_EMAIL") != null) {
            try {
                Sns.createSubscription();
            } catch (Exception e) {
                logger.warn("Failed to create subscription for email " + System.getenv("NOTIFICATION_EMAIL"));
            }
        }
    }
}
