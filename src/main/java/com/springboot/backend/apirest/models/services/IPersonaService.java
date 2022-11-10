package com.springboot.backend.apirest.models.services;

import java.util.List;

import com.springboot.backend.apirest.models.entities.TablaPersona;

public interface IPersonaService {

    public List<TablaPersona> findAll();
    public TablaPersona findById(Integer idPersona);
    public TablaPersona create(TablaPersona tablaPersona);
    public void delete(Integer idPersona);
    
}
