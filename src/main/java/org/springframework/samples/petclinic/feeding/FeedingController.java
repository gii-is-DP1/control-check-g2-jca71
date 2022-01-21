package org.springframework.samples.petclinic.feeding;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/feeding")
public class FeedingController {
	@Autowired
	private FeedingService feedingService;
	
	private static final String VIEWS_Feeding_CREATE_OR_UPDATE_FORM = "feedings/createOrUpdateFeedingForm";
	
	@GetMapping(path = "/create")
	public String initCreationForm(ModelMap modelMap) {
		String view = VIEWS_Feeding_CREATE_OR_UPDATE_FORM;
		modelMap.addAttribute("feeding", new Feeding());
		modelMap.addAttribute("feedingType", feedingService.getAllFeedingTypes());
		return view;
	}
	
	@PostMapping(path = "/create")
	public String processCreationForm(@Valid Feeding Feeding, BindingResult result, ModelMap modelMap) {
		String view = "welcome";
		
		if(result.hasErrors()) {
			modelMap.addAttribute("feeding", Feeding);
			modelMap.addAttribute("feedingType", feedingService.getAllFeedingTypes());
			return VIEWS_Feeding_CREATE_OR_UPDATE_FORM;
		}else {
			feedingService.save2(Feeding);
			modelMap.addAttribute("message", "Feeding succesfully saved!");
		}
		return view;
	}
    
}
