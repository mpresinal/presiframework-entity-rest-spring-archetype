/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ${package}.dto;
#set ($className = "${jpaEntity}Dto")

import com.presiframework.common.rest.dto.CommonDto;

/**
 *
 * @author Miguel Presinal <presinal378@gmail.com>
 * @since 1.0
 */
public class $className extends CommonDto {

    private static final String OBJECT_NAME = "${jpaEntity}";

    private String name;  

    public $className() {
        super(OBJECT_NAME);
    }

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
