/* Apache Velocity variables */
#set( $className = "${jpaEntity}RestApplication")

package $package;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "${package}.config")
public class $className {

	public static void main(String[] args) {
		SpringApplication.run(${className}.class, args);
	}

}
