/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

## Apache Velocity variables
#set( $className = "${jpaEntity}ServiceTest")
#set( $serviceInterface = "${jpaEntity}Service")
#set ($searchCriteria = "${jpaEntity}SearchCriteria")

package ${package}.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import ${package}.RestApplicationTest;
import ${package}.config.TestApplicationConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.core.io.ClassPathResource;
import java.sql.Connection;
import javax.persistence.EntityManagerFactory;
import org.hibernate.Session;
import com.presiframework.common.test.DefaultCrudServiceTest;
import com.presiframework.common.test.CrudServiceTestConfig;
import com.presiframework.common.datalayer.entities.enums.EntityStatus;
import ${package}.entity.$jpaEntity;
import ${package}.service.$service;
import ${package}.searchcriteria.$searchCriteria;

/**
 *
 * @author Miguel Presinal <presinal378@gmail.com>
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestApplicationTest.class)
@ContextConfiguration(classes = TestApplicationConfig.class)
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application.properties")
public class $className  extends DefaultCrudServiceTest<$jpaEntity, $searchCriteria> {

    private static Logger logger = LoggerFactory.getLogger(${className}.class);
    private final Long CREATED_BY = 2L;
    
    @Autowired
    private $serviceInterface service;
    
    @Autowired
    protected EntityManagerFactory entityManagerFactory;

    public $className() {

        $jpaEntity entityToSave = new $jpaEntity();
        entityToSave.setName("PROD-5");
        entityToSave.setCreatedBy(CREATED_BY);
        entityToSave.setUpdatedBy(CREATED_BY);
        
        $jpaEntity entityToUpdate = new $jpaEntity();
        entityToUpdate.setId(2L);
        entityToUpdate.setName("PROD-6");
        entityToUpdate.setCreatedBy(CREATED_BY);
        entityToUpdate.setUpdatedBy(CREATED_BY);
        
        $jpaEntity existingEntity = new $jpaEntity();
        existingEntity.setId(2L);
        existingEntity.setName("PROD-2");
        existingEntity.setCreatedBy(CREATED_BY);
        existingEntity.setUpdatedBy(CREATED_BY);

        CrudServiceTestConfig<$jpaEntity, $searchCriteria> config = new CrudServiceTestConfig<>();
        config.setDataInstanceToSave(entityToSave);
        config.setDataInstanceToUpdate(entityToUpdate);
        config.setExistingDataInstaceToSave(existingEntity);
        
        config.setFindAllExpectedValue(4); // Change this value
        
        $searchCriteria criterios = new $searchCriteria();        
        criterios.setStatus(EntityStatus.INACTIVE.getValue()); // change this value according to your neeeds
        config.setSearchCriteriaStateIN(criterios);
        config.setFindAllFlowSearchCriteriaStateINExpectedValue(2);  // change this value according to your needs
        
        // Disabling all test. enable it according to your needs        
        config.setEnableTestExistingDataInstance(false);
        config.setEnableTestsFlowRequiredFieldCreatedBy(true);
        config.setEnableTestsFlowIntegrityViolation(false);
        config.setEnableTestsFlowExistingData(false);
        config.setEnableTestsCreateFlowExistingData(true);
        config.setEnableTestFlowSearchCriteriaStateIN(true);
        
        setTestConfig(config);
       
    }

    @Override
    public void setUp() {
        final String METHOD = "setUp() :: ";
        Logger logger = getLogger();
        logger.info(METHOD + "Enter");
        
        Session hibernateSession = entityManagerFactory.createEntityManager().unwrap(Session.class);
        hibernateSession.doWork((Connection connection) -> {

            logger.info(METHOD + "Cleaning up data....");
            ScriptUtils.executeSqlScript(connection, new ClassPathResource(getCleanScript()));
            logger.info(METHOD + "Cleaning up data....DONE!!");

            logger.info(METHOD + "Initializing data....");
            ScriptUtils.executeSqlScript(connection, new ClassPathResource(getInsertScript()));
            logger.info(METHOD + "Initializing data....DONE!!");
        });

        logger.info(METHOD + "Exit");
    }
    
    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    @Autowired
    public void setInsertScript(@Value("data/${jpaEntity}/${jpaEntity}-insert_data.sql") String insertScript) {
        super.setInsertScript(insertScript);
    }

    @Override
    @Autowired
    public void setCleanScript(@Value("data/${jpaEntity}/${jpaEntity}-clean_data.sql") String cleanScript) {
        super.setCleanScript(cleanScript);
    }

    @Override
    protected $serviceInterface getService() {
        return service;
    }

}
