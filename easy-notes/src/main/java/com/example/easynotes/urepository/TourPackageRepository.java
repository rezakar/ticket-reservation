package com.example.easynotes.urepository;


import org.springframework.data.repository.CrudRepository;

import com.example.easynotes.umodel.TourPackage;


/**
 * Tour Package Repository Interface
 *
 * Created by Mary Ellen Bowman
 */
public interface TourPackageRepository extends CrudRepository<TourPackage, String> {
    TourPackage findByName(String name);
    TourPackage findOne(String code);
}

