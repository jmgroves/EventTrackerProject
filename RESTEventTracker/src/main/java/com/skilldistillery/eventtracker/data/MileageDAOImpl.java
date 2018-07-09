package com.skilldistillery.eventtracker.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skilldistilery.eventtracker.Mileage;

@Transactional
@Service
public class MileageDAOImpl implements MileageDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Mileage> index() {
		String query = "Select m from Mileage m";
		return em.createQuery(query, Mileage.class).getResultList();
	}
	
	@Override
	public double totalMilesPerGallon() {
		double totalMilesDriven = 0.0;
		double totalGallonsUsed = 0.0;
		List<Mileage> all = index();
		for (Mileage mileage : all) {
			totalMilesDriven += mileage.getMilesDriven();
			totalGallonsUsed += mileage.getGallonsUsed();
		}
		
		return totalMilesDriven / totalGallonsUsed;
		
	}

	@Override
	public Mileage getMileageById(int id) {
		return em.find(Mileage.class, id);
	}

	@Override
	public Mileage createMileage(String mileageJson) {
		Mileage mileage = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			mileage = mapper.readValue(mileageJson, Mileage.class);
			em.persist(mileage);
			em.flush();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return mileage;
	}

	@Override
	public Mileage replaceMileageById(String mileageJson, int id) {
		Mileage newMileage;
		Mileage oldMileage = em.find(Mileage.class, id);
		try {
			ObjectMapper mapper = new ObjectMapper();
			newMileage = mapper.readValue(mileageJson, Mileage.class);
			oldMileage.setGallonsUsed(newMileage.getGallonsUsed());
			oldMileage.setMilesDriven(newMileage.getMilesDriven());

			em.persist(oldMileage);
			em.flush();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return oldMileage;

	}

	@Override
	public Mileage updateMileageById(String mileageJson, int id) {
		Mileage newMileage;
		Mileage oldMileage = em.find(Mileage.class, id);
		try {
			ObjectMapper mapper = new ObjectMapper();
			newMileage = mapper.readValue(mileageJson, Mileage.class);
			if (newMileage.getGallonsUsed() != 0) {
				oldMileage.setGallonsUsed(newMileage.getGallonsUsed());
			}
			if (newMileage.getMilesDriven() != 0) {
				oldMileage.setMilesDriven(newMileage.getMilesDriven());
			}
			em.persist(oldMileage);
			em.flush();
		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return oldMileage;
	}

	@Override
	public Boolean deleteMileage(int id) {
		Mileage mileage = em.find(Mileage.class, id);
		em.remove(mileage);
		return true;
	}

}
