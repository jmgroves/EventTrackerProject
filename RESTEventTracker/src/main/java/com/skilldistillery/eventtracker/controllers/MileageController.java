package com.skilldistillery.eventtracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.eventtracker.Mileage;
import com.skilldistillery.eventtracker.services.MileageService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4200" })

public class MileageController {
	@Autowired
	private MileageService mileServ;

	@RequestMapping(path = "ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
	  @RequestMapping(path="mileages", method=RequestMethod.GET)
	  public List<Mileage> getMileages(){ 
		  return mileServ.index();
	  }
	  @RequestMapping(path="mileages/mpg", method=RequestMethod.GET)
	  public double getMpg(){ 
		  return mileServ.totalMilesPerGallon();
	  }
	  @RequestMapping(path="mileages/{id}", method=RequestMethod.GET)
	  public Mileage getMileageById(@PathVariable int id){ 
		  return mileServ.getMileageById(id);
	  }
	
	
	  @RequestMapping(path="mileages", method=RequestMethod.POST)
	  public Mileage createMileage(@RequestBody Mileage mileageNew, HttpServletRequest request, HttpServletResponse response){ 
		  Mileage mileage = mileServ.createMileage(mileageNew); 
		  
		  if(mileage != null) {
			  response.setStatus(201);
			  return mileage;
			  
		  }
		  response.setStatus(500);
		  return mileage;
	  }
	  
	  @RequestMapping(path="mileages/{id}", method=RequestMethod.PUT)
	  public Mileage replaceMileage(@PathVariable int id, @RequestBody Mileage mileageNew, HttpServletRequest request, HttpServletResponse response){ 
		  Mileage mileage = mileServ.replaceMileageById(mileageNew, id); 
		  
		  if(mileage != null) {
			  response.setStatus(201);
			  return mileage;
			  
		  }
		  response.setStatus(500);
		  return mileage;
  }
	  @RequestMapping(path="mileages/{id}", method=RequestMethod.PATCH)
	  public Mileage updateMileageById(@PathVariable int id, @RequestBody Mileage mileageNew, HttpServletRequest request, HttpServletResponse response){ 
		  Mileage mileage = mileServ.updateMileageById(mileageNew, id); 
		  
		  if(mileage != null) {
			  response.setStatus(201);
			  return mileage;
			  
		  }
		  response.setStatus(500);
		  return mileage;
	  }
	  @RequestMapping(path="mileages/{id}", method=RequestMethod.DELETE)
	  public Boolean deleteMileage(@PathVariable int id, HttpServletRequest request, HttpServletResponse response){ 
		  boolean deleted = mileServ.deleteMileage(id); 
		  
		  if(deleted == true) {
			  response.setStatus(201);
			  return deleted;
		  }
		  response.setStatus(500);
		  return deleted;
	  }
	  
	  
  
  
  

}
		  

