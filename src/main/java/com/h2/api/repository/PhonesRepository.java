package com.h2.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.h2.api.entities.PhonesTokenModel;

public interface PhonesRepository extends JpaRepository<PhonesTokenModel, Integer> {

//	Optional<PhonesModel> findByPhones(PhonesModel phones);

//	Optional<PhonesModel> findByUserId(PhonesModel phones);

}