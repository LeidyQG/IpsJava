package com.ips.ips.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ips.ips.entity.MedicoModel;
import com.ips.ips.repository.MedicoRepository;

@Service
public class MedicoService {
    @Autowired
    MedicoRepository medicoRepository;

    public ArrayList<MedicoModel> obtenerMedicos(){
        return (ArrayList<MedicoModel>) medicoRepository.findAll();
    }

    public MedicoModel guardarMedico(MedicoModel medico){
        return medicoRepository.save(medico);
    }

    public Optional<MedicoModel> obtenerMedicoPorId(Long id){
        return medicoRepository.findById(id);
    }

    public boolean eliminarMedico(Long id){
        try {
            medicoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
