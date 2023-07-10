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

import com.ips.ips.entity.MedicoModel;
import com.ips.ips.service.MedicoService;

@CrossOrigin
@RestController
@RequestMapping("/medicos")

public class MedicoController {
    @Autowired
    MedicoService medicoService;

    @GetMapping()
    public ArrayList<MedicoModel> obtenerMedicos(){
        return medicoService.obtenerMedicos();
    }

    @PostMapping()
    public MedicoModel guardarMedico(@RequestBody MedicoModel medico){
        return this.medicoService.guardarMedico(medico);
    }

    @GetMapping(path = "/{id}")
    public Optional<MedicoModel> obtenerMedicoPorId(@PathVariable("id") Long id){
        return this.medicoService.obtenerMedicoPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok=this.medicoService.eliminarMedico(id);
        if(ok){
            return "Se eliminó el médico con id: "+ id;
        }else{
            return "No se pudo encontrar el médico con id: "+ id;
        }
    }
}
