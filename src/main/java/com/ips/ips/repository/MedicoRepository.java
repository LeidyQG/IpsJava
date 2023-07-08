package com.ips.ips.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ips.ips.entity.MedicoModel;

@RepositoryRestResource(collectionResourceRel = "medicos", path = "medicos")
public interface MedicoRepository extends PagingAndSortingRepository<MedicoModel , Long>, CrudRepository<MedicoModel , Long> {
    
}
