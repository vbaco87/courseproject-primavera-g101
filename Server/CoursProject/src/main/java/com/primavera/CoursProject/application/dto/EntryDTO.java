package com.primavera.CoursProject.application.dto;

import java.util.HashSet;
import java.util.Set;

import com.primavera.CoursProject.domain.IAsset;

public class EntryDTO {

	private double quantity;
	private String type;

	public EntryDTO() {

	}

	public EntryDTO(double quantity, String type) {
		this.quantity = quantity;
		this.type = type;
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
