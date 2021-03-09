package com.tts.weatherapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.weatherapp.model.Request;
import com.tts.weatherapp.model.Response;
import com.tts.weatherapp.service.WeatherService;

@Controller
public class WeatherController {
	@Autowired
    private WeatherService weatherService;
	
	@GetMapping
	public String getIndex(Model model) {
		model.addAttribute("request", new Request()); 
		List<String> recentZips = weatherService.findMostRecent();
        model.addAttribute("recentzips", recentZips);
	    return "index";
	}
	
	@PostMapping
	public String postIndex(Request zip, Model model) {
	    Response data = weatherService.getForecast(zip.getZipCode());
	    List<String> recentZips = weatherService.findMostRecent();
	    model.addAttribute("data", data);
	    model.addAttribute("recentzips", recentZips);
	    return "index";
	}

}
