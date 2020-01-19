/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* Apache Velocity variables */
#set( $className = "${jpaEntity}ApplicationConfig")

package ${package}.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Miguel Presinal <presinal378@gmail.com>
 * @since 1.0
 */
@Configuration
@PropertySource("classpath:/config/${jpaEntity}/application.properties")
@ComponentScan(basePackages = {
    "${package}.controller", 
    "${package}.dto.mapper",
    "${package}.service"    
})
@EnableJpaRepositories(basePackages = "${package}.repository")
@EntityScan(basePackages = "${package}.entity")
@EnableTransactionManagement
public class $className {

}
