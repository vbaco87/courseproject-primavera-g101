package com.primavera.CoursProject.application.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Pattern;

import com.primavera.CoursProject.domain.IAsset;

public class EntryDTO {

	private double quantity;
	@Pattern(regexp = "^(bitcoin|euros)$", message= "Tipus incorrecte. Valors acceptats: 'bitcoin', 'euros'.") 
	private String type;

	public EntryDTO() {

	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
