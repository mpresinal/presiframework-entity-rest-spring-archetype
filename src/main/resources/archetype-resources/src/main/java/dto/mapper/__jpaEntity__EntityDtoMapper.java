/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* Apache Velocity variables */
#set( $className = "${jpaEntity}EntityDtoMapper")
#set($dto = "${jpaEntity}Dto")

package ${package}.dto.mapper;

import com.presiframework.common.rest.mapper.BaseEntityDtoMapper;
import org.springframework.stereotype.Component;
import ${package}.entity.$jpaEntity;
import ${package}.dto.$dto;

/**
 * Mapper para convertir de EmpresaDto a Empresa y vice versa.
 * 
 * @author Miguel Presinal <presinal378@gmail.com>
 * @since 1.0
 */
@Component
public class $className extends BaseEntityDtoMapper<$dto, $jpaEntity> {

    @Override
    public $dto newDTO() {
        return new $dto();
    }
    
    @Override
    public $jpaEntity newEntity() {
        return new $jpaEntity();
    }

    @Override
    public void refreshDto($dto dto, $jpaEntity entity) {
        super.refreshDto(dto, entity);
        dto.setName(entity.getName());
    }

    @Override
    public void refreshEntity($jpaEntity entity, $dto dto) {
        super.refreshEntity(entity, dto);
        entity.setName(dto.getName());
    }
}