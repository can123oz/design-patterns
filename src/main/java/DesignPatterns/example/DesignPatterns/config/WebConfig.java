package DesignPatterns.example.DesignPatterns.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    @Bean
    public OpenAPI DesignPatternsOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Design Patterns")
                        .description("Factory & Strategy Design Patterns")
                        .version("1.0"));
    }
}
