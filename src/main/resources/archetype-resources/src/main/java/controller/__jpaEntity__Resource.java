/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* Apache Velocity variables */
#set( $className = "${jpaEntity}Resource")
#set( $service = "${jpaEntity}Service")
#set($dto = "${jpaEntity}Dto")
#set( $entityDtoMapper = "${jpaEntity}EntityDtoMapper")
#set ($searchCriteria = "${jpaEntity}SearchCriteria")

package ${package}.controller;

import com.presiframework.common.rest.mapper.EntityDtoMapper;
import com.presiframework.common.rest.AbstractCrudRestService;
import com.presiframework.common.rest.CrudRestService;
import com.presiframework.common.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ${package}.entity.$jpaEntity;
import ${package}.dto.$dto;
import ${package}.dto.mapper.$entityDtoMapper;
import ${package}.service.$service;
import ${package}.searchcriteria.$searchCriteria;



/**
 * Servicio Rest para la gestion de $jpaEntity
 * 
 * URI:
 * GET /$jpaEntity/{id}: Buscar por id.
 * GET /$jpaEntity: Buscar todo.
 * GET /$jpaEntity/filtrados: Buscar por criterios de busqueda.
 * GET /$jpaEntity?nombre: Buscar por nombre
 * POST /$jpaEntity: Crear.
 * PUT /$jpaEntity: Actualizar.
 * DELETE /$jpaEntity/{id}: Eliminar
 * 
 * @author Miguel Presinal <presinal378@gmail.com>
 * @since 1.0
 */
@RestController
@RequestMapping(path = "/${jpaEntity}")
public class $className extends AbstractCrudRestService<$dto, $jpaEntity, $searchCriteria> implements CrudRestService<$dto, $searchCriteria> {

    private static final Logger LOGGER = LoggerFactory.getLogger(${className}.class);
    
    private final $service service;
    private final $entityDtoMapper mapper;

    @Autowired
    public $className($service service, $entityDtoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public CrudService<$jpaEntity, $searchCriteria> getServiceProvider() {
        return service;
    }

    @Override
    public EntityDtoMapper<$dto, $jpaEntity> getEntityDtoMapper() {
        return mapper;
    }
}
