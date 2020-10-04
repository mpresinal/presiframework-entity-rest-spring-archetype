/* Apache Velocity  */
#set ($className = "${jpaEntity}CorsFilter")

package ${package}.webfilter;

import com.presiframework.common.rest.filter.SimpleCorsFilter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miguel Presinal <presinal378@gmail.com>
 * @since 1.0
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class $className extends SimpleCorsFilter {

    @Autowired
    public $className(
            @Value("#{'${cors.allowed.origins}'.split(',')}") List<String> allowedOrigings,
            @Value("${cors.allowed.headers}") String allowedHeaders) {
        super(allowedOrigings, allowedHeaders);
    }    
}
