package com.swaileh.sms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swaileh.sms.models.Section;
import com.swaileh.sms.models.SectionIdentity;
import com.swaileh.sms.repositories.SectionRepository;

@Service
public class SectionService {

	@Autowired
	SectionRepository sectionRepository;
	
	
	public List<Section> getSections(){
		try{
			return sectionRepository.findAll();
		}
		catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
	
	public Section getSection(SectionIdentity sectionIdentity) {
		try{
			return sectionRepository.findById(sectionIdentity).get();
		}
		catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
	
	public Section addSection(Section section) {
		try {
			return sectionRepository.save(section);
		}
		catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
	
}
