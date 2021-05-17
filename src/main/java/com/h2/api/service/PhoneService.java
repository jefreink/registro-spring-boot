package com.h2.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h2.api.entities.PhonesTokenModel;
import com.h2.api.repository.PhonesRepository;

@Service
@Transactional
public class PhoneService {
	
    @Autowired
    PhonesRepository phonesRepository;

    public void saveAll(List<PhonesTokenModel> phones){ 
       phonesRepository.saveAll(phones);
    }
}
