package com.skilldistillery.eventtracker.services;

import java.util.List;

import com.skilldistillery.eventtracker.Mileage;

public interface MileageService {
	public List<Mileage> index();
	public Mileage getMileageById(int id);
	public Mileage replaceMileageById(Mileage mileage, int id);
	public Mileage updateMileageById(Mileage mileage, int id);
	public Boolean deleteMileage(int id);
	public double totalMilesPerGallon();
	public Mileage createMileage(Mileage mileage);
}
