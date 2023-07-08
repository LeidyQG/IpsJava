package com.ips.ips.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ips.ips.entity.PacienteModel;

@RepositoryRestResource(collectionResourceRel = "pacientes", path = "pacientes")
public interface PacienteRepository extends PagingAndSortingRepository<PacienteModel , Long>, CrudRepository<PacienteModel , Long>{
}
