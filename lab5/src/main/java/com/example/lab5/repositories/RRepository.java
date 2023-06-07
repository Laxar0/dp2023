package com.example.lab5.repositories;

import com.example.lab5.entities.EEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RRepository extends JpaRepository<EEntity, Integer> {

}