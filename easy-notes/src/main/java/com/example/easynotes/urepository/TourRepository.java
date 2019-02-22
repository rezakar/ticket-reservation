package com.example.easynotes.urepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.easynotes.umodel.Tour;

import java.util.Collection;
import java.util.List;


/**
 * Tour Repository Interface
 *
 * Created by Mary Ellen Bowman
 */
public interface TourRepository extends CrudRepository<Tour,Integer> {
    List<Tour> findByTourPackageCode(String code);
}
