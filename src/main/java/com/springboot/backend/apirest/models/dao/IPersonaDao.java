package com.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.apirest.models.entities.TablaPersona;

public interface IPersonaDao extends CrudRepository<TablaPersona, Integer> {
    
}
