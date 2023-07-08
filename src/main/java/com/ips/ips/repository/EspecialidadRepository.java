package com.ips.ips.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ips.ips.entity.EspecialidadModel;

@RepositoryRestResource(collectionResourceRel = "especialidades", path = "especialidades")
public interface EspecialidadRepository extends PagingAndSortingRepository<EspecialidadModel , Long>, CrudRepository<EspecialidadModel , Long>{
    
}
