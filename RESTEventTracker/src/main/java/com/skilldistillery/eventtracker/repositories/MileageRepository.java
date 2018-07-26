package com.skilldistillery.eventtracker.repositories;

import com.skilldistillery.eventtracker.Mileage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MileageRepository extends JpaRepository<Mileage, Integer> {

}
