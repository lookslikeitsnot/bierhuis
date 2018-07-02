package be.vdab.bierhuis.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.bierhuis.entities.Bier;
import be.vdab.bierhuis.forms.AantalForm;
import be.vdab.bierhuis.services.BierService;

@RestController
@RequestMapping("/bieren")
public class BierController {
	private final static String VIEW = "index";
	private final static String VIEW_BIER = "bieren/bier";
	private final BierService bierService;

	public BierController(BierService bierService) {
		this.bierService = bierService;
	}

	@GetMapping("{bier}")
	ModelAndView bier(@PathVariable Bier bier) {
		ModelAndView mAO = new ModelAndView(VIEW_BIER);
		Optional<Bier> optBier = bierService.findById(bier.getId());
		if (optBier.isPresent()) {
			mAO.addObject("bier", optBier.get());
			mAO.addObject("aantalForm", new AantalForm());
		}
		return mAO;
	}
	
	@PostMapping
	void addBier(@Valid AantalForm aantalForm) {
		System.out.println(aantalForm.getAantal() + " aantal bieren gereserveerd");
	}
}
