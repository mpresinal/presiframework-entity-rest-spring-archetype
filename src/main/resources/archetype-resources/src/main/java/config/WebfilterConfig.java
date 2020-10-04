package ${package}.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Webfilter configuration.
 * The purpose of this config class is to allow this config to be skipped from
 * any component scan when the service is deployed as a monolithic
 * application 
 * 
 * @author Miguel Presinal <presinal378@gmail.com>
 * @since 1.0
 */
@Configuration
@ComponentScan(basePackages = "${package}.webfilter")
public class WebfilterConfig {

}
