package com.primavera.CoursProject.domain;

import java.util.HashSet;
import java.util.Set;

public class Entry {

    private double quantity;
    Set<IAsset> assets = new HashSet<IAsset>();
    String type;

	public Entry() {

    }

    public Entry(double quantity, Set<IAsset> assets) {
        this.quantity = quantity;
        this.assets = assets;
    }

  

    public double getQuantity() {
        return quantity;
    }

  
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public Set<IAsset> getAssets() {
		return assets;
	}

	public void setAssets(Set<IAsset> assets) {
		this.assets = assets;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
