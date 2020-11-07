package com.primavera.CoursProject.domain;

import java.util.HashSet;
import java.util.Set;

public class Entry {
	
	private int quantity;
	Set<IAsset> asset = new HashSet<IAsset>();

	public Entry() {

	}

	public Entry(int quantity, Set<IAsset> asset) {
		this.quantity = quantity;
		this.asset = asset;
	}

	public Set<IAsset> getAssets() {
		return asset;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setAssets(Set<IAsset> asserts) {
		this.asset = asserts;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
