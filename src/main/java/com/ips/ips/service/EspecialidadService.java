package com.ips.ips.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ips.ips.entity.EspecialidadModel;
import com.ips.ips.repository.EspecialidadRepository;

@Service
public class EspecialidadService {
    @Autowired
    EspecialidadRepository especialidadRepository;

    public ArrayList<EspecialidadModel> obtenerEspecialidades(){
        return (ArrayList<EspecialidadModel>) especialidadRepository.findAll();
    }

    public Optional<EspecialidadModel> obtenerEspecialidadPorId(Long id){
        return especialidadRepository.findById(id);
    }
}
