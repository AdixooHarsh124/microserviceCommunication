package com.example.subscriberMain.subcribeRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.subscriberMain.Model.subscriberModel;

@Repository
public interface subscriberRepository extends JpaRepository<subscriberModel,Integer>{

}
