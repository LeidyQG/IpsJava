package com.ips.ips.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ips.ips.entity.CitaModel;

@RepositoryRestResource(collectionResourceRel = "citas", path = "citas")
public interface CitaRepository extends PagingAndSortingRepository<CitaModel , Long>, CrudRepository<CitaModel , Long> {
    
}
