package com.example.inadn.demo.controller.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.inadn.demo.model.impl.Parking;

@Repository
public interface ParkingRepository extends CrudRepository<Parking, Integer>{
}
