package be.vdab.bierhuis.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.bierhuis.services.BierService;

@RestController
@RequestMapping("/")
public class IndexController {
	private final static String VIEW = "index";
	private final BierService bierService;

	public IndexController(BierService bierService) {
		this.bierService = bierService;
	}

	@GetMapping
	ModelAndView index() {
		return new ModelAndView(VIEW).addObject("count", bierService.count());
	}
}
