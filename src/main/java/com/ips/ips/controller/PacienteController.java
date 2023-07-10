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

import com.ips.ips.entity.PacienteModel;
import com.ips.ips.service.PacienteService;

@CrossOrigin
@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @GetMapping()
    public ArrayList<PacienteModel> obtenerPacientes(){
        return pacienteService.obtenerPacientes();
    }

    @PostMapping(path = "/crear_paciente")
    public PacienteModel guardarPaciente(@RequestBody PacienteModel paciente){
        return this.pacienteService.guardarPaciente(paciente);
    }

    @GetMapping(path = "/{id}")
    public Optional<PacienteModel> obtenerPacientePorId(@PathVariable("id") Long id){
        return this.pacienteService.obtenerPacientePorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok=this.pacienteService.eliminarPaciente(id);
        if(ok){
            return "Se eliminó el paciente con id: "+ id;
        }else{
            return "No se pudo encontrar el paciente con id: "+ id;
        }
    }
    
}
