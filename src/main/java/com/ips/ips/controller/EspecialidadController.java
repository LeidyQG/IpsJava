package com.ips.ips.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ips.ips.entity.EspecialidadModel;
import com.ips.ips.service.EspecialidadService;

@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {
    @Autowired
    EspecialidadService especialidadService;

    @GetMapping()
    public ArrayList<EspecialidadModel> obtenerEspecialidades(){
        return especialidadService.obtenerEspecialidades();
    }

    @GetMapping(path = "/{id}")
    public Optional<EspecialidadModel> obtenerEspecialidadPorId(@PathVariable("id") Long id){
        return this.especialidadService.obtenerEspecialidadPorId(id);
    }
}
