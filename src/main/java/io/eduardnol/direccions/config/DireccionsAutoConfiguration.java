package io.eduardnol.direccions.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "io.eduardnol.direccions")
@EntityScan(basePackages = "io.eduardnol.direccions.entity")
@EnableJpaRepositories(basePackages = "io.eduardnol.direccions.repository")
public class DireccionsAutoConfiguration {
}
