package com.ips.ips.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ips.ips.entity.PacienteModel;
import com.ips.ips.repository.PacienteRepository;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    public ArrayList<PacienteModel> obtenerPacientes(){
        return (ArrayList<PacienteModel>) pacienteRepository.findAll();
    }

    public PacienteModel guardarPaciente(PacienteModel paciente){
        return pacienteRepository.save(paciente);
    }

    public Optional<PacienteModel> obtenerPacientePorId(Long id){
        return pacienteRepository.findById(id);
    }

    public boolean eliminarPaciente(Long id){
        try {
            pacienteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
