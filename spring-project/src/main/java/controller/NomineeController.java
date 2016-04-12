package controller;

import java.util.Map;

import model.Member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.log4j.Logger;

@Controller
public final class NomineeController {
	private static final Logger log = Logger.getLogger(NomineeController.class);
	private String thanksViewName;
	public String getThanksViewName() {
		return thanksViewName;
	}
	public void setThanksViewName(String thanksViewName) {
		this.thanksViewName = thanksViewName;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Member form() { 
		return new Member();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processFormData(Member member) {
		log.info("Processing nominee: " + member);
		return thanksViewName;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void form(Model model) {
		model.addAttribute("nominee", new Member());
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String processFormData(@ModelAttribute("nominee") Member member, Model model) {
		log.info("Processing nominee: " + member);
		Map map = model.asMap();
		log.info("model[member]=" + map.get("member"));
		log.info("model[nominee]=" + map.get("nominee"));
		return thanksViewName;
	}

}
