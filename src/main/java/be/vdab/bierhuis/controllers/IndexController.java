package be.vdab.bierhuis.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class IndexController {
	private final static String VIEW = "index";
	//private final 
	@GetMapping
	ModelAndView index() {
		return new ModelAndView(VIEW);
	}
}
