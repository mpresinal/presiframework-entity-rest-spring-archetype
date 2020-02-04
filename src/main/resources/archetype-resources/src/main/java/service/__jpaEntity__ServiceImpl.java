/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* Apache Velocity variables */
#set( $className = "${jpaEntity}ServiceImpl")
#set( $serviceInterface = "${jpaEntity}Service")
#set( $repository = "${jpaEntity}Repository")
#set ($searchCriteria = "${jpaEntity}SearchCriteria")

package ${package}.service;

import com.presiframework.common.datalayer.entities.exceptions.BaseException;
import com.presiframework.common.datalayer.entities.exceptions.RequiredFieldException;
import com.presiframework.common.service.exception.InternalServiceException;
import com.presiframework.common.datalayer.entities.exceptions.NoDataFoundException;
import com.presiframework.commons.service.jpa.spring.AbstractJpaSpringCrudService;
import com.presiframework.common.datalayer.entities.validator.EntityValidator;
import com.presiframework.common.datalayer.entities.validator.AbstractEntityValidatorBeanValidation;
import com.presiframework.common.datalayer.entities.validator.IntegrityValidator;

import com.presiframework.common.datalayer.entities.validator.util.EntityValidatorUtil;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ${package}.entity.$jpaEntity;
import ${package}.repository.$repository;
import $import java.util.Arrays;
{package}.searchcriteria.$searchCriteria;
/**
 *
 * @author Miguel Presinal <presinal378@gmail.com>
 * @since 1.0
 */
@Service
@Transactional
public class $className extends AbstractJpaSpringCrudService<$jpaEntity, $searchCriteria> implements $serviceInterface {

    private static final Logger LOGGER = LoggerFactory.getLogger(${className}.class);

    private $repository repository;
    private EntityValidator<$jpaEntity> entityValidator;
    
    public Logger getLogger() {
        return LOGGER;
    }

    @Override
    @Transactional(readOnly = true)
    public $jpaEntity findByNombre(String name) throws RequiredFieldException, NoDataFoundException, InternalServiceException {
        final String METHOD = "findByNombre():: ";
        LOGGER.info(METHOD + "Enter");
        LOGGER.info(METHOD + "name = " + name);

        try {
            EntityValidatorUtil.validateNotNullNotEmpty(name, "name");
            $jpaEntity entity = repository.getByNameIgnoreCase(name);
            if (entity == null) {
                throw new NoDataFoundException();
            }

            LOGGER.info(METHOD + "Returning entity = " + entity);
            return entity;
        } catch (BaseException e) {
            LOGGER.info(METHOD + "throwing exception: " + e.getClass().getSimpleName());
            throw e;

        } finally {
            LOGGER.info(METHOD + "Exit");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<$jpaEntity> findByStatus(String status) throws InternalServiceException {
        final String METHOD = "findByStatus():: ";
        LOGGER.info(METHOD + "Enter");
        LOGGER.info(METHOD + "status = " + status);

        try {
            $searchCriteria filter = new $searchCriteria();
            filter.setStatus(status);
            return super.filter(filter);
        } finally {
            LOGGER.info(METHOD + "Exit");
        }
    }

    @Override
    public IntegrityValidator<$jpaEntity> getIntegrityValidator() {        
        return null;
    }

    @Override
    public EntityValidator<$jpaEntity> getEntityValidator() {            
        if (entityValidator == null) {
            entityValidator = new AbstractEntityValidatorBeanValidation<$jpaEntity>() {
                @Override
                public List<?> getEntityReferences($jpaEntity entity) {
                    return null;
                }
            };
        }

        return entityValidator;
    }

    @Override
    public $repository getRepository() {
        return repository;
    }

    @Autowired
    public void setRepository($repository repository) {
        this.repository = repository;
    }

}
