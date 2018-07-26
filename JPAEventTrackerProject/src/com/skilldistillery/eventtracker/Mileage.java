package com.skilldistillery.eventtracker;

import javax.persistence.*;


@Entity
public class Mileage {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="miles_driven")
	private double milesDriven;
	@Column(name="gallons_filled")
	private double gallonsUsed;
	@Column(name="gas_station")
	String gasStation;
	String comment;
	
	
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
	
	public void setId(int id) {
		this.id = id;
	}
	public String getGasStation() {
		return gasStation;
	}
	public void setGasStation(String gasStation) {
		this.gasStation = gasStation;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		long temp;
		temp = Double.doubleToLongBits(gallonsUsed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((gasStation == null) ? 0 : gasStation.hashCode());
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
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (Double.doubleToLongBits(gallonsUsed) != Double.doubleToLongBits(other.gallonsUsed))
			return false;
		if (gasStation == null) {
			if (other.gasStation != null)
				return false;
		} else if (!gasStation.equals(other.gasStation))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(milesDriven) != Double.doubleToLongBits(other.milesDriven))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Mileage [id=" + id + ", milesDriven=" + milesDriven + ", gallonsUsed=" + gallonsUsed + ", gasStation="
				+ gasStation + ", comment=" + comment + "]";
	}
	
	

}
