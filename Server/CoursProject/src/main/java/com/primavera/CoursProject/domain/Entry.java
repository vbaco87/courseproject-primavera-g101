package com.primavera.CoursProject.domain;

import java.util.HashSet;
import java.util.Set;

public class Entry {

    private double quantity;
    String type;

	public Entry() {
  }
	public Entry(double quantity,String type) {
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
