#set( $className = "${jpaEntity}IntegrityValidator")
#set( $repository = "${jpaEntity}Repository")


package ${package}.service.validator;

import com.presiframework.common.datalayer.entities.exceptions.ExistingDataException;
import com.presiframework.common.datalayer.entities.exceptions.IntegrityViolationException;
import com.presiframework.common.datalayer.entities.validator.IntegrityValidator;
import ${package}.entity.$jpaEntity;
import ${package}.repository.$repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author $developerName <$developerEmail>
 * @since 1.0
 */
@Component
public class $className implements IntegrityValidator<$jpaEntity> {

    private static Logger logger = LoggerFactory.getLogger(${className}.class);

    private final $repository repository;

    @Autowired
    public $className($repository repository) {
        this.repository = repository;
    }

    
    @Override
    public void validate($jpaEntity entity) throws ExistingDataException, IntegrityViolationException {
        final String METHOD = "validate():: ";
        logger.info(METHOD + "Enter");
        logger.debug(METHOD + "entity = " + entity);
        
        String name = entity.getName();
        logger.debug(METHOD + "Checking that does not exist a record with this name:" + name + "...");
        $jpaEntity resp = repository.getByNameIgnoreCase(entity.getName());
        logger.debug(METHOD + "** resp = " + resp);
        
        if (resp != null && !resp.getId().equals(entity.getId())) {
            throw new ExistingDataException("Already exists a record with this name: "+name);
        }
        logger.debug(METHOD + "Checking that does not exist a record with this name:" + name + "...OK");
        
        logger.info(METHOD + "Exit");
    }
}
