package com.skilldistilery.eventtracker;

import javax.persistence.*;


@Entity
public class Mileage {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="miles_driven")
	private double milesDriven;
	@Column(name="gallons_used")
	private double gallonsUsed;
	
	
	//Getters and setters start 
	
	public double getMilesDriven() {
		return milesDriven;
	}
	public void setMilesDriven(double milesDriven) {
		this.milesDriven = milesDriven;
	}
	public double getGallonsUsed() {
		return gallonsUsed;
	}
	public void setGallonsUsed(double gallonsUsed) {
		this.gallonsUsed = gallonsUsed;
	}
	public int getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(gallonsUsed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		temp = Double.doubleToLongBits(milesDriven);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mileage other = (Mileage) obj;
		if (Double.doubleToLongBits(gallonsUsed) != Double.doubleToLongBits(other.gallonsUsed))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(milesDriven) != Double.doubleToLongBits(other.milesDriven))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "mileage [id=" + id + ", milesDriven=" + milesDriven + ", gallons_used=" + gallonsUsed + "]";
	}
	
	

}
