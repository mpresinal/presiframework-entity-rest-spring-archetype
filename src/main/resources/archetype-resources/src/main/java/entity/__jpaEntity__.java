/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ${package}.entity;

import com.presiframework.common.datalayer.jpa.entity.JpaCommonEntity;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Miguel Presinal <presinal378@gmail.com>
 * @since 1.0
 */
@Entity
@Table(name = "$tableName", schema = "dbo")
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "${tableName}_ID"))
})
@Access(AccessType.PROPERTY)
@Where(clause = "deleted = 0")
public class $jpaEntity extends JpaCommonEntity {

    @NotEmpty
    @Size(max = 100)
    private String name;
    
    public $jpaEntity() {
    }

    public $jpaEntity(Long id) {
        super(id);
    }
    
    @Column(name = "NAME", length = 100, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
    
    @Override
    public String toString() {
        String properties = "name=" + name;
        return super.toString(getClass().getSimpleName(), properties);
    }
}
