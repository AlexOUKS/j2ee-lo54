package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entity.Course;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entity.Location;

@RestController
public class LocationController {
	@RequestMapping("/courses") 
	public ArrayList<Location> locations(@RequestParam(value="id", defaultValue="all") String id, 
									 @RequestParam(value="city", defaultValue="all") String city)
	{
		return null;
	}
}
