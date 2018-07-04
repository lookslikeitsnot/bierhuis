package be.vdab.bierhuis.controllers;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.bierhuis.entities.Bier;
import be.vdab.bierhuis.valueobjects.Winkelwagen;
import be.vdab.bierhuis.valueobjects.Winkelwagenlijn;

@RestController
@RequestMapping("/bieren")
@SessionAttributes("winkelwagen")
public class BierController {

	private final static String VIEW = "index";
	private final static String VIEW_BIER = "bieren/bier";
	private final static String VIEW_WINKELWAGEN = "winkelwagen/winkelwagen";

	@GetMapping
	ModelAndView index() {
		return new ModelAndView(VIEW);
	}

	@GetMapping("{bier}")
	ModelAndView bier(@PathVariable Bier bier) {
		return new ModelAndView(VIEW_BIER).addObject("bier", bier).addObject("winkelwagenlijn", new Winkelwagenlijn());
	}

	@PostMapping("{bier}")
	ModelAndView addBier(@PathVariable Bier bier, @Valid Winkelwagenlijn winkelwagenlijn, BindingResult bindingResult,
			@ModelAttribute("winkelwagen") Winkelwagen winkelwagen) {
		if (!bindingResult.hasErrors()) {
			winkelwagen.add(winkelwagenlijn);
			return new ModelAndView(VIEW_WINKELWAGEN);
		}
		return bier(bier);
	}

	@ModelAttribute("winkelwagen")
	public Winkelwagen winkelwagen() {
		return new Winkelwagen();
	}
}
