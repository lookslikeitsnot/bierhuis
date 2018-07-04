package be.vdab.bierhuis.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.bierhuis.services.BierService;
import be.vdab.bierhuis.valueobjects.WinkelwagenForm;

@RestController
@RequestMapping("/winkelwagen")
//@SessionAttributes("winkelwagen")
public class WinkelwagenController {
	private final static String VIEW_WINKELWAGEN = "winkelwagen/winkelwagen";
	private final BierService bierService;

	public WinkelwagenController(BierService bierService) {
		this.bierService = bierService;
	}
	
	@GetMapping
	ModelAndView winkelwagen() {
		return new ModelAndView(VIEW_WINKELWAGEN).addObject("winkelwagenForm", new WinkelwagenForm());
	}
}
