/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* Apache Velocity variables */
#set( $className = "${jpaEntity}Service")
#set ($searchCriteria = "${jpaEntity}SearchCriteria")

package ${package}.service;

import com.presiframework.common.datalayer.entities.exceptions.RequiredFieldException;
import com.presiframework.common.service.exception.InternalServiceException;
import com.presiframework.common.datalayer.entities.exceptions.NoDataFoundException;
import com.presiframework.commons.service.jpa.spring.JpaSpringCrudService;
import java.util.List;
import ${package}.entity.$jpaEntity;
import ${package}.searchcriteria.$searchCriteria;


/**
 *
 * @author Miguel Presinal <presinal378@gmail.com>
 * @since 1.0
 */
public interface $className extends JpaSpringCrudService<$jpaEntity, $searchCriteria> {

    $jpaEntity findByNombre(String name) throws RequiredFieldException, NoDataFoundException, InternalServiceException;

    List<$jpaEntity> findByStatus(String status) throws InternalServiceException;
}
