package com.codegym.service;

import com.codegym.model.SmartPhone;
import com.codegym.repo.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SmartphoneSerViceImpl implements ISmartphoneService{
    @Autowired
    IRepository repository;
    @Override
    public Iterable<SmartPhone> findAll() {
        return repository.findAll();
    }

    @Override
    public SmartPhone findById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return repository.save(smartPhone);
    }

    @Override
    public SmartPhone remove(Integer id) {
        SmartPhone smartPhone = repository.findOne(id);
        repository.delete(id);
        return smartPhone;
    }
}
