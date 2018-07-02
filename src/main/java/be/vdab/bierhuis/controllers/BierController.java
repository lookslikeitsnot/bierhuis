package be.vdab.bierhuis.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.bierhuis.entities.Bier;
import be.vdab.bierhuis.services.BierService;

@RestController
@RequestMapping("/bieren")
public class BierController {
	private final static String VIEW_BIER = "bieren/bier";
	private final BierService bierService;
	
	public BierController(BierService bierService) {
		this.bierService = bierService;
	}
	
	@GetMapping("{bier}")
	ModelAndView bier(@PathVariable Bier bier) {
		return new ModelAndView(VIEW_BIER).addObject(bierService.findById(bier.getId()));
	}
}
