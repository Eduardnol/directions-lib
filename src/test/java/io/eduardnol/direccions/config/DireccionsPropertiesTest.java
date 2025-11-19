package io.eduardnol.direccions.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

class DireccionsPropertiesTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withUserConfiguration(TestConfiguration.class);

    @Test
    void shouldLoadCustomSchemaProperty() {
        contextRunner
            .withPropertyValues("direccions.schema=custom_schema")
            .run(context -> {
                assertThat(context).hasSingleBean(DireccionsProperties.class);
                DireccionsProperties properties = context.getBean(DireccionsProperties.class);
                assertThat(properties.getSchema()).isEqualTo("custom_schema");
            });
    }

    @EnableConfigurationProperties(DireccionsProperties.class)
    static class TestConfiguration {
    }
}
