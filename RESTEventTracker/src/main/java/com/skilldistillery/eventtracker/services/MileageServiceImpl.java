package com.skilldistillery.eventtracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.eventtracker.Mileage;
import com.skilldistillery.eventtracker.repositories.MileageRepository;

@Service
public class MileageServiceImpl implements MileageService {

	@Autowired
	private MileageRepository mileRepo;

	@Override
	public List<Mileage> index() {
		return mileRepo.findAll();
	}

	@Override
	public Mileage getMileageById(int id) {
		return mileRepo.findById(id).get();
	}

	@Override
	public Boolean deleteMileage(int id) {
		mileRepo.deleteById(id);
			return true;
			

	}

	@Override
	public double totalMilesPerGallon() {
		List<Mileage> mileages = mileRepo.findAll();
		double totalMiles = 0.0;
		double totalGallons = 0.0;
		for (Mileage mileage : mileages) {
			totalMiles += mileage.getMilesDriven();
			totalGallons += mileage.getGallonsUsed();
		}

		return totalMiles / totalGallons;
	}

	@Override
	public Mileage createMileage(Mileage mileage) {
		return mileRepo.saveAndFlush(mileage);
	}

	@Override
	public Mileage replaceMileageById(Mileage mileage, int id) {

		Optional<Mileage> getOldMile = mileRepo.findById(id);
		if (getOldMile.isPresent()) {
			Mileage oldMile = getOldMile.get();
			Mileage newMile = mileage;

			oldMile.setGallonsUsed(newMile.getGallonsUsed());
			oldMile.setGasStation(newMile.getGasStation());
			oldMile.setGallonsUsed(newMile.getGallonsUsed());
			oldMile.setComment(newMile.getComment());

			oldMile.setId(newMile.getId());
			mileRepo.saveAndFlush(oldMile);
			return oldMile;
		}
		return null;
	}

	@Override
	public Mileage updateMileageById(Mileage mileage, int id) {
		Optional<Mileage> getOldMile = mileRepo.findById(id);
		if (getOldMile.isPresent()) {
			Mileage oldMile = getOldMile.get();
			Mileage newMile = mileage;

			if (newMile.getGallonsUsed() != 0)
				oldMile.setGallonsUsed(newMile.getGallonsUsed());
			if (newMile.getGallonsUsed() != 0)
				oldMile.setGallonsUsed(newMile.getGallonsUsed());
			if (newMile.getGasStation() != null)
				oldMile.setGasStation(newMile.getGasStation());
			if (newMile.getComment() != null)
				oldMile.setComment(newMile.getComment());

			mileRepo.saveAndFlush(oldMile);
			return oldMile;
		}
		return null;
	}

}
