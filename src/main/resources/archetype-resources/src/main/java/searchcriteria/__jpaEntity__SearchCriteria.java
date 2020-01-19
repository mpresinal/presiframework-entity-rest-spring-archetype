/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* Apache Velocity variables */
#set ($className = "${jpaEntity}SearchCriteria")

package ${package}.searchcriteria;

import com.presiframework.common.datalayer.jpa.spring.repository.filter.ExampleSearchCriteria;

import static com.presiframework.common.datalayer.entities.validator.util.EntityValidatorUtil.validateNotNullNotEmpty;
import org.springframework.data.domain.ExampleMatcher;

import ${package}.entity.$jpaEntity;

/**
 *
 * @author Miguel Presinal <presinal378@gmail.com>
 * @since 1.0
 */
public class $className implements ExampleSearchCriteria<$jpaEntity> {

    private String name;
    private String status;

    public ExampleMatcher getMatcher() {
        return null;
    }
    
    public $jpaEntity getEntity() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() +"{" + "name=" + name + ", status=" + status + '}';
    }
}
