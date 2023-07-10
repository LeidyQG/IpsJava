package com.ips.ips.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ips.ips.entity.CitaModel;
import com.ips.ips.service.CitaService;

@CrossOrigin
@RestController
@RequestMapping("/citas")
public class CitaController {
    @Autowired
    CitaService citaService;

    @GetMapping()
    public ArrayList<CitaModel> obtenerCitas(){
        return citaService.obtenerCitas();
    }

    @PostMapping()
    public CitaModel guardarCita(@RequestBody CitaModel cita){
        return this.citaService.guardarCita(cita);
    }

    @GetMapping(path = "/{id}")
    public Optional<CitaModel> obtenerCitaPorId(@PathVariable("id") Long id){
        return this.citaService.obtenerCitaPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok=this.citaService.eliminarCita(id);
        if(ok){
            return "Se eliminó la cita con id: "+ id;
        }else{
            return "No se pudo encontrar la cita con id: "+ id;
        }
    }
}
