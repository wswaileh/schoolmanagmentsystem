package com.swaileh.sms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.swaileh.sms.services.SectionService;
import com.swaileh.sms.models.Section;
import com.swaileh.sms.models.SectionIdentity;

@RestController
public class SectionController {
	
	@Autowired
	SectionService sectionService;
	
	@GetMapping("/sections")
	public List<Section> getSections() {
		return sectionService.getSections();
	}
	
	@GetMapping("/sections/{class_no}/{sec_no}")
	public Section getSection(@PathVariable Integer class_no, @PathVariable Integer sec_no) {
		return sectionService.getSection(new SectionIdentity(class_no,sec_no));
	}
	
	@PostMapping("/sections")
	public Section addSection(@RequestBody Section section) {
		return sectionService.addSection(section);
	}
}
