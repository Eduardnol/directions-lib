package io.eduardnol.direccions.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for the Direccions library.
 * 
 * Usage in application.yml:
 * <pre>
 * direccions:
 *   schema: my_custom_schema
 * </pre>
 */
@Data
@ConfigurationProperties(prefix = "direccions")
public class DireccionsProperties {
    
    /**
     * Database schema where direccions tables are located.
     * Defaults to "public" if not specified.
     */
    private String schema = "public";
}
