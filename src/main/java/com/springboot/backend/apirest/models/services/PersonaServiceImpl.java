package com.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.apirest.models.dao.IPersonaDao;
import com.springboot.backend.apirest.models.entities.TablaPersona;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<TablaPersona> findAll() {
        return (List<TablaPersona>) personaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public TablaPersona findById(Integer idPersona) {
        return personaDao.findById(idPersona).orElse(null);
    }

    @Override
    @Transactional
    public TablaPersona create(TablaPersona tablaPersona) {
        return personaDao.save(tablaPersona);
    }

    @Override
    @Transactional
    public void delete(Integer idPersona) {
        personaDao.deleteById(idPersona);
    }
    
}
