package com.codegym.repo;

import com.codegym.model.SmartPhone;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRepository extends PagingAndSortingRepository<SmartPhone,Integer> {
}
