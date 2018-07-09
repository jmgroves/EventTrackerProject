package com.skilldistillery.eventtracker.data;

import java.util.List;

import com.skilldistilery.eventtracker.Mileage;

public interface MileageDAO {
	
	public List<Mileage> index();
	public Mileage getMileageById(int id);
	public Mileage createMileage(String mileageJson);
	public Mileage replaceMileageById(String mileageJson, int id);
	public Mileage updateMileageById(String pmielageJson, int id);
	public Boolean deleteMileage(int id);
	public double totalMilesPerGallon();
}
