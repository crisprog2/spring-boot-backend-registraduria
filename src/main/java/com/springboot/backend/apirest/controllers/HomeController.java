package com.springboot.backend.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.apirest.models.dtos.ConsultaDto;
import com.springboot.backend.apirest.models.entities.TablaCiudad;
import com.springboot.backend.apirest.models.entities.TablaDepartamento;
import com.springboot.backend.apirest.models.entities.TablaLugarVoto;
import com.springboot.backend.apirest.models.entities.TablaMesa;
import com.springboot.backend.apirest.models.entities.TablaPersona;
import com.springboot.backend.apirest.models.services.IPersonaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping("/consulta/{cedula}")
    public ConsultaDto index(@PathVariable Integer cedula){
        ConsultaDto consultaDto=new ConsultaDto();
        TablaPersona persona=personaService.findById(cedula);

        if (persona!=null) {
            TablaMesa mesa=persona.getCod_Mesa();
            TablaLugarVoto lugarVoto=mesa.getCod_lugar();
            TablaCiudad ciudad=lugarVoto.getCod_Ciudad();
            TablaDepartamento departamento=ciudad.getCod_Departamento();
            consultaDto.setPrimerNombre(persona.getPrimerNombre());
            consultaDto.setSegundoNombre(persona.getSegundoNombre());
            consultaDto.setPrimerApellido(persona.getPrimerApellido());
            consultaDto.setSegundoApellido(persona.getSegundoApellido());
            consultaDto.setCedulaVotante(persona.getCedula());
            consultaDto.setEdadVotante(persona.getEdad());
            if(persona.getJurado().equals("Y")){
                consultaDto.setJurado("Es jurado");
            }else{
                consultaDto.setJurado("No es jurado");
            }
            consultaDto.setMesaVoto(mesa.getMesa());
            consultaDto.setLugarVoto(lugarVoto.getNombreLugar());
            consultaDto.setCiudadVoto(ciudad.getCiudad());
            consultaDto.setDepartamentoVoto(departamento.getDepartamento());
        }else{
            consultaDto=null;
        }

        return consultaDto;
    }
    
}
