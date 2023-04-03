package com.s3.microservice.config.env;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AppConfig {
    private final Environment env;
    public AppConfig(final Environment environment) {
        env = environment;
    }

    @PostConstruct
    private void init() {

        AppProperties.CONTEXT_PATH = env.getProperty("server.servlet.context-path", "");
        AppProperties.SWAGGER_REQUEST_URL = env.getProperty("swagger.request-url", "");
        AppProperties.CONTACT_NAME = env.getProperty("contact.name", "");
        AppProperties.CONTACT_URL = env.getProperty("contact.url", "");
        AppProperties.CONTACT_EMAIL = env.getProperty("contact.email", "");
        AppProperties.AMAZON = env.getProperty("amazon", "");
    }
}
