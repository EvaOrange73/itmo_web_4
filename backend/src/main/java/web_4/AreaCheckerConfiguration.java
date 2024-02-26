package web_4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AreaCheckerConfiguration {
    @Bean
    public AreaChecker getAreaChecker() {
        return new AreaChecker();
    }
}
