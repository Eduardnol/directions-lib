package io.eduardnol.direccions.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "io.eduardnol.direccions")
@EntityScan(basePackages = "io.eduardnol.direccions.entity")
@EnableJpaRepositories(basePackages = "io.eduardnol.direccions.repository")
@EnableConfigurationProperties(DireccionsProperties.class)
public class DireccionsAutoConfiguration {
    
    /**
     * Configures Hibernate to use the schema specified in direccions.schema property
     */
    @Bean
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(DireccionsProperties properties) {
        return hibernateProperties -> {
            hibernateProperties.put("hibernate.default_schema", properties.getSchema());
        };
    }
}
