package be.vdab.bierhuis.controllers;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.bierhuis.entities.Brouwer;
import be.vdab.bierhuis.services.BrouwerService;
import be.vdab.exceptions.BrouwerNietGevondenException;

@RestController
@RequestMapping("/brouwers")
@EnableSpringDataWebSupport
public class BrouwerController {
	private final static String VIEW_BROUWERS = "brouwers/brouwers";
	private final static String VIEW_BROUWER = "brouwers/brouwer";
	private final BrouwerService brouwerService;

	public BrouwerController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
	}

	@GetMapping
	ModelAndView brouwers(Pageable pageable) {
		return new ModelAndView(VIEW_BROUWERS).addObject("page", brouwerService.findAll(pageable));
	}

	@GetMapping("{brouwer}")
	ModelAndView brouwer(@PathVariable Brouwer brouwer) {
		if (brouwer == null) {
			throw new BrouwerNietGevondenException();
		}
		return new ModelAndView(VIEW_BROUWER).addObject(brouwer);
	}
}
