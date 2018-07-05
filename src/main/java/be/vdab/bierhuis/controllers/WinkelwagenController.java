package be.vdab.bierhuis.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.bierhuis.services.BestelbonService;
import be.vdab.bierhuis.valueobjects.Winkelwagen;
import be.vdab.bierhuis.valueobjects.WinkelwagenForm;

@RestController
@RequestMapping("/winkelwagen")
@SessionAttributes("winkelwagen")
public class WinkelwagenController {
	private final static String VIEW_WINKELWAGEN = "winkelwagen/winkelwagen";
	private final static String VIEW_BEVESTIGD = "winkelwagen/bevestigd";
	private final BestelbonService bestelbonService;

	public WinkelwagenController(BestelbonService bestelbonService) {
		this.bestelbonService = bestelbonService;
	}

	@GetMapping
	ModelAndView winkelwagen() {
		return new ModelAndView(VIEW_WINKELWAGEN).addObject("winkelwagenForm", new WinkelwagenForm());
	}

	@PostMapping
	ModelAndView create(@Validated WinkelwagenForm winkelwagenForm, BindingResult bindingResult,
			@ModelAttribute("winkelwagen") Winkelwagen winkelwagen) {
		if (!bindingResult.hasErrors()) {
			bestelbonService.create(winkelwagen.toBestelbon(winkelwagenForm));
			return new ModelAndView(VIEW_BEVESTIGD);
		}
		return new ModelAndView(VIEW_WINKELWAGEN);
	}
}
