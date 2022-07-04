package com.example.qqsm.repositories;

import com.example.qqsm.model.Votar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotarRepository extends JpaRepository<Votar, Integer> {
}