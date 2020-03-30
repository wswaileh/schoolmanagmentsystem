package com.swaileh.sms.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@Embeddable
public class SectionIdentity implements Serializable{
	
	@NotNull
	private Integer class_no;
	
	@NotNull
	private Integer sec_no;

	public SectionIdentity() {
	}

	public SectionIdentity(@NotNull Integer class_no, @NotNull Integer sec_no) {
		this.class_no = class_no;
		this.sec_no = sec_no;
	}

	public Integer getClass_no() {
		return class_no;
	}

	public void setClass_no(Integer class_no) {
		this.class_no = class_no;
	}

	public Integer getSec_no() {
		return sec_no;
	}

	public void setSec_no(Integer sec_no) {
		this.sec_no = sec_no;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionIdentity that = (SectionIdentity) o;

        if (!class_no.equals(that.class_no)) return false;
        return sec_no.equals(that.sec_no);
    }
    
}
