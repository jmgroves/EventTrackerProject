package com.skilldistillery.eventtracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistilery.eventtracker.Mileage;
import com.skilldistillery.eventtracker.data.MileageDAO;

@RestController
@RequestMapping("api")
public class MileageController {
	@Autowired
	private MileageDAO mileageDAO;

	@RequestMapping(path = "ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
	  @RequestMapping(path="mileages", method=RequestMethod.GET)
	  public List<Mileage> getMileages(){ 
		  return mileageDAO.index();
	  }
	  @RequestMapping(path="mileages/{id}", method=RequestMethod.GET)
	  public Mileage getMileageById(@PathVariable int id){ 
		  return mileageDAO.getMileageById(id);
	  }
	
	
	  @RequestMapping(path="mileages", method=RequestMethod.POST)
	  public Mileage createMileage(@RequestBody String jsonMileage, HttpServletRequest request, HttpServletResponse response){ 
		  Mileage mileage = mileageDAO.createMileage(jsonMileage); 
		  
		  if(mileage != null) {
			  response.setStatus(201);
			  return mileage;
			  
		  }
		  response.setStatus(500);
		  return mileage;
	  }
	  
	  @RequestMapping(path="mileages/{id}", method=RequestMethod.PUT)
	  public Mileage replaceMileage(@PathVariable int id, @RequestBody String jsonMileage, HttpServletRequest request, HttpServletResponse response){ 
		  Mileage mileage = mileageDAO.replaceMileageById(jsonMileage, id); 
		  
		  if(mileage != null) {
			  response.setStatus(201);
			  return mileage;
			  
		  }
		  response.setStatus(500);
		  return mileage;
  }
	  @RequestMapping(path="mileages/{id}", method=RequestMethod.PATCH)
	  public Mileage updateMileageById(@PathVariable int id, @RequestBody String jsonMileage, HttpServletRequest request, HttpServletResponse response){ 
		  Mileage mileage = mileageDAO.updateMileageById(jsonMileage, id); 
		  
		  if(mileage != null) {
			  response.setStatus(201);
			  return mileage;
			  
		  }
		  response.setStatus(500);
		  return mileage;
	  }
	  @RequestMapping(path="mileages/{id}", method=RequestMethod.DELETE)
	  public Boolean deleteMileage(@PathVariable int id, HttpServletRequest request, HttpServletResponse response){ 
		  boolean deleted = mileageDAO.deleteMileage(id); 
		  
		  if(deleted == true) {
			  response.setStatus(201);
			  return deleted;
		  }
		  response.setStatus(500);
		  return deleted;
	  }
	  
	  
  
  
  

}
		  

