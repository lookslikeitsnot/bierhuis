package be.vdab.bierhuis.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.bierhuis.entities.Brouwer;
import be.vdab.bierhuis.services.BrouwerService;

@RestController
@RequestMapping("/brouwers")
public class BrouwerController {
	private final static String VIEW_BROUWERS = "brouwers/brouwers";
	private final static String VIEW_BROUWER = "brouwers/brouwer";
	private final BrouwerService brouwerService;
	
	public BrouwerController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
	}
	
	@GetMapping
	ModelAndView brouwers() {
		return new ModelAndView(VIEW_BROUWERS).addObject("brouwers", brouwerService.findAll());
	}
	
	@GetMapping("{brouwer}")
	ModelAndView brouwer(@PathVariable Brouwer brouwer) {
		return new ModelAndView(VIEW_BROUWER).addObject(brouwerService.findById(brouwer.getId()));
	}
	
	
}
