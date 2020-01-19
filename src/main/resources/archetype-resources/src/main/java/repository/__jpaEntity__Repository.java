/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* Apache Velocity variables */
#set( $className = "${jpaEntity}Repository")

package ${package}.repository;

import com.presiframework.common.datalayer.jpa.spring.repository.CRUDSpringRepository;
import ${package}.entity.$jpaEntity;

/**
 *
 * @author Miguel Presinal <presinal378@gmail.com>
 * @since 1.0
 */
public interface $className extends CRUDSpringRepository<$jpaEntity, Long> {

    $jpaEntity getByNameIgnoreCase(String name);
}
