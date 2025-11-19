package io.eduardnol.direccions.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

class DireccionsPropertiesDefaultTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withUserConfiguration(TestConfiguration.class);

    @Test
    void shouldLoadDefaultSchemaWhenNotSpecified() {
        contextRunner
            .run(context -> {
                assertThat(context).hasSingleBean(DireccionsProperties.class);
                DireccionsProperties properties = context.getBean(DireccionsProperties.class);
                assertThat(properties.getSchema()).isEqualTo("public");
            });
    }

    @EnableConfigurationProperties(DireccionsProperties.class)
    static class TestConfiguration {
    }
}
