package controller;

import java.util.ArrayList;
import java.util.List;

import model.Member;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import addtional.sping.TinhToan;

@Controller
public class RosterController {
	final static Logger logger = Logger.getLogger(RosterController.class);
	private List<Member> members = new ArrayList<Member>();
	public RosterController() {
		int a = addtional.sping.Math.addnumber(1, 2);
		TinhToan.Compute();
		if(logger.isDebugEnabled()){
		    logger.debug("This is debug");
		}
		members.add(new Member("John", "Lennon"));
		members.add(new Member("Steve", "Jobs"));
		members.add(new Member("Bill", "Gate"));
	}
	
	@RequestMapping
	public void list(Model model) {
		model.addAttribute(members);
	}
	
	@RequestMapping
	public void member(@RequestParam("id") Integer id, Model model) {
		model.addAttribute(members.get(id));
	}
}
