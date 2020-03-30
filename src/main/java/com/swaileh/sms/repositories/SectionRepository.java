package com.swaileh.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaileh.sms.models.Section;
import com.swaileh.sms.models.SectionIdentity;


public interface SectionRepository extends JpaRepository<Section, SectionIdentity>{
	
	
}
