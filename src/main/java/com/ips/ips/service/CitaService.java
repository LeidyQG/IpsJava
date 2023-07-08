package com.ips.ips.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ips.ips.entity.CitaModel;
import com.ips.ips.repository.CitaRepository;

@Service
public class CitaService {
    @Autowired
    CitaRepository citaRepository;

    public ArrayList<CitaModel> obtenerCitas(){
        return (ArrayList<CitaModel>) citaRepository.findAll();
    }

    public CitaModel guardarCita(CitaModel cita){
        return citaRepository.save(cita);
    }

    public Optional<CitaModel> obtenerCitaPorId(Long id){
        return citaRepository.findById(id);
    }

    public boolean eliminarCita(Long id){
        try {
            citaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
