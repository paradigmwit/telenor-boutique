package com.telenor.boutique.repository;

import com.telenor.boutique.entity.Phones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PhonesRepository extends JpaRepository<Phones, Integer>, JpaSpecificationExecutor<Phones> {

}